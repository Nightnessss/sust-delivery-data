package com.fehead.sustdelivery.controller;

import com.fehead.sustdelivery.error.BusinessException;
import com.fehead.sustdelivery.error.EmBusinessError;
import com.fehead.sustdelivery.model.OrderModel;
import com.fehead.sustdelivery.model.StatusModel;
import com.fehead.sustdelivery.model.UserModel;
import com.fehead.sustdelivery.service.OrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-23 21:00
 */
@RequestMapping("/api/v1.0/SUSTDelivery/data")
@RestController
public class OrderController extends  BaseController{

    public static Log logger = LogFactory.getLog(OrderController.class);


    @Autowired
    private OrderService orderService;

    //修改订单为其他状态
    @PutMapping("/order/{order_id}/status/{status_id}")
    public void updateStatus(@PathVariable ("order_id") Integer orderId,
                             @PathVariable("status_id") Integer statusId) throws BusinessException {
        OrderModel orderModel = new OrderModel();
        orderModel.setId(orderId);
        StatusModel statusModel = new StatusModel();
        statusModel.setStatus(statusId);
        statusModel.setUpdateTime(new Date());
        orderModel.setStatus(statusModel);
        if(orderId > 0 && statusId >= 0 && statusId <= 5){
            orderService.updateStatus(orderModel);
            logger.info("SUCCESS :updateStatus");
        }else{
            logger.info("EXCEPTION:异常码"+EmBusinessError.DATA_UPDATE_ERROR);
            throw new BusinessException(EmBusinessError.DATA_UPDATE_ERROR);
        }
        logger.info("PARAM: 参数名:"+orderId);
        logger.info("PARAM: 参数名:"+statusId);

    }

    //修改订单为2(接单)状态
    @GetMapping("/user/{id}/order/{order_id}")
    public boolean updateStatus2(@PathVariable ("id") Integer userId,
                              @PathVariable("order_id") Integer orderId) throws BusinessException {

        logger.info("PARAM: 参数名:"+orderId);
        logger.info("PARAM: 参数名:"+userId);
        OrderModel orderModel = new OrderModel();
        orderModel.setId(orderId);
        StatusModel statusModel = new StatusModel();
        statusModel.setStatus(2);
        statusModel.setUpdateTime(new Date());
        orderModel.setStatus(statusModel);
        UserModel receiver = new UserModel();
        receiver.setId(userId);
        orderModel.setReceiver(receiver);
//        if (orderModel.getPublisher() == orderModel.getReceiver()) {
//            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "接单者不能是发单者");
//        }
        if(userId > 0 && orderId >0){
            orderService.updateStatus2(orderModel);
            logger.info("SUCCESS :updateStatus2");
        }else{
            logger.info("EXCEPTION:异常码"+EmBusinessError.DATA_UPDATE_ERROR);
            throw new BusinessException(EmBusinessError.DATA_UPDATE_ERROR);
        }

        return true;
    }
}
