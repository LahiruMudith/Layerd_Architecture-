package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.bo.ItemBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.dao.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAOimpl = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ITEM);
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAOimpl.save(itemDTO);
    }
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAOimpl.update(itemDTO);
    }
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return itemDAOimpl.delete(code);
    }
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        return itemDAOimpl.exist(code);
    }
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return itemDAOimpl.getAll();
    }
    public String genarateNewId() throws SQLException, ClassNotFoundException {
        return itemDAOimpl.genarateNewId();
    }
    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
        return itemDAOimpl.search(code);
    }
}
