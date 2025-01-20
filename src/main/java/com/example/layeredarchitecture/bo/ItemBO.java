package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.ItemDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO{
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public String genarateNewId() throws SQLException, ClassNotFoundException;
    public ItemDTO search(String id) throws SQLException, ClassNotFoundException;
}
