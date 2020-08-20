package com.ruoyi.equipment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备数据对象 e_data
 * 
 * @author lxl
 * @date 2020-03-10
 */
public class EData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 即为 IMEI 号，唯一 */
    @Excel(name = "即为 IMEI 号，唯一")
    private String equipmentId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 68 为报警帧，69 为心跳帧 */
    @Excel(name = "68 为报警帧，69 为心跳帧")
    private Long messageId;

    /** 信息类型: “Heartbeat”为心跳帧; “Alarm”为报警帧; */
    @Excel(name = "信息类型: “Heartbeat”为心跳帧; “Alarm”为报警帧;")
    private String messageType;

    /** 产品的生产编号 */
    @Excel(name = "产品的生产编号")
    private Long sn;

    /** x 轴报警标志位:0 为未报警，1 为报警; */
    @Excel(name = "x 轴报警标志位:0 为未报警，1 为报警;")
    private Long alarmX;

    /** x 轴角度 */
    @Excel(name = "x 轴角度")
    private Long angleX;

    /** y 轴报警标志位:0 为未报警，1 为报警; */
    @Excel(name = "y 轴报警标志位:0 为未报警，1 为报警;")
    private Long alarmY;

    /** y 轴角度 */
    @Excel(name = "y 轴角度")
    private Long angleY;

    /** 电源电压 */
    @Excel(name = "电源电压")
    private Long power;

    /** 累加和校验 */
    @Excel(name = "累加和校验")
    private Long checksum;

    /** 时间 */
    @Excel(name = "时间")
    private String eventtime;

    /** 部门状态（0正常 1停用） */
    @Excel(name = "部门状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEquipmentId(String equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentId() 
    {
        return equipmentId;
    }
    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }
    public void setMessageId(Long messageId) 
    {
        this.messageId = messageId;
    }

    public Long getMessageId() 
    {
        return messageId;
    }
    public void setMessageType(String messageType) 
    {
        this.messageType = messageType;
    }

    public String getMessageType() 
    {
        return messageType;
    }
    public void setSn(Long sn) 
    {
        this.sn = sn;
    }

    public Long getSn() 
    {
        return sn;
    }
    public void setAlarmX(Long alarmX) 
    {
        this.alarmX = alarmX;
    }

    public Long getAlarmX() 
    {
        return alarmX;
    }
    public void setAngleX(Long angleX) 
    {
        this.angleX = angleX;
    }

    public Long getAngleX() 
    {
        return angleX;
    }
    public void setAlarmY(Long alarmY) 
    {
        this.alarmY = alarmY;
    }

    public Long getAlarmY() 
    {
        return alarmY;
    }
    public void setAngleY(Long angleY) 
    {
        this.angleY = angleY;
    }

    public Long getAngleY() 
    {
        return angleY;
    }
    public void setPower(Long power) 
    {
        this.power = power;
    }

    public Long getPower() 
    {
        return power;
    }
    public void setChecksum(Long checksum) 
    {
        this.checksum = checksum;
    }

    public Long getChecksum() 
    {
        return checksum;
    }
    public void setEventtime(String eventtime) 
    {
        this.eventtime = eventtime;
    }

    public String getEventtime() 
    {
        return eventtime;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("equipmentId", getEquipmentId())
            .append("equipmentName", getEquipmentName())
            .append("messageId", getMessageId())
            .append("messageType", getMessageType())
            .append("sn", getSn())
            .append("alarmX", getAlarmX())
            .append("angleX", getAngleX())
            .append("alarmY", getAlarmY())
            .append("angleY", getAngleY())
            .append("power", getPower())
            .append("checksum", getChecksum())
            .append("eventtime", getEventtime())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
