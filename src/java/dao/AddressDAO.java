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
import modelView.AddressUpdateModel;
import modelView.AddressViewModel;

/**
 *
 * @author ASUS
 */
public class AddressDAO {

    public List<AddressViewModel> getAllAddress(int id) {
        List<AddressViewModel> list = new ArrayList<>();
        String query = "SELECT customer_id, address_line, city FROM Addresses WHERE customer_id = ? AND deletedAt IS NULL;";
        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    AddressViewModel adr = new AddressViewModel();
                    adr.setCustomerId(rs.getInt(1));
                    adr.setAddressLine(rs.getNString(2));
                    adr.setCity(rs.getNString(3));
                    list.add(adr);
                }
                return list;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found in AddressDAO");
        } catch (SQLException ex) {
            System.out.println("SQL ERROR in AddressDAO");
            System.out.println(ex);
        }
        return null;

    }

    public AddressViewModel getAddressDefault(int id) {

        AddressViewModel adr = new AddressViewModel();
        String query = "SELECT customer_id, address_line, city FROM Addresses WHERE customer_id = ? AND is_default = 1 AND deletedAt IS NULL;";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    adr.setCustomerId(rs.getInt(1));
                    adr.setAddressLine(rs.getNString(2));
                    adr.setCity(rs.getNString(3));
                }
                return adr;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found in AddressDAO");
        } catch (SQLException ex) {
            System.out.println("SQL ERROR in AddressDAO");
            System.out.println(ex);
        }
        return null;

    }

    public AddressViewModel addAddress(AddressViewModel data) {

        String query = "INSERT INTO Addresses (customer_id, address_line, city, is_default)\n"
                + "VALUES (?, ?, ?, 0)";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, data.getCustomerId());
            ps.setNString(2, data.getAddressLine());
            ps.setNString(3, data.getCity());
            ps.executeUpdate();
            return data;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found in AddressDAO");
        } catch (SQLException ex) {
            System.out.println("SQL ERROR in AddressDAO");
            System.out.println(ex);
        }

        return null;
    }

    public void resetIsDefault(int key) {

        String query = "UPDATE Addresses SET is_default = 0 WHERE customer_id = ? AND deletedAt IS NULL;";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, key);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found in AddressDAO");
        } catch (SQLException ex) {
            System.out.println("SQL ERROR in AddressDAO");
            System.out.println(ex);
        }
    }

    public boolean update(AddressUpdateModel data) {

        String query = "UPDATE Addresses SET address_line = ?, city=?, is_default=? WHERE id = ? AND deletedAt IS NULL;";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setNString(1, data.getAddressLine());
            ps.setNString(2, data.getCity());
            ps.setBoolean(3, data.isIsDefault());
            ps.setInt(4, data.getId());
            ps.executeUpdate();
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found in AddressDAO");
        } catch (SQLException ex) {
            System.out.println("SQL ERROR in AddressDAO");
            System.out.println(ex);
        }

        return false;
    }

    public void delete(int key) {
        String query = "UPDATE Addresses SET deletedAt = GETDATE() WHERE id = ?;";
        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, key);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception");
        } catch (SQLException ex) {
            System.out.println("SQL Error in PrductDAO class");
            System.out.println(ex);
        }
    }

}
