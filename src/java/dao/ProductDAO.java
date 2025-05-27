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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import modelView.ProductCreateModel;
import modelView.ProductUpdateModel;
import modelView.ProductViewModel;

/**
 *
 * @author ASUS
 */
public class ProductDAO {

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT id, name, description, price, stock, image_url, category_id  FROM Products WHERE deletedAt IS NULL";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);  ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getDouble(4),
                        rs.getInt(5), rs.getString(6), rs.getNString(7));
                list.add(p);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception");
        } catch (SQLException ex) {
            System.out.println("SQL Error in PrductDAO class");
            System.out.println(ex);
        }
        return list;
    }

    public ProductViewModel getProductById(int key) {

        String query = "SELECT name, price, stock, image_url FROM Products WHERE id=? AND deletedAt IS NULL";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, key);
            try ( ResultSet rs = ps.executeQuery();) {
                ProductViewModel pvm = new ProductViewModel();
                while (rs.next()) {
                    pvm.setName(rs.getNString("name"));
                    pvm.setPrice(rs.getDouble("price"));
                    pvm.setStock(rs.getInt("stock"));
                    pvm.setImageUrl(rs.getString("image_url"));
                }
                return pvm;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception");
        } catch (SQLException ex) {
            System.out.println("SQL Error in PrductDAO class");
            System.out.println(ex);
        }

        return null;
    }

    public List<Product> getProductsByName(String key) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT id, name, description, price, stock, image_url, category_id FROM Products WHERE name LIKE ? AND deletedAt IS NULL";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, "%" + key + "%");
            try ( ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Product p = new Product(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getDouble(4),
                            rs.getInt(5), rs.getString(6), rs.getNString(7));
                    list.add(p);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception");
        } catch (SQLException ex) {
            System.out.println("SQL Error in PrductDAO class");
            System.out.println(ex);
        }
        return list;
    }

    public List<Product> getAllProductsByCategory(String cate) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT id, name, description, price, stock, image_url, category_id FROM Products WHERE category_id LIKE ? AND deletedAt IS NULL";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, "%" + cate + "%");
            try ( ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Product p = new Product(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getDouble(4),
                            rs.getInt(5), rs.getString(6), rs.getNString(7));
                    list.add(p);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception");
        } catch (SQLException ex) {
            System.out.println("SQL Error in PrductDAO class");
            System.out.println(ex);
        }
        return list;
    }

    public ProductViewModel addProduct(ProductCreateModel product) {
        String query = "INSERT INTO Products (name, description, price, stock, image_url, category_id)\n"
                + "VALUES (?,?,?,?,?,?);";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setNString(1, product.getName());
            ps.setNString(2, product.getDesc());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.setString(5, product.getImageUrl());
            ps.setString(6, product.getCategoryId());
            ps.executeUpdate();
            return new ProductViewModel(product.getName(), product.getPrice(), product.getStock(), product.getImageUrl());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception");
        } catch (SQLException ex) {
            System.out.println("SQL Error in PrductDAO class");
            System.out.println(ex);
        }
        return null;

    }

    public void update(ProductUpdateModel product) {

        String query = "UPDATE Products SET name = ?, description = ?, price = ?, stock = ?, image_url = ?, updatedAt=GETDATE() WHERE id = ?";

        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setNString(1, product.getName());
            ps.setNString(2, product.getDesc());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.setString(5, product.getImageUrl());
            ps.setInt(6, product.getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception");
        } catch (SQLException ex) {
            System.out.println("SQL Error in PrductDAO class");
            System.out.println(ex);
        }

    }

    public void delete(int key) {
        String query = "UPDATE Products SET deletedAt = GETDATE() WHERE id = ?;";
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

    public boolean isExist(int key) {
        String query = "SELECT id FROM Products WHERE id=?";
        try ( Connection connection = DBConnection.getConnection();  PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, key);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
                return false;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound Exception");
        } catch (SQLException ex) {
            System.out.println("SQL Error in PrductDAO class");
            System.out.println(ex);
        }
        return false;
    }

}
