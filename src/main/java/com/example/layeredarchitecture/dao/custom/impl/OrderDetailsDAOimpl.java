package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.dao.OrderDetailsDAO;
import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOimpl implements OrderDetailsDAO {
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean save(OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", detail.getOrderId(), detail.getItemCode(), detail.getUnitPrice(), detail.getQty());
    }

    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    public String genarateNewId() throws SQLException, ClassNotFoundException {
        return "";
    }

    public OrderDetailDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

}
