package com.example.layeredarchitecture.bo.custom.bo;

import com.example.layeredarchitecture.bo.custom.SuperBO;
import com.example.layeredarchitecture.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;
    boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean exist(String id) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    String genarateNewId() throws SQLException, ClassNotFoundException;
    ItemDTO search(String id) throws SQLException, ClassNotFoundException;
}
