package com.github.matheusgit11.NorthwindWithSpringBoot.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "shippers")
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipperid")
    private Integer shipperId;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "shipper")
    private List<Order> orders;

    public Shipper() {
    }

    public Shipper(String companyName, String phone, List<Order> orders) {
        this.companyName = companyName;
        this.phone = phone;
        this.orders = orders;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
