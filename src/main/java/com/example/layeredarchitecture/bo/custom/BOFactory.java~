package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.custom.bo.CustomerBO;
import com.example.layeredarchitecture.bo.custom.impl.CustomerBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.ItemBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {
    }
    public BOFactory getInstance (){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOType {
        CUSTOMER, ITEM, PLACE_ORDER
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
