package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.CustomerDAO;
import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOimpl implements CustomerDAO {

    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        while (rst.next()){
            customerDTOS.add(new CustomerDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3))
            );
        }
        return customerDTOS;
    }

    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress());
    }

    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", customerDTO.getName(), customerDTO.getAddress(), customerDTO.getId());
    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT id FROM Customer WHERE id=?", id);
        return rst.next();
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    public String genarateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            System.out.println(String.format("C00-%03d", newCustomerId));
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Customer WHERE id=?", id);
        rst.next();
        return new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
    }
}
