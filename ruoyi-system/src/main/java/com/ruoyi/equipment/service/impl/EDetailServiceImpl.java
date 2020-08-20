package com.ruoyi.equipment.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.equipment.domain.EDetailCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.equipment.mapper.EDetailMapper;
import com.ruoyi.equipment.domain.EDetail;
import com.ruoyi.equipment.service.IEDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备Service业务层处理
 * 
 * @author lxl
 * @date 2020-03-10
 */
@Service
public class EDetailServiceImpl implements IEDetailService 
{
    @Autowired
    private EDetailMapper eDetailMapper;

    /**
     * 查询设备
     * 
     * @param id 设备ID
     * @return 设备
     */
    @Override
    public EDetail selectEDetailById(Long id)
    {
        return eDetailMapper.selectEDetailById(id);
    }

    /**
     * 查询设备列表
     * 
     * @param eDetail 设备
     * @return 设备
     */
    @Override
    @DataScope(deptAlias = "e")
    public List<EDetail> selectEDetailList(EDetail eDetail)
    {
        return eDetailMapper.selectEDetailList(eDetail);
    }

    @Override
    public List<EDetail> selectEDetailListForJob(EDetail eDetail)
    {
        return eDetailMapper.selectEDetailList(eDetail);
    }

    /**
     * 新增设备
     * 
     * @param eDetail 设备
     * @return 结果
     */
    @Override
    public int insertEDetail(EDetail eDetail)
    {
        EDetail e = new EDetail();
        e.setEquipmentId(eDetail.getEquipmentId());
        List<EDetail> list = eDetailMapper.selectEDetailList(e);
        if(list!=null && list.size() >0){
            throw new BusinessException("设备编号重复");
        }

        eDetail.setCreateTime(DateUtils.getNowDate());
        return eDetailMapper.insertEDetail(eDetail);
    }

    /**
     * 修改设备
     * 
     * @param eDetail 设备
     * @return 结果
     */
    @Override
    public int updateEDetail(EDetail eDetail)
    {
        eDetail.setUpdateTime(DateUtils.getNowDate());
        return eDetailMapper.updateEDetail(eDetail);
    }

    /**
     * 删除设备对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEDetailByIds(String ids)
    {
        return eDetailMapper.deleteEDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备信息
     * 
     * @param id 设备ID
     * @return 结果
     */
    @Override
    public int deleteEDetailById(Long id)
    {
        return eDetailMapper.deleteEDetailById(id);
    }

    /**
     * h获取设备统计
     * @return
     */
    @Override
    @DataScope(deptAlias = "e")
    public EDetailCountVO selectCountDetail(EDetail eDetail){
        return eDetailMapper.selectCountDetail(eDetail);
    }

}
