package com.ujiuye.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Person implements Serializable {
    private int id;
    private String name;
    private Date birthday;
    private String address;

    private Car car;//一个用户对应一个购物车
    private List<Order> orders;//一个用户对应该多个订单

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person() {
    }

    public Person(int id, String name, Date birthday, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", car=" + car +
                '}';
    }
}
