package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDAO {
    public boolean saveOrderDetails(String orderId, OrderDetailDTO detail, PreparedStatement stm, Connection connection) throws SQLException, ClassNotFoundException;
}
