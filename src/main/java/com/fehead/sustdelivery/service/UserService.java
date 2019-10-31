package com.fehead.sustdelivery.service;

import com.fehead.sustdelivery.dataobject.OrderDO;
import com.fehead.sustdelivery.error.BusinessException;
import com.fehead.sustdelivery.model.DeliveryPointModel;
import com.fehead.sustdelivery.model.OrderModel;
import com.fehead.sustdelivery.model.UserModel;

import java.util.Date;
import java.util.List;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-22 15:12
 */
public interface UserService {
    /**
     * 查询所有订单
     */
    public List<OrderModel> selectOrder();

    /**
     * 通过用户id查询用户
     */
    public UserModel selectUserById(Integer id);

    /**
     * 查询用户已接订单
     */
    public List<OrderModel> selectReceiverOrder(Integer id);

    /**
     * 查询用户已发订单
     */
    public List<OrderModel> selectPublishOrder(Integer id);


    /**
     * 通过订单id查找订单
     */
    public OrderModel selectOrderById(Integer id);

    /**
     * 查找所有可接订单
     */
    public List<OrderModel> selectAcceptableOrder(int point);

    /**
     * 字符串查找订单
     * @param search
     * @return
     */
    public List<OrderModel> selectAcceptableOrderByDestination(String search);


    /**
     * 查询所有快递点
     * @return
     */
    public List<DeliveryPointModel> selectAllDeliveryPoint();


    /**
     * 通过快递点id查找快递点详细信息
     */
    public DeliveryPointModel selectDeliveryPointById(Integer id);

    /**
     * 发布订单
     */
    public OrderModel commitOrder(OrderModel orderModel) throws BusinessException;
    /**
     * 更新订单
     */
    public void updateOrder(OrderModel orderModel);


}
