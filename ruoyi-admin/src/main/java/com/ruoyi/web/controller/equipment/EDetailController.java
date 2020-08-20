package com.ruoyi.web.controller.equipment;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.equipment.domain.EData;
import com.ruoyi.equipment.domain.EDetail;
import com.ruoyi.equipment.domain.EDetailCountVO;
import com.ruoyi.equipment.service.IEDataService;
import com.ruoyi.equipment.service.IEDetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备Controller
 *
 * @author lxl
 * @date 2020-03-10
 */
@Controller
@RequestMapping("/equipment/detail")
public class EDetailController extends BaseController {
    private String prefix = "equipment/detail";

    @Autowired
    private IEDetailService eDetailService;
    @Autowired
    private IEDataService eDataService;

    @RequiresPermissions("equipment:detail:view")
    @GetMapping()
    public String detail() {
        return prefix + "/detail";
    }

    /**
     * 查询设备列表
     */
    @RequiresPermissions("equipment:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EDetail eDetail) {
        startPage();
        List<EDetail> list = eDetailService.selectEDetailList(eDetail);
        return getDataTable(list);
    }

    /**
     * 导出设备列表
     */
    @RequiresPermissions("equipment:detail:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EDetail eDetail) {
        List<EDetail> list = eDetailService.selectEDetailList(eDetail);
        ExcelUtil<EDetail> util = new ExcelUtil<EDetail>(EDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 新增设备
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存设备
     */
    @RequiresPermissions("equipment:detail:add")
    @Log(title = "设备", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EDetail eDetail) {
        return toAjax(eDetailService.insertEDetail(eDetail));
    }

    /**
     * 修改设备
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        EDetail eDetail = eDetailService.selectEDetailById(id);
        mmap.put("eDetail", eDetail);
        return prefix + "/edit";
    }

    /**
     * 修改设备
     */
    @GetMapping("/brokenLine/{id}")
    public String brokenLine(@PathVariable("id") Long id, ModelMap mmap) {
        EDetail eDetail = eDetailService.selectEDetailById(id);
        mmap.put("eDetail", eDetail);
        //组装折线图数据
        EData eData = new EData();
        eData.setEquipmentId(eDetail.getEquipmentId());
        List<EData> dataList = eDataService.selectEDataList(eData);
//        List<String> timeList = new ArrayList<>();
        StringBuffer timeSb = new StringBuffer();
        StringBuffer xList = new StringBuffer();
        StringBuffer  yList = new StringBuffer();
        Integer xMax = 0;
        Integer xMin = 0;
        Integer yMax = 0;
        Integer yMin = 0;
        for (EData data : dataList) {
            if (xMax - data.getAngleX() <= 0) {
                xMax = data.getAngleX().intValue();
            }
            if (xMin - data.getAngleX() >= 0) {
                xMin = data.getAngleX().intValue();
            }
            if (yMax - data.getAngleY() <= 0) {
                yMax = data.getAngleY().intValue();
            }
            if (yMin - data.getAngleY() >= 0) {
                yMin = data.getAngleY().intValue();
            }
            timeSb.append(data.getEventtime()).append(",");
            xList.append(data.getAngleX()).append(",");
            yList.append(data.getAngleY()).append(",");
        }
        mmap.put("timeMap", timeSb.length() > 0 ? timeSb.substring(0, timeSb.length() - 1) : "");
        mmap.put("xList", xList.length() > 0 ? xList.substring(0, xList.length() - 1) : "");
        mmap.put("yList", yList.length() > 0 ? yList.substring(0, yList.length() - 1) : "");

        mmap.put("xMax", xMax);
        mmap.put("xMin", xMin);
        mmap.put("yMax", yMax);
        mmap.put("yMin", yMin);
        return prefix + "/brokenLine";
    }

    /**
     * 修改保存设备
     */
    @RequiresPermissions("equipment:detail:edit")
    @Log(title = "设备", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EDetail eDetail) {
        return toAjax(eDetailService.updateEDetail(eDetail));
    }

    /**
     * 删除设备
     */
    @RequiresPermissions("equipment:detail:remove")
    @Log(title = "设备", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eDetailService.deleteEDetailByIds(ids));
    }

    @GetMapping("/selectEquipmentAll")
    @ResponseBody
    public EDetailCountVO selectEquipmentAll() {
        EDetailCountVO eDetailCountVO = eDetailService.selectCountDetail(new EDetail());
        EDetail eDetail = new EDetail();
        List<EDetail> list = eDetailService.selectEDetailList(eDetail);
        eDetailCountVO.setList(list);
        return eDetailCountVO;
    }

    @PostMapping("/handleAlarm")
    @ResponseBody
    public AjaxResult handleAlarm(long id) {
        EDetail eDetail = eDetailService.selectEDetailById(id);
        eDetail.setReportStatus("0");
        eDetailService.updateEDetail(eDetail);

        return success("处理成功");

    }
}
