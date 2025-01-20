package com.example.layeredarchitecture.model;

import java.io.Serializable;
import java.math.BigDecimal;



public class OrderDetailDTO implements Serializable {
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;
    private String orderId;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String itemCode, int qty, BigDecimal unitPrice, String orderId) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.orderId = orderId;
    }

    public OrderDetailDTO(String itemCode, int qty, BigDecimal unitPrice) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String toString() {
        return "OrderDetailDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
