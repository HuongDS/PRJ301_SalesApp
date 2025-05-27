/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Review;
import modelView.ReviewUpdateModel;

/**
 *
 * @author ASUS
 */
public class ReviewDAO {

    public void insert(Review r) {
        String sql = "INSERT INTO Reviews (product_id, user_id, rating, comment, review_date) VALUES (?, ?, ?, ?, GETDATE())";
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getProductId());
            ps.setInt(2, r.getUserId());
            ps.setInt(3, r.getRating());
            ps.setNString(4, r.getComment());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ReviewUpdateModel r) {
        String sql = "UPDATE Reviews SET rating = ?, comment = ?, updatedAt=GETDATE() WHERE user_id = ? AND product_id = ?";
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getRating());
            ps.setNString(2, r.getComment());
            ps.setInt(3, r.getUserId());
            ps.setInt(4, r.getProductId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Review findByUserAndProduct(int userId, int productId) {
        String sql = "SELECT * FROM Reviews WHERE user_id = ? AND product_id = ?";
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            try ( ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    Review r = new Review();
                    r.setProductId(rs.getInt("product_id"));
                    r.setUserId(rs.getInt("user_id"));
                    r.setRating(rs.getInt("rating"));
                    r.setComment(rs.getNString("comment"));
                    r.setReviewDate(rs.getDate("review_date"));
                    r.setUpdateDate(rs.getDate("updatedAt"));
                    return r;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Review> findByProductId(int productId) {
        List<Review> list = new ArrayList<>();
        String sql = "SELECT * FROM Reviews WHERE product_id = ? ORDER BY review_date DESC";
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            try ( ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Review r = new Review();
                    r.setProductId(rs.getInt("product_id"));
                    r.setUserId(rs.getInt("user_id"));
                    r.setRating(rs.getInt("rating"));
                    r.setComment(rs.getNString("comment"));
                    r.setReviewDate(rs.getDate("review_date"));
                    r.setUpdateDate(rs.getDate("updatedAt"));
                    list.add(r);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
