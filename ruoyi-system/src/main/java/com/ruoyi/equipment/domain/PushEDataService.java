package com.ruoyi.equipment.domain;

/**
 * 平台推送数据
 */
public class PushEDataService {

    /**
     * 有以下两种取值: (a) Heartbeat:心跳 (b) Alarm:报警
     */
    private String serviceId;

    /**
     *有以下两种取值: (a) Heartbeat:心跳 (b) Alarm:报警
     */
    private String serviceType;

    private PushEDataData data;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public PushEDataData getData() {
        return data;
    }

    public void setData(PushEDataData data) {
        this.data = data;
    }
}
