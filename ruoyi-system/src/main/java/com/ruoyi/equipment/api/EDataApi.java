package com.ruoyi.equipment.api;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.equipment.domain.EData;
import com.ruoyi.equipment.domain.PushEData;
import com.ruoyi.equipment.domain.PushEDataData;
import com.ruoyi.equipment.domain.PushEDataService;
import org.springframework.stereotype.Component;

@Component
public class EDataApi {

    public static final String apiUrl = "http://iot.zc-sensor.com/nbiot/informationApi/getCurrentData.shtml";

    /**
     * 根据设备的 IMEI 号获取设备数据
     * @param equipmentId
     * @return
     */
     public EData getEDataByEId(String equipmentId){

         String result = HttpUtils.sendGet(apiUrl,"equipmentId="+equipmentId);

         EData eData  = JSON.parseObject(result,EData.class);

         return eData;
     }

     public static void main(String args[]){
         EDataApi eDataApi = new EDataApi();
         EData eData = eDataApi.getEDataByEId("869858035168096");
         System.out.println(eData.getId() == null);

         PushEData pushEData = new PushEData();
         PushEDataService pushEDataService = new PushEDataService();
         pushEData.setService(pushEDataService);
         PushEDataData pushEDataData = new PushEDataData();
         pushEDataService.setData(pushEDataData);

         System.out.println(JSON.toJSONString(pushEData));
     }
}
