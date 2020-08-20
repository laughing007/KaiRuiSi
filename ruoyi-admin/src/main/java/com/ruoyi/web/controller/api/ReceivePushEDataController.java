package com.ruoyi.web.controller.api;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.equipment.domain.PushEData;
import com.ruoyi.equipment.task.EDataTask;
import com.ruoyi.framework.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 接收推送的设备信息数据
 * 
 * @author lxl
 */
@Controller
public class ReceivePushEDataController extends BaseController
{

    @Autowired
    private EDataTask eDataTask;


    @PostMapping("/api/receivePushEData")
    @ResponseBody
    public void receivePushEData(@RequestBody PushEData pushEData)
    {
        eDataTask.dealPlatformData(pushEData);

    }

}
