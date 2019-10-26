package com.fehead.sustdelivery.dataobject;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-22 11:44
 */
public class DeliveryPointDO {
    private Integer id;
    private String deliveryPoint;
    private String area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "DeliveryPointDO{" +
                "id=" + id +
                ", deliveryPoint='" + deliveryPoint + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
