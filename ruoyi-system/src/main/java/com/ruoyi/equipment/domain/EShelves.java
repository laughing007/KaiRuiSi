package com.ruoyi.equipment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 e_shelves
 * 
 * @author lxl
 * @date 2020-05-11
 */
public class EShelves extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 货架名称 */
    @Excel(name = "货架名称")
    private String code;

    /** 行 */
    @Excel(name = "行")
    private Long sR;

    /** 列 */
    @Excel(name = "列")
    private Long sC;

    private Long deptId;

    @Excel(name="部门名称")
    private String deptName;


    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setSR(Long sR) 
    {
        this.sR = sR;
    }

    public Long getSR() 
    {
        return sR;
    }
    public void setSC(Long sC) 
    {
        this.sC = sC;
    }

    public Long getSC() 
    {
        return sC;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("sR", getSR())
            .append("sC", getSC())
            .toString();
    }
}
