package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private ISysDeptService sysDeptService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        //取出用户所属的公司的组织结构
        SysDept sysDept = getUserCompanyByDeptId(user.getDeptId());
        if(sysDept != null){
//            if(sysDept.getAvatar() == null){
////                sysDept.setAvatar("");
////            }
            mmap.put("company",sysDept);
        }else{
            SysDept company = new SysDept();
            company.setDeptName("");
            company.setAvatar("");
            mmap.put("company",company);
        }
        return "index";
    }

    /**
     * 获取部门所属公司
     * @param deptId
     * @return
     */
    public SysDept getUserCompanyByDeptId(long deptId){

        SysDept sysDept =sysDeptService.selectDeptById(deptId);
        if(sysDept != null){
            if(sysDept.getParentId() == 100){
                return sysDept;
            }else{
                return getUserCompanyByDeptId(sysDept.getParentId());
            }
        }else{
            return null;
        }
    }



    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin(ModelMap mmap)
    {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return "main";
    }
}
