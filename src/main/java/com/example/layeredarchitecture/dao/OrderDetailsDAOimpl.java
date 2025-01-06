package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailsDAOimpl implements OrderDetailsDAO {
    @Override
    public boolean saveOrderDetails(String orderId, List<OrderDetailDTO> orderDetails, PreparedStatement stm, Connection connection) throws SQLException, ClassNotFoundException {
        stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        for (OrderDetailDTO detail : orderDetails) {
            stm.setString(1, orderId);
            stm.setString(2, detail.getItemCode());
            stm.setBigDecimal(3, detail.getUnitPrice());
            stm.setInt(4, detail.getQty());

            if (stm.executeUpdate() != 1) {
                return false;
            }
        }
        return true;
    }
}
