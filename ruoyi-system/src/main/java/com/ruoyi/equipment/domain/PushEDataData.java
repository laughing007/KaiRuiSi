package com.ruoyi.equipment.domain;

/**
 * 平台推送数据
 */
public class PushEDataData {

    /**
     * 序列号
     */
    private String sn;

    /**
     * 产品类型
     */
    private int productType;

    /**
     *X 轴角度 单位:度
     */
    private float xAxisAngle;

    /**
     *
     */
    private float yAxisAngle;

    /**
     *温度 单位:摄氏度
     */
    private float temperature;

    /**
     *电压 单位:V
     */
    private float voltage;

    /**
     *建防使能 0:撤防
     * 1:建防
     */
    private int defenseEnable;

    /**
     *信号强度
     */
    private int signalIntensity;

    /**
     *工作模式 0:绝对模式 1:相对模式 2:振动模式
     */
    private int workPattern;

    /**
     *报警轴 0:x 轴未报警，y 轴未报警; 1:x 轴报警，y 轴未报警 2:x 轴未报警，y 轴报警 3:x 轴报警，y 轴报警
     */
    private int alarmAxis;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public float getxAxisAngle() {
        return xAxisAngle;
    }

    public void setxAxisAngle(float xAxisAngle) {
        this.xAxisAngle = xAxisAngle;
    }

    public float getyAxisAngle() {
        return yAxisAngle;
    }

    public void setyAxisAngle(float yAxisAngle) {
        this.yAxisAngle = yAxisAngle;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }

    public int getDefenseEnable() {
        return defenseEnable;
    }

    public void setDefenseEnable(int defenseEnable) {
        this.defenseEnable = defenseEnable;
    }

    public int getSignalIntensity() {
        return signalIntensity;
    }

    public void setSignalIntensity(int signalIntensity) {
        this.signalIntensity = signalIntensity;
    }

    public int getWorkPattern() {
        return workPattern;
    }

    public void setWorkPattern(int workPattern) {
        this.workPattern = workPattern;
    }

    public int getAlarmAxis() {
        return alarmAxis;
    }

    public void setAlarmAxis(int alarmAxis) {
        this.alarmAxis = alarmAxis;
    }
}
