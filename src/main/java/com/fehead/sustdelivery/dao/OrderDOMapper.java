package com.fehead.sustdelivery.dao;

import com.fehead.sustdelivery.dataobject.OrderStatusDO;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-22 11:32
 */
public interface OrderDOMapper {
    /**
     * 修改订单状态
     */
    void updateStatus(OrderStatusDO orderStatusDO);

    /**
     * 修改订单状态为已接
     */
    void updateStatus2(OrderStatusDO orderStatusDO);

    /**
     * 根据id获取订单信息
     * @param id
     */
    void selectOrderById(int id);



}
