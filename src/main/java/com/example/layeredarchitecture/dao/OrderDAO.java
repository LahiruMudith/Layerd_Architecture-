package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO {
    public String genarateNewOrderId() throws ClassNotFoundException, SQLException;
    public boolean checkOrderId(String orderId, PreparedStatement stm, Connection connection) throws SQLException, ClassNotFoundException;
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, PreparedStatement stm, Connection connection) throws SQLException;
}
