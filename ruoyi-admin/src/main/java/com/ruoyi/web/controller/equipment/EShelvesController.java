package com.ruoyi.web.controller.equipment;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.equipment.domain.EShelves;
import com.ruoyi.equipment.service.IEShelvesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author lxl
 * @date 2020-05-11
 */
@Controller
@RequestMapping("/equipment/shelves")
public class EShelvesController extends BaseController
{
    private String prefix = "equipment/shelves";

    @Autowired
    private IEShelvesService eShelvesService;

    @RequiresPermissions("equipment:shelves:view")
    @GetMapping()
    public String shelves()
    {
        return prefix + "/shelves";
    }

    @GetMapping("/shelvesDialog")
    public String shelvesDialog()
    {
        return prefix + "/shelves_dialog";
    }

    @GetMapping("/shelveDetail")
    public String shelveDetail(Long shelveId, ModelMap mmap)
    {

        EShelves eShelves = eShelvesService.selectEShelvesById(shelveId);
        mmap.put("eShelves", eShelves);
        return prefix + "/shelve_detail";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("equipment:shelves:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EShelves eShelves)
    {
        startPage();
        List<EShelves> list = eShelvesService.selectEShelvesList(eShelves);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("equipment:shelves:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EShelves eShelves)
    {
        List<EShelves> list = eShelvesService.selectEShelvesList(eShelves);
        ExcelUtil<EShelves> util = new ExcelUtil<EShelves>(EShelves.class);
        return util.exportExcel(list, "shelves");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("equipment:shelves:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EShelves eShelves)
    {
        return toAjax(eShelvesService.insertEShelves(eShelves));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EShelves eShelves = eShelvesService.selectEShelvesById(id);
        mmap.put("eShelves", eShelves);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("equipment:shelves:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EShelves eShelves)
    {
        return toAjax(eShelvesService.updateEShelves(eShelves));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("equipment:shelves:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eShelvesService.deleteEShelvesByIds(ids));
    }
}
