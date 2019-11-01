package com.fehead.sustdelivery.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.fehead.sustdelivery.dao.UserDOMapper;
import com.fehead.sustdelivery.dataobject.DeliveryPointDO;
import com.fehead.sustdelivery.dataobject.OrderDO;
import com.fehead.sustdelivery.dataobject.OrderStatusDO;
import com.fehead.sustdelivery.dataobject.UserDO;
import com.fehead.sustdelivery.error.BusinessException;
import com.fehead.sustdelivery.error.EmBusinessError;
import com.fehead.sustdelivery.model.*;
import com.fehead.sustdelivery.service.UserService;
import com.github.pagehelper.PageHelper;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-22 15:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public List<OrderModel> selectOrder() {

        List<OrderModel> orderModelList = new ArrayList<>();
        List<OrderDO> orderDOList = userDOMapper.selectOrder();
        for(OrderDO orderDO :orderDOList){
            OrderModel orderModel = new OrderModel();
            if(orderDO != null){
                BeanUtils.copyProperties(orderDO,orderModel);
            }
            DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
            DeliveryPointDO deliveryPointDO = userDOMapper.selectDeliveryPointById(orderDO.getDeliveryPointId());
            if(deliveryPointDO != null){
                BeanUtils.copyProperties(deliveryPointDO,deliveryPointModel);
            }
            orderModel.setDeliveryPoint(deliveryPointModel);

            StatusModel statusModel = new StatusModel();
            OrderStatusDO orderStatusDO = userDOMapper.selectOrderStatusById(orderDO.getId());
            if(orderStatusDO != null){
                BeanUtils.copyProperties(orderStatusDO,statusModel);
            }
            orderModel.setStatus(statusModel);

            UserModel userModel = new UserModel();
            UserDO userDO = userDOMapper.selectUserById(orderStatusDO.getPublisherId());
            if(userDO != null){
                BeanUtils.copyProperties(userDO,userModel);
            }
            orderModel.setPublisher(userModel);

            userModel = new UserModel();
            userDO = userDOMapper.selectUserById(orderStatusDO.getReceiverId());
            if(userDO != null){
                BeanUtils.copyProperties(userDO,userModel);
            }
            orderModel.setReceiver(userModel);

            PickModel pickModel = new PickModel();
            pickModel.setPickCode(orderDO.getPickCode());
            pickModel.setPickName(orderDO.getPickName());
            pickModel.setTailNumber(orderDO.getTailNumber());
            orderModel.setPick(pickModel);

            orderModelList.add(orderModel);
        }
        return orderModelList;
    }

    @Override
    public UserModel selectUserById(Integer id){
        UserDO userDO = userDOMapper.selectUserById(id);
        UserModel userModel = new UserModel();
        if(userDO != null){
            BeanUtils.copyProperties(userDO,userModel);
        }

        return userModel;
    }

    @Override
    public List<OrderModel> selectReceiverOrder(Integer id) {
        List<OrderModel> orderModelList = new ArrayList<>();
        List<OrderDO> orderDOList = userDOMapper.selectReceiverOrder(id);

        for (OrderDO orderDO : orderDOList) {
            OrderModel orderModel = new OrderModel();
            if (orderDO != null) {
                BeanUtils.copyProperties(orderDO, orderModel);
            }

            DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
            DeliveryPointDO deliveryPointDO = userDOMapper.selectDeliveryPointById(orderDO.getDeliveryPointId());
            if (deliveryPointDO != null) {
                BeanUtils.copyProperties(deliveryPointDO, deliveryPointModel);
            }
            orderModel.setDeliveryPoint(deliveryPointModel);

            StatusModel statusModel = new StatusModel();
            OrderStatusDO orderStatusDO = userDOMapper.selectOrderStatusById(orderDO.getId());
            if (orderStatusDO != null) {
                BeanUtils.copyProperties(orderStatusDO, statusModel);
            }
            orderModel.setStatus(statusModel);

            UserModel userModel = new UserModel();
            UserDO userDO = userDOMapper.selectUserById(orderStatusDO.getPublisherId());
            if (userDO != null) {
                BeanUtils.copyProperties(userDO, userModel);
            }
            orderModel.setPublisher(userModel);

            userModel = new UserModel();
            userDO = userDOMapper.selectUserById(orderStatusDO.getReceiverId());
            if (userDO != null) {
                BeanUtils.copyProperties(userDO, userModel);
            }
            orderModel.setReceiver(userModel);

            PickModel pickModel = new PickModel();
            pickModel.setPickCode(orderDO.getPickCode());
            pickModel.setPickName(orderDO.getPickName());
            pickModel.setTailNumber(orderDO.getTailNumber());
            orderModel.setPick(pickModel);

            orderModelList.add(orderModel);
        }

        return orderModelList;
    }

    @Override
    public List<OrderModel> selectPublishOrder(Integer id) {
        List<OrderModel> orderModelList = new ArrayList<>();
        List<OrderDO> orderDOList = userDOMapper.selectPublishOrder(id);

        for(OrderDO orderDO : orderDOList){
            OrderModel orderModel = new OrderModel();
            if(orderDO != null){
                BeanUtils.copyProperties(orderDO,orderModel);
            }

            DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
            DeliveryPointDO deliveryPointDO = userDOMapper.selectDeliveryPointById(orderDO.getDeliveryPointId());
            if(deliveryPointDO != null){
                BeanUtils.copyProperties(deliveryPointDO,deliveryPointModel);
            }
            orderModel.setDeliveryPoint(deliveryPointModel);

            StatusModel statusModel = new StatusModel();
            OrderStatusDO orderStatusDO = userDOMapper.selectOrderStatusById(orderDO.getId());
            if(orderStatusDO != null){
                BeanUtils.copyProperties(orderStatusDO,statusModel);
            }
            orderModel.setStatus(statusModel);

            UserModel userModel = new UserModel();
            UserDO userDO = userDOMapper.selectUserById(orderStatusDO.getPublisherId());
            if(userDO != null){
                BeanUtils.copyProperties(userDO,userModel);
            }
            orderModel.setPublisher(userModel);

            userModel = new UserModel();
            userDO = userDOMapper.selectUserById(orderStatusDO.getReceiverId());
            if(userDO != null){
                BeanUtils.copyProperties(userDO,userModel);
            }
            orderModel.setReceiver(userModel);

            PickModel pickModel = new PickModel();
            pickModel.setPickCode(orderDO.getPickCode());
            pickModel.setPickName(orderDO.getPickName());
            pickModel.setTailNumber(orderDO.getTailNumber());
            orderModel.setPick(pickModel);

            orderModelList.add(orderModel);
        }

        return orderModelList;
    }

    @Override
    public OrderModel selectOrderById(Integer id) {
        OrderModel orderModel = new OrderModel();

        OrderDO orderDO = userDOMapper.selectOrderById(id);
        if(orderDO != null){
            BeanUtils.copyProperties(orderDO,orderModel);

        }

        StatusModel statusModel = new StatusModel();
        OrderStatusDO orderStatusDO = userDOMapper.selectOrderStatusById(id);
        if(orderStatusDO != null){
            BeanUtils.copyProperties(orderStatusDO,statusModel);
        }

        orderModel.setStatus(statusModel);

        DeliveryPointDO deliveryPointDO =userDOMapper.selectDeliveryPointById(orderDO.getDeliveryPointId());
        DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
        if(deliveryPointDO != null){
            BeanUtils.copyProperties(deliveryPointDO,deliveryPointModel);
        }
        orderModel.setDeliveryPoint(deliveryPointModel);

        UserDO userDO = userDOMapper.selectUserById(orderStatusDO.getPublisherId());
        UserModel userModel = new UserModel();
        if(userDO != null){
            BeanUtils.copyProperties(userDO,userModel);
        }
        orderModel.setPublisher(userModel);

        userDO = userDOMapper.selectUserById(orderStatusDO.getReceiverId());
        userModel = new UserModel();
        if (userDO != null) {
            BeanUtils.copyProperties(userDO,userModel);
        }
        orderModel.setReceiver(userModel);

        PickModel pickModel = new PickModel();
        pickModel.setPickCode(orderDO.getPickCode());
        pickModel.setPickName(orderDO.getPickName());
        pickModel.setTailNumber(orderDO.getTailNumber());
        orderModel.setPick(pickModel);

        return orderModel;
    }

    @Override
    public List<OrderModel> selectAcceptableOrder(int point) {

        List<OrderModel> orderModelList = new ArrayList<>();
        List<OrderDO> orderDOList = new ArrayList<>();
        if (point == 0) {
            orderDOList = userDOMapper.selectAcceptableOrder();
        } else {
            orderDOList = userDOMapper.selectAcceptableOrderByPoint(point);
        }


//        List<DeliveryPointDO> deliveryPointDOList = userDOMapper.selectDeliveryPoint();
//        List<UserDO> userDOList = userDOMapper.selectUser();
//        List<OrderStatusDO> orderStatusDOList = userDOMapper.selectStatus();

        for(OrderDO orderDO:orderDOList){
            OrderModel orderModel = new OrderModel();
            if(orderDO != null){
                BeanUtils.copyProperties(orderDO,orderModel);
            }
            StatusModel statusModel = new StatusModel();
            OrderStatusDO orderStatusDO = userDOMapper.selectOrderStatusById(orderDO.getId());
            if(orderStatusDO != null){
                BeanUtils.copyProperties(orderStatusDO,statusModel);
            }

            orderModel.setStatus(statusModel);

            DeliveryPointDO deliveryPointDO =userDOMapper.selectDeliveryPointById(orderDO.getDeliveryPointId());
            DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
            if(deliveryPointDO != null){
                BeanUtils.copyProperties(deliveryPointDO,deliveryPointModel);
            }
            orderModel.setDeliveryPoint(deliveryPointModel);

            UserDO userDO = userDOMapper.selectUserById(orderStatusDO.getPublisherId());
            UserModel userModel = new UserModel();
            if(userDO != null){
                BeanUtils.copyProperties(userDO,userModel);
            }
            orderModel.setPublisher(userModel);

            userDO = userDOMapper.selectUserById(orderStatusDO.getReceiverId());
            userModel = new UserModel();
            if (userDO != null) {
                BeanUtils.copyProperties(userDO,userModel);
            }
            orderModel.setReceiver(userModel);

            PickModel pickModel = new PickModel();
            pickModel.setPickCode(orderDO.getPickCode());
            pickModel.setPickName(orderDO.getPickName());
            pickModel.setTailNumber(orderDO.getTailNumber());
            orderModel.setPick(pickModel);
            if (orderModel.getDeadline().after(new Date())) {
                orderModelList.add(orderModel);
            }
        }



        return orderModelList;
    }

    @Override
    public List<OrderModel> selectAcceptableOrderByDestination(String search) {
        List<OrderModel> orderModelList = new ArrayList<>();
        List<OrderDO> orderDOList = userDOMapper.selectAcceptableOrderByDestination(search);

//        List<DeliveryPointDO> deliveryPointDOList = userDOMapper.selectDeliveryPoint();
//        List<UserDO> userDOList = userDOMapper.selectUser();
//        List<OrderStatusDO> orderStatusDOList = userDOMapper.selectStatus();

        for(OrderDO orderDO:orderDOList){
            OrderModel orderModel = new OrderModel();
            if(orderDO != null){
                BeanUtils.copyProperties(orderDO,orderModel);
            }
            StatusModel statusModel = new StatusModel();
            OrderStatusDO orderStatusDO = userDOMapper.selectOrderStatusById(orderDO.getId());
            if(orderStatusDO != null){
                BeanUtils.copyProperties(orderStatusDO,statusModel);
            }

            orderModel.setStatus(statusModel);

            DeliveryPointDO deliveryPointDO =userDOMapper.selectDeliveryPointById(orderDO.getDeliveryPointId());
            DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
            if(deliveryPointDO != null){
                BeanUtils.copyProperties(deliveryPointDO,deliveryPointModel);
            }
            orderModel.setDeliveryPoint(deliveryPointModel);

            UserDO userDO = userDOMapper.selectUserById(orderStatusDO.getPublisherId());
            UserModel userModel = new UserModel();
            if(userDO != null){
                BeanUtils.copyProperties(userDO,userModel);
            }
            orderModel.setPublisher(userModel);

            userDO = userDOMapper.selectUserById(orderStatusDO.getReceiverId());
            userModel = new UserModel();
            if (userDO != null) {
                BeanUtils.copyProperties(userDO,userModel);
            }
            orderModel.setReceiver(userModel);

            PickModel pickModel = new PickModel();
            pickModel.setPickCode(orderDO.getPickCode());
            pickModel.setPickName(orderDO.getPickName());
            pickModel.setTailNumber(orderDO.getTailNumber());
            orderModel.setPick(pickModel);

            if (orderModel.getDeadline().after(new Date())) {
                orderModelList.add(orderModel);
            }
        }

        return orderModelList;
    }

    @Override
    public List<DeliveryPointModel> selectAllDeliveryPoint() {

        List<DeliveryPointModel> deliveryPointModels = new ArrayList<>();

        List<DeliveryPointDO> deliveryPointDOS = userDOMapper.selectDeliveryPoint();
        for (DeliveryPointDO deliveryPointDO:deliveryPointDOS) {
            DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
            BeanUtils.copyProperties(deliveryPointDO,deliveryPointModel);
            deliveryPointModels.add(deliveryPointModel);
        }
        return deliveryPointModels;
    }

    @Override
    public DeliveryPointModel selectDeliveryPointById(Integer id) {
        DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
        DeliveryPointDO deliveryPointDO = userDOMapper.selectDeliveryPointById(id);
        if(deliveryPointDO != null){
            BeanUtils.copyProperties(deliveryPointDO,deliveryPointModel);
        }
        return deliveryPointModel;
    }

    @Override
    public OrderModel commitOrder(OrderModel order) throws BusinessException {

        if (userDOMapper.selectUserById(order.getPublisher().getId()) == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "发布者不存在");
        }
        OrderDO orderDO = new OrderDO();
        if(order != null){
            BeanUtils.copyProperties(order,orderDO);
        }

        orderDO.setDeliveryPointId(order.getDeliveryPoint().getId());
        orderDO.setPickCode(order.getPick().getPickCode());
        orderDO.setPickName(order.getPick().getPickName());
        orderDO.setTailNumber(order.getPick().getTailNumber());
        userDOMapper.commitOrder(orderDO);
        order.setId(orderDO.getId());

        OrderStatusDO orderStatusDO = new OrderStatusDO();
        orderStatusDO.setOrderId(orderDO.getId());
        orderStatusDO.setUpdateTime(order.getUpdateTime());
        orderStatusDO.setStatus(1);
        orderStatusDO.setPublisherId(order.getPublisher().getId());
        userDOMapper.insertOrderStatus(orderStatusDO);
        StatusModel statusModel = new StatusModel();
        BeanUtils.copyProperties(orderStatusDO, statusModel);
        order.setStatus(statusModel);

        return order;
    }

    @Override
    public void updateOrder(OrderModel order) {
        OrderDO orderDO = new OrderDO();
        if( order!= null){
            BeanUtils.copyProperties(order,orderDO);
        }

        orderDO.setDeliveryPointId(order.getDeliveryPoint().getId());
        orderDO.setPickCode(order.getPick().getPickCode());
        orderDO.setPickName(order.getPick().getPickName());
        orderDO.setTailNumber(order.getPick().getTailNumber());
        userDOMapper.updateOrder(orderDO);

        OrderStatusDO orderStatusDO = new OrderStatusDO();
        StatusModel statusModel = order.getStatus();
        if(statusModel != null){
            BeanUtils.copyProperties(statusModel,orderStatusDO);
        }

        userDOMapper.updateOrderStatus(orderStatusDO);

    }
}
