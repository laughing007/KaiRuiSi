package com.ruoyi.equipment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备对象 e_detail
 * 
 * @author lxl
 * @date 2020-03-10
 */
public class EDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 设备编号即为 IMEI 号，唯一 */
    @Excel(name = "设备编号即为 IMEI 号，唯一")
    private String equipmentId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String type;

    /** 厂商 */
    @Excel(name = "厂商")
    private String firm;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private Long deptId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String deptName;


    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**设备状态0在线1离线 */
    private String eStatus;

    /**报警状态0否1是 */
    private String reportStatus;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    private Long shelveId;

    private String shelveName;

    private int shelveX;

    private int shelveY;

    private int sR;

    private int sC;

    public int getsR() {
        return sR;
    }

    public void setsR(int sR) {
        this.sR = sR;
    }

    public int getsC() {
        return sC;
    }

    public void setsC(int sC) {
        this.sC = sC;
    }

    public Long getShelveId() {
        return shelveId;
    }

    public void setShelveId(Long shelveId) {
        this.shelveId = shelveId;
    }

    public String getShelveName() {
        return shelveName;
    }

    public void setShelveName(String shelveName) {
        this.shelveName = shelveName;
    }

    public int getShelveX() {
        return shelveX;
    }

    public void setShelveX(int shelveX) {
        this.shelveX = shelveX;
    }

    public int getShelveY() {
        return shelveY;
    }

    public void setShelveY(int shelveY) {
        this.shelveY = shelveY;
    }

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

    public String geteStatus() {
        return eStatus;
    }

    public void seteStatus(String eStatus) {
        this.eStatus = eStatus;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setFirm(String firm) 
    {
        this.firm = firm;
    }

    public String getFirm() 
    {
        return firm;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setLongitude(String longitude) 
    {
        this.longitude = longitude;
    }

    public String getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(String latitude) 
    {
        this.latitude = latitude;
    }

    public String getLatitude() 
    {
        return latitude;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("equipmentId", getEquipmentId())
            .append("equipmentName", getEquipmentName())
            .append("type", getType())
            .append("firm", getFirm())
            .append("deptId", getDeptId())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("address", getAddress())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
