package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OrderDAOimpl implements OrderDAO {
    @Override
    public String genarateNewOrderId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
    @Override
    public boolean checkOrderId(String orderId, PreparedStatement stm, Connection connection) throws SQLException, ClassNotFoundException {
        stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);
        if (stm.executeQuery().next()) {
            return false;
        }
        return true;
    }
    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, PreparedStatement stm, Connection connection) throws SQLException {
        stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderId);
        stm.setDate(2, Date.valueOf(orderDate));
        stm.setString(3, customerId);

        if (stm.executeUpdate() == 1){
            System.out.println("Order Saved Done!");
            return true;
        }
        return false;
    }
}
