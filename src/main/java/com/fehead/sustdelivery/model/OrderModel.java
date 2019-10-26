package com.fehead.sustdelivery.model;


import java.util.Date;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-22 11:46
 */
public class OrderModel {
    private Integer id;
    private Date updateTime;
    private Date deadline;
    private String destination;
    private DeliveryPointModel deliveryPoint;
    private Integer type;
    private String fee;
    private String remark;
    private UserModel publisher;
    private UserModel receiver;
    private StatusModel status;
    private PickModel pick;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public DeliveryPointModel getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(DeliveryPointModel deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public UserModel getPublisher() {
        return publisher;
    }

    public void setPublisher(UserModel publisher) {
        this.publisher = publisher;
    }

    public UserModel getReceiver() {
        return receiver;
    }

    public void setReceiver(UserModel receiver) {
        this.receiver = receiver;
    }

    public StatusModel getStatus() {
        return status;
    }

    public void setStatus(StatusModel status) {
        this.status = status;
    }

    public PickModel getPick() {
        return pick;
    }

    public void setPick(PickModel pick) {
        this.pick = pick;
    }
}
