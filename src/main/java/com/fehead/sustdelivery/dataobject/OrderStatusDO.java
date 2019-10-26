package com.fehead.sustdelivery.dataobject;

import java.util.Date;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-22 11:38
 */
public class OrderStatusDO {
    private Integer id;
    private Integer orderId;
    private Integer status;
    private Date updateTime;
    private Integer publisherId;
    private Integer receiverId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public String toString() {
        return "OrderStatusDO{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", status=" + status +
                ", updateTime=" + updateTime +
                ", publisherId=" + publisherId +
                ", receiverId=" + receiverId +
                '}';
    }
}
