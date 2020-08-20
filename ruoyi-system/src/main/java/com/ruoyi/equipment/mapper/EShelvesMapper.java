package com.ruoyi.equipment.mapper;

import com.ruoyi.equipment.domain.EShelves;
import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author lxl
 * @date 2020-05-11
 */
public interface EShelvesMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public EShelves selectEShelvesById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param eShelves 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<EShelves> selectEShelvesList(EShelves eShelves);

    /**
     * 新增【请填写功能名称】
     * 
     * @param eShelves 【请填写功能名称】
     * @return 结果
     */
    public int insertEShelves(EShelves eShelves);

    /**
     * 修改【请填写功能名称】
     * 
     * @param eShelves 【请填写功能名称】
     * @return 结果
     */
    public int updateEShelves(EShelves eShelves);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteEShelvesById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEShelvesByIds(String[] ids);
}
