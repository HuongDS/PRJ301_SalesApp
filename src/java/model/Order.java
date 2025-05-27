/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.OrderStatus;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Order {

    private int id;
    private int customerId;
    private int addressId;
    private java.sql.Date orderDate;
    private OrderStatus status;
    private java.sql.Date deliveredDate;

    public Order() {
    }

    public Order(int id, int customerId, int addressId, java.sql.Date orderDate, OrderStatus status, java.sql.Date deliveredDate) {
        this.id = id;
        this.customerId = customerId;
        this.addressId = addressId;
        this.orderDate = orderDate;
        this.status = status;
        this.deliveredDate = deliveredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerId=" + customerId + ", addressId=" + addressId + ", orderDate=" + orderDate + ", status=" + status + ", deliveredDate=" + deliveredDate + '}';
    }

}
