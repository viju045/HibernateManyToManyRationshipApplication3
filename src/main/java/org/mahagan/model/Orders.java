/**
 * Created By VijayKumar Moohite
 * Date : 7/3/2023
 * Time : 2:27 PM
 * Project : ManyToManyRelationshipApplicationHB3
 **/

package org.mahagan.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
//This is my third ManyToMany mapping relationship application in hibernate.
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String empFirstName;
    private String empLastName;
    private String empAddress;
    private int pincode;
    private String date;
    @ManyToMany(targetEntity = Products.class,cascade = CascadeType.ALL)
    @JoinTable(name= "oders_products",joinColumns = {@JoinColumn (name = "orderId")},
    inverseJoinColumns = {@JoinColumn (name = "productId")})
    Set<Products>products = new HashSet<>();

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}