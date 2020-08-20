package com.ruoyi.web.controller.equipment;

import java.util.List;

import com.ruoyi.equipment.domain.EDataCountVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.equipment.domain.EData;
import com.ruoyi.equipment.service.IEDataService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备数据Controller
 * 
 * @author lxl
 * @date 2020-03-10
 */
@Controller
@RequestMapping("/equipment/data")
public class EDataController extends BaseController
{
    private String prefix = "equipment/data";

    @Autowired
    private IEDataService eDataService;

    @GetMapping("/{equipmentId}")
    public String data(ModelMap model,@PathVariable("equipmentId") String equipmentId)
    {
        model.put("equipmentId",equipmentId);

        return prefix + "/data";
    }

    /**
     * 查询设备数据列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EData eData)
    {
        startPage();
        List<EData> list = eDataService.selectEDataList(eData);
        return getDataTable(list);
    }

    /**
     * 导出设备数据列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EData eData)
    {
        List<EData> list = eDataService.selectEDataList(eData);
        ExcelUtil<EData> util = new ExcelUtil<EData>(EData.class);
        return util.exportExcel(list, "data");
    }

    /**
     * 新增设备数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备数据
     */
    @Log(title = "设备数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EData eData)
    {
        return toAjax(eDataService.insertEData(eData));
    }

    /**
     * 修改设备数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EData eData = eDataService.selectEDataById(id);
        mmap.put("eData", eData);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备数据
     */
    @Log(title = "设备数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EData eData)
    {
        return toAjax(eDataService.updateEData(eData));
    }

    /**
     * 删除设备数据
     */
    @Log(title = "设备数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eDataService.deleteEDataByIds(ids));
    }

    @GetMapping("/selectInformationCount")
    @ResponseBody
    public EDataCountVO selectInformationCount(){
       return eDataService.selectCountData(new EData());
    }

}
