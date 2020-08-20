package com.ruoyi.equipment.domain;

/**
 * 平台推送数据
 */
public class PushEData {

    /**
     * 通知类型 目前为 deviceDataChanged
     */
    private String notifyType;

    /**
     *备用，默认为 null
     */
    private String requestId;

    /**
     *NB 设备为 IMEI
     */
    private String deviceId;

    /**
     *目前与 deviceId 一致
     */
    private String gatewayId;

    private PushEDataService service;


    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public PushEDataService getService() {
        return service;
    }

    public void setService(PushEDataService service) {
        this.service = service;
    }
}
