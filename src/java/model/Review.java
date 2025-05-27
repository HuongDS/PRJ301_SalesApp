/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Review {

    private int productId;
    private int userId;
    private int rating;
    private String comment;
    private java.sql.Date reviewDate;
    private java.sql.Date updateDate;

    public Review() {
    }

    public Review(int productId, int userId, int rating, String comment) {
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = new java.sql.Date(new Date().getTime());
        this.updateDate = new java.sql.Date(new Date().getTime());
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public java.sql.Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(java.sql.Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public java.sql.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.sql.Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Review{" + "productId=" + productId + ", userId=" + userId + ", rating=" + rating + ", comment=" + comment + ", reviewDate=" + reviewDate + ", updateDate=" + updateDate + '}';
    }

}
