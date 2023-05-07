package com.github.matheusgit11.NorthwindWithSpringBoot.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "suppliers")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierid")
    private Integer supplierId;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "contactname")
    private String contactName;

    @Column(name = "contacttitle")
    private String contactTitle;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "postalcode")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "homepage")
    private String homePage;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

}
