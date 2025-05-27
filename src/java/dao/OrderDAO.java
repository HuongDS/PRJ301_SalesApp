/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import enums.OrderStatus;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import modelView.OrderCreateModel;
import modelView.OrderUpdateModel;

/**
 *
 * @author ASUS
 */
public class OrderDAO {

    public boolean insert(OrderCreateModel o) {
        String sql = "INSERT INTO Orders (customer_id, address_id, order_date, status) "
                + "VALUES (?, ?, ?, ?)";

        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, o.getCustomerId());
            ps.setInt(2, o.getAddressId());
            ps.setDate(3, o.getOrderDate());
            ps.setString(4, OrderStatus.PENDING.toString());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM Orders WHERE deletedAt IS NULL";

        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt("id"));
                o.setCustomerId(rs.getInt("customer_id"));
                o.setAddressId(rs.getInt("address_id"));
                o.setOrderDate(rs.getDate("order_date"));
                o.setStatus(OrderStatus.fromString(rs.getString("status")));
                o.setDeliveredDate(rs.getDate("delivered_date"));
                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Order findById(int id) {
        String sql = "SELECT * FROM Orders WHERE id = ? AND deletedAt IS NULL";

        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt("id"));
                o.setCustomerId(rs.getInt("customer_id"));
                o.setAddressId(rs.getInt("address_id"));
                o.setOrderDate(rs.getDate("order_date"));
                o.setStatus(OrderStatus.fromString(rs.getString("status")));
                o.setDeliveredDate(rs.getDate("delivered_date"));
                return o;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(OrderUpdateModel o) {
        String sql = "UPDATE Orders SET address_id=?, status=?, delivered_date=?, updatedAt=GETDATE() WHERE id=?";

        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, o.getAddressId());
            ps.setString(2, o.getStatus().toString());
            ps.setDate(3, o.getDeliveredDate());
            ps.setInt(4, o.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "UPDATE Orders SET deletedAt = GETDATE() WHERE id = ?";

        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
