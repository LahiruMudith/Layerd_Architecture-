package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO {
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException;

    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    public String genarateNewOrderId() throws SQLException, ClassNotFoundException;

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    public boolean checkOrderId(String orderId) throws SQLException, ClassNotFoundException;

    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;

    public boolean saveOrderDetails(OrderDetailDTO detail) throws SQLException, ClassNotFoundException;

    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException;
}
