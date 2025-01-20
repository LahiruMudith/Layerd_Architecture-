package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.CustomerBO;
import com.example.layeredarchitecture.dao.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOimpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOimpl();

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();

    }
    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(customerDTO);
    }
    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customerDTO);
    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    @Override
    public String genarateNewId() throws SQLException, ClassNotFoundException {
        return customerDAO.genarateNewId();
    }
    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }
}
