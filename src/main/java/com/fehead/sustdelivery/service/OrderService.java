package com.fehead.sustdelivery.service;

import com.fehead.sustdelivery.error.BusinessException;
import com.fehead.sustdelivery.model.OrderModel;
import com.fehead.sustdelivery.model.StatusModel;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-23 14:20
 */
public interface OrderService {
    /**
     * 修改订单状态
     */
    public void updateStatus(OrderModel orderModel);

    public void updateStatus2(OrderModel orderModel) throws BusinessException;
}
