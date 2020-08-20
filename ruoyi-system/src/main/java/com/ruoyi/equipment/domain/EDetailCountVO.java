package com.ruoyi.equipment.domain;

import java.util.List;

public class EDetailCountVO {

    private String totalCount;

    private String onlineCount;

    private String offlineCount;

    private String alarmCount;

    private List<EDetail> list;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(String alarmCount) {
        this.alarmCount = alarmCount;
    }

    public String getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(String onlineCount) {
        this.onlineCount = onlineCount;
    }

    public String getOfflineCount() {
        return offlineCount;
    }

    public void setOfflineCount(String offlineCount) {
        this.offlineCount = offlineCount;
    }

    public List<EDetail> getList() {
        return list;
    }

    public void setList(List<EDetail> list) {
        this.list = list;
    }
}
