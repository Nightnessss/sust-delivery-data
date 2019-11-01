package com.fehead.sustdelivery.controller;

import com.fehead.sustdelivery.error.BusinessException;
import com.fehead.sustdelivery.error.EmBusinessError;
import com.fehead.sustdelivery.model.*;
import com.fehead.sustdelivery.response.CommonReturnType;
import com.fehead.sustdelivery.service.UserService;
import com.github.pagehelper.PageHelper;
import com.sun.media.jfxmedia.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-23 14:12
 */
@RequestMapping("/api/v1.0/SUSTDelivery/data")
@RestController
public class UserController extends BaseController{
    public static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查询所有订单
     */
    @GetMapping("/lists")
    public List<OrderModel> getAllOrder(@RequestParam("page") Integer page,
                                        @RequestParam("pagesize") Integer pagesize){
        logger.info("SUCCESS: selectOrder");
        PageHelper.startPage(page,pagesize);
        return userService.selectOrder();
    }

    /**
     * 通过id查找用户
     */
    @GetMapping("/user/{id}")
    public UserModel getUserById(@PathVariable("id") Integer userId) throws BusinessException {
        logger.info("PARAM: 参数名:"+userId);

        if(userId > 0){
            logger.info("SUCCESS: selectUserById");
            return userService.selectUserById(userId);
        }else{
            logger.info("异常码:"+EmBusinessError.DATA_SELECT_ERROR);
            throw new BusinessException(EmBusinessError.DATA_SELECT_ERROR);
        }
    }

    /**
     * 通过订单id查找订单
     */
    @GetMapping("/order/{order_id}")
    public OrderModel getOrderById(@PathVariable("order_id") Integer orderId) throws BusinessException {
        logger.info("PARAM: 参数名:"+orderId);
        if(orderId > 0){
            logger.info("SUCCESS: selectOrderById");
            return userService.selectOrderById(orderId);
        }else{
            logger.info("异常码:"+EmBusinessError.DATA_SELECT_ERROR);
            throw new BusinessException(EmBusinessError.DATA_SELECT_ERROR);
        }
    }

    /**
     * 根据快递点查找所有可接订单
     */
    @GetMapping("/order/lists/status")
    public List<OrderModel> getAcceptableOrder(@RequestParam("point") Integer point,
                                               @RequestParam("page") Integer page,
                                               @RequestParam("pagesize") Integer pagesize){
        logger.info("SUCCESS: selectOrder");
        PageHelper.startPage(page,pagesize);
        return userService.selectAcceptableOrder(point);
    }


    /**
     * 关键字查询所有可接订单
     * @param search
     * @param page
     * @param pagesize
     * @return
     */
    @PostMapping("/order/lists")
    public List<OrderModel> getAcceptableOrderByDestination(@RequestParam("search") String search,
                                                            @RequestParam("page") Integer page,
                                                            @RequestParam("pagesize") Integer pagesize) {
        logger.debug("PARAM: search "+search);

        PageHelper.startPage(page,pagesize);
        return userService.selectAcceptableOrderByDestination(search);
    }

    /**
     * 通过用户Id查找已发订单
     */
    @GetMapping("/order/publisher/{id}")
    public List<OrderModel> getPublishOrder(@PathVariable("id") Integer id,
                                            @RequestParam("page") Integer page,
                                            @RequestParam("pagesize") Integer pagesize) throws BusinessException {

        logger.info("PARAM: 参数名:"+id);
        if( id > 0){
            logger.info("SUCCESS: selectPublishOrder");
            PageHelper.startPage(page,pagesize);
            return userService.selectPublishOrder(id);
        }else{
            logger.info("异常码:"+EmBusinessError.DATA_SELECT_ERROR);
            throw new BusinessException(EmBusinessError.DATA_SELECT_ERROR);
        }

    }

    /**
     * 通过用户Id查找已接订单
     */
    @GetMapping("/order/receiver/{id}")
    public List<OrderModel> getReceiverOrder(@PathVariable("id") Integer id,
                                             @RequestParam("page") Integer page,
                                             @RequestParam("pagesize") Integer pagesize) throws BusinessException {

        logger.info("PARAM: 参数名:"+id);
        if(id > 0){
            logger.info("SUCCESS: selectReceiverOrder");
            PageHelper.startPage(page,pagesize);
            return userService.selectReceiverOrder(id);
        }else{
            logger.info("异常码:"+EmBusinessError.DATA_SELECT_ERROR);
            throw  new BusinessException(EmBusinessError.DATA_SELECT_ERROR);
        }

    }


    @GetMapping("/order/lists/delivery")
    public List<DeliveryPointModel> getAllDeliveryPoint() {

        return userService.selectAllDeliveryPoint();

    }


    /**
     * 通过快递点id查找快递点
     */
    @GetMapping("/order/lists/delivery/{delivery_id}")
    public DeliveryPointModel getDeliveryPointById(@PathVariable("delivery_id") Integer deliveryId) throws BusinessException {
        logger.info("PARAM: 参数名:"+deliveryId);
        if(deliveryId > 0){
            logger.info("SUCCESS: selectDeliveryPointById");
            return userService.selectDeliveryPointById(deliveryId);
        }else{
            logger.info("异常码:"+EmBusinessError.DATA_SELECT_ERROR);
            throw  new BusinessException(EmBusinessError.DATA_SELECT_ERROR);
        }

    }


    /**
     *提交订单信息
     */
    @PostMapping("/order")
    public OrderModel commitOrder(@RequestBody OrderModel orderModel) throws ParseException, BusinessException {
//        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//        orderModel.setId(1);
//        orderModel.setUpdateTime(new Date());
//        orderModel.setDeadline(sdf.parse("2019-08-23 09:00:00"));
//        orderModel.setDestination("2A311");
//        orderModel.setType(1);
//        orderModel.setFee("3");
//        orderModel.setRemark("wuwuwu");
//
//        DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
//        deliveryPointModel.setId(1);
//        orderModel.setDeliveryPoint(deliveryPointModel);
//
//
//        PickModel pickModel = new PickModel();
//        pickModel.setPickCode("2345");
//        pickModel.setPickName("Maria");
//        pickModel.setTailNumber("6789");
//        orderModel.setPick(pickModel);
//
//        UserModel publisher = new UserModel();
//        publisher.setId(35);
//        orderModel.setPublisher(publisher);
//
//        StatusModel statusModel = new StatusModel();
//        statusModel.setStatus(1);
//        orderModel.setStatus(statusModel);
        OrderModel order = new OrderModel();
        if(orderModel.getDeadline() != null && orderModel.getDestination() != null && orderModel.getType() != null
                && orderModel.getFee() != null && orderModel.getRemark() != null && orderModel.getDeliveryPoint() != null && orderModel.getPick() != null) {

            order = userService.commitOrder(orderModel);
            logger.info("SUCCESS: commitOrder");
        }else{
            logger.info("EXCEPTION: 异常码"+EmBusinessError.DATA_INSERT_ERROR);
            throw new BusinessException(EmBusinessError.DATA_INSERT_ERROR);
        }

        return order;
    }

    /**
     * 修改订单信息
     *
     */
    @PutMapping("/order")
    public void updateOrder(@RequestBody OrderModel orderModel) throws ParseException, BusinessException {
//        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//        orderModel.setId(19);
//        orderModel.setUpdateTime(sdf.parse("2019-08-28 14:53:15"));
//        orderModel.setDeadline(sdf.parse("2019-08-23 09:00:00"));
//        orderModel.setDestination("2A311");
//        orderModel.setType(1);
//        orderModel.setFee("3");
//        orderModel.setRemark("hahahaha");
//
//        DeliveryPointModel deliveryPointModel = new DeliveryPointModel();
//        deliveryPointModel.setId(1);
//        orderModel.setDeliveryPoint(deliveryPointModel);
//
//
//        PickModel pickModel = new PickModel();
//        pickModel.setPickCode("2345");
//        pickModel.setPickName("Maria");
//        pickModel.setTailNumber("6789");
//        orderModel.setPick(pickModel);

        if(orderModel.getDeadline() != null && orderModel.getDestination() != null && orderModel.getType() != null
                && orderModel.getFee() != null && orderModel.getRemark() != null && orderModel.getDeliveryPoint() != null && orderModel.getPick() != null) {
            userService.updateOrder(orderModel);
            logger.info("SUCCESS: updateOrder ");
        }else{
            logger.info("EXCEPTION: 异常码"+EmBusinessError.DATA_ERROR);
            throw new BusinessException(EmBusinessError.DATA_ERROR);
        }
    }


}
