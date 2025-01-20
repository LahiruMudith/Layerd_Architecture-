package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.PlaceOrderBO;
import com.example.layeredarchitecture.dao.CustomerDAO;
import com.example.layeredarchitecture.dao.ItemDAO;
import com.example.layeredarchitecture.dao.OrderDAO;
import com.example.layeredarchitecture.dao.OrderDetailsDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOimpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOimpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOimpl;
import com.example.layeredarchitecture.dao.custom.impl.orderBO
;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrderDAO orderDAO = new orderBO();
    CustomerDAO customerDAO = new CustomerDAOimpl();
    ItemDAO itemDAO = new ItemDAOimpl();
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOimpl();

    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
        return customerDAO.search(newValue);
    }

    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.search(newItemCode);
    }

    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO. exist(code);
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    public String genarateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.genarateNewId();
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    public boolean checkOrderId(String orderId) throws SQLException, ClassNotFoundException {
        return orderDAO.exist(orderId);
    }

    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return orderDAO.save(orderDTO);
    }

    public boolean saveOrderDetails(OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.save(detail);
    }

    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return itemDAO.update(item);
    }
}
