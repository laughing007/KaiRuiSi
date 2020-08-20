package com.ruoyi.equipment.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.equipment.mapper.EShelvesMapper;
import com.ruoyi.equipment.domain.EShelves;
import com.ruoyi.equipment.service.IEShelvesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author lxl
 * @date 2020-05-11
 */
@Service
public class EShelvesServiceImpl implements IEShelvesService 
{
    @Autowired
    private EShelvesMapper eShelvesMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public EShelves selectEShelvesById(Long id)
    {
        return eShelvesMapper.selectEShelvesById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param eShelves 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    @DataScope(deptAlias = "s")
    public List<EShelves> selectEShelvesList(EShelves eShelves)
    {
        return eShelvesMapper.selectEShelvesList(eShelves);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param eShelves 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertEShelves(EShelves eShelves)
    {
        return eShelvesMapper.insertEShelves(eShelves);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param eShelves 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateEShelves(EShelves eShelves)
    {
        return eShelvesMapper.updateEShelves(eShelves);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEShelvesByIds(String ids)
    {
        return eShelvesMapper.deleteEShelvesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteEShelvesById(Long id)
    {
        return eShelvesMapper.deleteEShelvesById(id);
    }
}
