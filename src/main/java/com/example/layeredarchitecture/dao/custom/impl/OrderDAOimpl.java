package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.OrderDAO;
import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class orderBO
 implements OrderDAO {
    public String genarateNewId() throws ClassNotFoundException, SQLException {
        ResultSet rst = SqlUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    public OrderDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean exist(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet stm = SqlUtil.execute("SELECT oid FROM `Orders` WHERE oid=?", orderId);
        if (stm.next()) {
            return false;
        }
        return true;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean save(OrderDTO orderDto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", orderDto.getOrderId(), orderDto.getOrderDate(), orderDto.getCustomerId());
    }

    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }
}
