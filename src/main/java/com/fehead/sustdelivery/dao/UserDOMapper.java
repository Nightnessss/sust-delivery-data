package com.fehead.sustdelivery.dao;

import com.fehead.sustdelivery.dataobject.DeliveryPointDO;
import com.fehead.sustdelivery.dataobject.OrderDO;
import com.fehead.sustdelivery.dataobject.OrderStatusDO;
import com.fehead.sustdelivery.dataobject.UserDO;
import com.fehead.sustdelivery.model.UserModel;

import java.util.Date;
import java.util.List;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-22 11:23
 */
public interface UserDOMapper {
    /**
     * 查询所有订单
     * @return
     */
    List<OrderDO>  selectOrder();
    /**
     * 查询所有用户表
     */
    List<UserDO> selectUser();

    /**
     * 通过id查找用户
     */
    UserDO selectUserById(Integer id);

    /**
     * 查询所有订单状态信息
     */
    List<OrderStatusDO> selectStatus();

    /**
     * 查询所有快递点信息
     */
    List<DeliveryPointDO> selectDeliveryPoint();

    /**
     * 通过用户Id查找已接订单
     */
    List<OrderDO> selectReceiverOrder(Integer id);

    /**
     * 通过用户Id查找已发订单
     */
    List<OrderDO> selectPublishOrder(Integer id);

    /**
     * 通过订单id查找订单
     */
    OrderDO selectOrderById(Integer id);

    /**
     * 通过订单id查找订单状态
     */
    OrderStatusDO selectOrderStatusById(Integer id);

    /**
     * 通过快递点id查找快递点
     */
    DeliveryPointDO selectDeliveryPointById(Integer id);

    /**
     * 查找所有可接订单
     */
    List<OrderDO> selectAcceptableOrder();

    /**
     * 通过快递点查找所有可接订单
     * @param point
     * @return
     */
    List<OrderDO> selectAcceptableOrderByPoint(Integer point);

    /**
     * 通过目的地模糊匹配查找所有可接订单
     * @param destination
     * @return
     */
    List<OrderDO> selectAcceptableOrderByDestination(String destination);
    /**
     * 发布订单
     */
    void commitOrder(OrderDO order);
    void insertOrderStatus(OrderStatusDO orderStatus);
    /**
     * 更新订单
     */
    void updateOrder(OrderDO order);
    void updateOrderStatus(OrderStatusDO orderStatusDO);

    /**
     * 通过第三方id查找用户
     * @param thirdPartyId
     * @return
     */
    UserDO selectUserByThirdPartyId(String thirdPartyId);

    /**
     * 插入用户
     * @param userDO
     */
    void insertUserInfo(UserDO userDO);

    /**
     * 补充信息
     * @param userDO
     */
    void updateUserInfo(UserDO userDO);
}
