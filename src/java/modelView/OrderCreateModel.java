/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

import enums.OrderStatus;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class OrderCreateModel {

    private int customerId;
    private int addressId;
    private java.sql.Date orderDate;

    public OrderCreateModel() {
    }

    public OrderCreateModel(int customerId, int addressId, java.sql.Date orderDate) {
        this.customerId = customerId;
        this.addressId = addressId;
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public java.sql.Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(java.sql.Date orderDate) {
        this.orderDate = orderDate;
    }

}
