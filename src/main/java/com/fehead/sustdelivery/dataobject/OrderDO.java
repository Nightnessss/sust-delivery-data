package com.fehead.sustdelivery.dataobject;

import java.util.Date;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-22 11:24
 */
public class OrderDO {
    private Integer id;
    private Date updateTime;
    private Date deadline;
    private String destination;
    private Integer deliveryPointId;
    private Integer type;
    private String fee;
    private String remark;
    private String pickCode;
    private String pickName;
    private String tailNumber;

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

    public Integer getDeliveryPointId() {
        return deliveryPointId;
    }

    public void setDeliveryPointId(Integer deliveryPointId) {
        this.deliveryPointId = deliveryPointId;
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

    public String getPickCode() {
        return pickCode;
    }

    public void setPickCode(String pickCode) {
        this.pickCode = pickCode;
    }

    public String getPickName() {
        return pickName;
    }

    public void setPickName(String pickName) {
        this.pickName = pickName;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    @Override
    public String toString() {
        return "OrderDO{" +
                "id=" + id +
                ", updateTime=" + updateTime +
                ", deadline=" + deadline +
                ", destination='" + destination + '\'' +
                ", deliveryPointId=" + deliveryPointId +
                ", type=" + type +
                ", fee='" + fee + '\'' +
                ", remark='" + remark + '\'' +
                ", pickCode='" + pickCode + '\'' +
                ", pickName='" + pickName + '\'' +
                ", tailNumber='" + tailNumber + '\'' +
                '}';
    }
}
