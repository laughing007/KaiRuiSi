package com.ruoyi.equipment.task;


import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.equipment.api.EDataApi;
import com.ruoyi.equipment.domain.EData;
import com.ruoyi.equipment.domain.EDetail;
import com.ruoyi.equipment.domain.PushEData;
import com.ruoyi.equipment.service.IEDataService;
import com.ruoyi.equipment.service.IEDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 定时获取设备数据
 * 
 * @author lxl
 */
@Component("eDataTask")
public class EDataTask {

    protected final Logger logger = LoggerFactory.getLogger(EDataTask.class);

    @Autowired
    private IEDetailService eDetailService;

    @Autowired
    private IEDataService eDataService;

    @Autowired
    private EDataApi eDataApi;

    /**
     * 定时获取设备数据,修改设备状态
     */
    public void getEDataByEquipmentId(){

        EDetail eDetail = new EDetail();

        List<EDetail> list = eDetailService.selectEDetailListForJob(eDetail);

        for(EDetail detail : list){

            updateEq(detail);

        }

    }

    /**
     * 处理接口推送数据
     * @param pushEData
     */
    @Transactional(rollbackFor = Exception.class)
    public void dealPlatformData(PushEData pushEData){

        logger.info("io平台推送数据为:"+JSON.toJSONString(pushEData));

       if(pushEData ==null){
           return ;
       }
       if("deviceDataChanged".equals(pushEData.getNotifyType())){
           if("Alarm".equals(pushEData.getService().getServiceType())){
               int axis = pushEData.getService().getData().getAlarmAxis();
               //有报警信息
               if(axis == 1 || axis == 2 || axis == 3){
                   //将设备修改为报警状态
                   String imei = pushEData.getDeviceId();
                   EDetail eDetail = new EDetail();
                   eDetail.setEquipmentId(imei);
                   eDetail.setDelFlag("0");
                   List<EDetail> list = eDetailService.selectEDetailListForJob(eDetail);
                   if(list != null && list.size() == 1){
                       EDetail detail = list.get(0);
                       detail.setReportStatus("1");
                       eDetailService.updateEDetail(detail);
                       updateEq(detail);
                   }


               }
           }
       }


    }

    /**
     * 请求接口判断设备状态
     * @param detail
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateEq(EDetail detail){
        //获取设备数据,从api获取数据
        EData eData = eDataApi.getEDataByEId(detail.getEquipmentId());
        //判断是否有数据和是否报警
        if(eData.getId() == null){
            //修改为离线状态和预警否状态
            detail.seteStatus("1");
            detail.setReportStatus("0");
            eDetailService.updateEDetail(detail);
        }

        if(eData.getId() != null){
            //判断是否存在该条数据
            EData data = eDataService.selectEDataById(eData.getId());
            if(data == null){
                eDataService.insertEData(eData);
                if(eData.getAlarmX() == 1 || eData.getAlarmY() == 1){
                    //修改为报警状态和在线状态
                    detail.seteStatus("0");
                    detail.setReportStatus("1");

                }else{
                    detail.seteStatus("0");
                    detail.setReportStatus("0");
                }
                eDetailService.updateEDetail(detail);
            }
        }
    }
}
