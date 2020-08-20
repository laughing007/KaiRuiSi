package com.ruoyi.equipment.mapper;

import com.ruoyi.equipment.domain.EDetail;
import com.ruoyi.equipment.domain.EDetailCountVO;

import java.util.List;

/**
 * 设备Mapper接口
 *
 * @author lxl
 * @date 2020-03-10
 */
public interface EDetailMapper
{
    /**
     * 查询设备
     *
     * @param id 设备ID
     * @return 设备
     */
    public EDetail selectEDetailById(Long id);

    /**
     * 查询设备列表
     *
     * @param eDetail 设备
     * @return 设备集合
     */
    public List<EDetail> selectEDetailList(EDetail eDetail);

    public List<EDetail> selectEDetailListOrder(EDetail eDetail);


    /**
     * 新增设备
     *
     * @param eDetail 设备
     * @return 结果
     */
    public int insertEDetail(EDetail eDetail);

    /**
     * 修改设备
     *
     * @param eDetail 设备
     * @return 结果
     */
    public int updateEDetail(EDetail eDetail);

    /**
     * 删除设备
     *
     * @param id 设备ID
     * @return 结果
     */
    public int deleteEDetailById(Long id);

    /**
     * 批量删除设备
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEDetailByIds(String[] ids);

    /**
     * h获取设备统计
     * @return
     */
    public EDetailCountVO selectCountDetail(EDetail eDetail);
}
