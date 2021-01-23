package com.oop.demo08.exer;

public class OrderTest {

    public static void main(String[] args) {

        Order o1 = new Order(1001,"RTX3090");
        Order o2 = new Order(1001,"RTX3080");

        System.out.println(o1.equals(o2));

        Order o3 = new Order(1001,"RTX3080");

        System.out.println(o2.equals(o3));

    }
}

class Order {

    private int orderId;
    private String orderName;

    public Order() {
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return this.orderId == order.orderId && this.orderName.equals(order.orderName);
    }
}

