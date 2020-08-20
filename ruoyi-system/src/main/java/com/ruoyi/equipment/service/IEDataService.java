package com.ruoyi.equipment.service;

import com.ruoyi.equipment.domain.EData;
import com.ruoyi.equipment.domain.EDataCountVO;

import java.util.List;

/**
 * 设备数据Service接口
 * 
 * @author lxl
 * @date 2020-03-10
 */
public interface IEDataService 
{
    /**
     * 查询设备数据
     * 
     * @param id 设备数据ID
     * @return 设备数据
     */
    public EData selectEDataById(Long id);

    /**
     * 查询设备数据列表
     * 
     * @param eData 设备数据
     * @return 设备数据集合
     */
    public List<EData> selectEDataList(EData eData);

    /**
     * 新增设备数据
     * 
     * @param eData 设备数据
     * @return 结果
     */
    public int insertEData(EData eData);

    /**
     * 修改设备数据
     * 
     * @param eData 设备数据
     * @return 结果
     */
    public int updateEData(EData eData);

    /**
     * 批量删除设备数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEDataByIds(String ids);

    /**
     * 删除设备数据信息
     * 
     * @param id 设备数据ID
     * @return 结果
     */
    public int deleteEDataById(Long id);

    /**
     * 获取消息统计
     * @return
     */
    public EDataCountVO selectCountData(EData eData);
}
