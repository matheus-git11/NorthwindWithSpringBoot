package com.github.matheusgit11.NorthwindWithSpringBoot.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "productid")
    private Integer productId;

    @Column(name = "productname")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Suppliers supplier;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @Column(name = "quantityperunit")
    private String quantityPerUnit;

    @Column(name = "unitprice")
    private int unitPrice;

    @Column(name = "unitsinstock")
    private int unitsInStock;

    @Column(name = "unitsonorder")
    private int unitsOnOrder;

    @Column(name = "reorderlevel")
    private int reorderLevel;

    @Column(name = "discontinued")
    private boolean discontinued;


    public Product(String productName, Suppliers supplier, Category category, String quantityPerUnit, int unitPrice, Short unitsInStock, Short unitsOnOrder, Short reorderLevel, boolean discontinued) {
        this.productName = productName;
        this.supplier = supplier;
        this.category = category;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(int unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
}
