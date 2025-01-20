package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.bo.PlaceOrderBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.dao.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.dao.ItemDAO;
import com.example.layeredarchitecture.dao.custom.dao.OrderDAO;
import com.example.layeredarchitecture.dao.custom.dao.OrderDetailsDAO;
;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ORDER);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ITEM);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ORDERDETAILS);

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

    public boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return orderDAO.save(orderDTO);
    }

    public boolean saveOrderDetails(OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.save(detail);
    }

    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return itemDAO.update(item);
    }
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        /*Transaction*/
        Connection connection = null;

        try {
            connection = DBConnection.getDbConnection().getConnection();

            boolean isIdAlreadyExist = checkOrderId(orderId);
            /*if order id already exist*/
            if (!isIdAlreadyExist) {
                System.out.println("Order ID Already Exists!");
                return false;
            }

            connection.setAutoCommit(false);
            boolean isOrderSaved = save(new OrderDTO(orderId, orderDate, customerId));

            if (!isOrderSaved) {
                System.out.println("Order Saved Failed!");
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            System.out.println("Order Saved Done!");


            for (OrderDetailDTO detail : orderDetails) {
                boolean isOrderDetailsSaved = saveOrderDetails(detail);
                if (isOrderDetailsSaved == false) {
                    System.out.println("Order Details Save Failed!");
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                System.out.println("Order Details Save Done!");

//                //Search & Update Item
                ItemDTO item = itemDAO.search(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                boolean IsItemUpdated = updateItem(item);

                if (!IsItemUpdated) {
                    System.out.println("Item Update Failed!");
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                System.out.println("Item Update Done!");
                return true;
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
}
