package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDAO extends CrudDAO<OrderDetailDTO> {
//    public boolean saveOrderDetails(String orderId, OrderDetailDTO detail, Connection connection) throws SQLException, ClassNotFoundException;
}
