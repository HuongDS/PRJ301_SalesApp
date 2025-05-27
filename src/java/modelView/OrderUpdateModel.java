/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

import enums.OrderStatus;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class OrderUpdateModel {

    private int id;
    private int addressId;
    private OrderStatus status;
    private java.sql.Date deliveredDate;

    public OrderUpdateModel() {
    }

    public OrderUpdateModel(int id, int addressId, OrderStatus status, java.sql.Date deliveredDate) {
        this.id = id;
        this.addressId = addressId;
        this.status = status;
        this.deliveredDate = deliveredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public java.sql.Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(java.sql.Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

}
