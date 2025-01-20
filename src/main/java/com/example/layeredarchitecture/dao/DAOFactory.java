package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.dao.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory getInstance(){
        return (daoFactory==null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOType {
        CUSTOMER, ORDER, ITEM, ORDERDETAILS,QUERY
    }
    public SuperDAO getDAO(DAOType type){
        switch (type){
            case CUSTOMER:
                return new CustomerDAOimpl();
            case ORDER:
                return new OrderDAOimpl();
            case ITEM:
                return new ItemDAOimpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOimpl();
            case QUERY:
                return new QuaryDAOImpl();
            default:
                return null;
        }
    }
}
