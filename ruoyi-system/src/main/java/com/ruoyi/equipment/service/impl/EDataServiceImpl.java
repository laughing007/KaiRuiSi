package com.ruoyi.equipment.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.equipment.domain.EDataCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.equipment.mapper.EDataMapper;
import com.ruoyi.equipment.domain.EData;
import com.ruoyi.equipment.service.IEDataService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备数据Service业务层处理
 * 
 * @author lxl
 * @date 2020-03-10
 */
@Service
public class EDataServiceImpl implements IEDataService 
{
    @Autowired
    private EDataMapper eDataMapper;

    /**
     * 查询设备数据
     * 
     * @param id 设备数据ID
     * @return 设备数据
     */
    @Override
    public EData selectEDataById(Long id)
    {
        return eDataMapper.selectEDataById(id);
    }

    /**
     * 查询设备数据列表
     * 
     * @param eData 设备数据
     * @return 设备数据
     */
    @Override
    @DataScope(deptAlias = "e")
    public List<EData> selectEDataList(EData eData)
    {
        return eDataMapper.selectEDataList(eData);
    }

    /**
     * 新增设备数据
     * 
     * @param eData 设备数据
     * @return 结果
     */
    @Override
    public int insertEData(EData eData)
    {
        eData.setCreateTime(DateUtils.getNowDate());
        return eDataMapper.insertEData(eData);
    }

    /**
     * 修改设备数据
     * 
     * @param eData 设备数据
     * @return 结果
     */
    @Override
    public int updateEData(EData eData)
    {
        eData.setUpdateTime(DateUtils.getNowDate());
        return eDataMapper.updateEData(eData);
    }

    /**
     * 删除设备数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEDataByIds(String ids)
    {
        return eDataMapper.deleteEDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备数据信息
     * 
     * @param id 设备数据ID
     * @return 结果
     */
    @Override
    public int deleteEDataById(Long id)
    {
        return eDataMapper.deleteEDataById(id);
    }

    /**
     * 获取消息统计
     * @return
     */
    @Override
    @DataScope(deptAlias = "e")
    public EDataCountVO selectCountData(EData eData){
        return eDataMapper.selectCountData(eData);
    }
}
