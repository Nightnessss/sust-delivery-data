package com.fehead.sustdelivery.service.impl;

import com.fehead.sustdelivery.dao.OrderDOMapper;
import com.fehead.sustdelivery.dao.UserDOMapper;
import com.fehead.sustdelivery.dataobject.OrderStatusDO;
import com.fehead.sustdelivery.error.BusinessException;
import com.fehead.sustdelivery.error.EmBusinessError;
import com.fehead.sustdelivery.model.OrderModel;
import com.fehead.sustdelivery.model.StatusModel;
import com.fehead.sustdelivery.service.OrderService;
import com.fehead.sustdelivery.service.UserService;
import org.bouncycastle.crypto.tls.UserMappingType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-23 14:21
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDOMapper orderDOMapper;

    /**
     * 修改订单状态为其他状态
     * @param orderModel
     */
    @Override
    public void updateStatus(OrderModel orderModel) {
        OrderStatusDO orderStatusDO = new OrderStatusDO();
        orderStatusDO.setOrderId(orderModel.getId());
        orderStatusDO.setStatus(orderModel.getStatus().getStatus());
        orderStatusDO.setUpdateTime(orderModel.getStatus().getUpdateTime());
        orderDOMapper.updateStatus(orderStatusDO);
    }
    @Autowired
    UserService userService;

    @Autowired
    UserDOMapper userDOMapper;
    /**
     * 修改订单状态为已接单
     * @param orderModel
     */
    @Override
    public void updateStatus2(OrderModel orderModel) throws BusinessException {


        OrderStatusDO orderStatusDO1 = userDOMapper.selectOrderStatusById(orderModel.getId());
        if(orderStatusDO1.getStatus()!=1){ // 仅能接受状态为1的订单
            throw new BusinessException(EmBusinessError.DATA_INSERT_ERROR,"订单已失效或已经被接");
        }
//        orderDOMapper.
        OrderStatusDO orderStatusDO = new OrderStatusDO();
        orderStatusDO.setOrderId(orderModel.getId());
        orderStatusDO.setStatus(orderModel.getStatus().getStatus());
        orderStatusDO.setUpdateTime(orderModel.getStatus().getUpdateTime());
        orderStatusDO.setReceiverId(orderModel.getReceiver().getId());
        orderDOMapper.updateStatus2(orderStatusDO);
    }
}
