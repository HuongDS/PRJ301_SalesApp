/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author ASUS
 */
public class CategoryDAO {

    public List<Category> getAllCategories() {

        List<Category> list = new ArrayList<>();
        String query = "SELECT category_id, name FROM Categories WHERE deletedAt IS NULL;";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);  ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                Category ct = new Category();
                ct.setId(rs.getString(1));
                ct.setName(rs.getNString(2));
                list.add(ct);
            }
            return list;

        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found in CategoryDAO");
        } catch (SQLException ex) {
            System.out.println("SQL ERROR in CategoryDAO");
            System.out.println(ex);
        }
        return null;

    }

    public int countCategories() {
        String sql = "SELECT COUNT(*) FROM Categories;";
        int cnt = 0;
        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {

            if (rs.next()) {
                cnt = rs.getInt(1);
            }
            return cnt;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found in CategoryDAO");
        } catch (SQLException ex) {
            System.out.println("SQL ERROR in CategoryDAO");
            System.out.println(ex);
        }
        return cnt;
    }

    public boolean addCategory(String id, String name) {
        String query = "INSERT INTO Categories (category_id, name)\n"
                + "VALUES (?, ?)";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {

            ps.setString(1, id);
            ps.setNString(2, name);
            ps.executeUpdate();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found in CategoryDAO");
        } catch (SQLException ex) {
            System.out.println("SQL ERROR in CategoryDAO");
            System.out.println(ex);
        }

        return false;
    }

    public void delete(String key) {

        String query = "UPDATE Categories SET deletedAt = GETDATE() WHERE category_id = ? AND deletedAt IS NULL;";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {

            ps.setNString(1, key);
            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound CategoryDAO");
        } catch (SQLException ex) {
            System.out.println("SQL Error in CategoryDAO class");
            System.out.println(ex);
        }

    }

    public void update(String id, String name) {

        String query = "UPDATE Categories SET name = ? WHERE category_id = ? AND deletedAt IS NULL;";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {

            ps.setNString(1, name);
            ps.setString(2, id);
            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound CategoryDAO");
        } catch (SQLException ex) {
            System.out.println("SQL Error in CategoryDAO class");
            System.out.println(ex);
        }

    }

}
