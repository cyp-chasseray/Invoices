package com.example.billeditor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "street")
    private String street;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Client(Long id, String companyName, String street, String zipcode, String city, String phoneNumber) {
        this.id = id;
        this.companyName = companyName;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public Client() {
    }

    public Client(String name, String companyName, String street, String zipcode, String city, String phoneNumber) {
        this.name = name;
        this.companyName = companyName;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client(Long id, String name, String companyName, String street, String zipcode, String city, String phoneNumber, User user) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public Client(String name, String companyName, String street, String zipcode, String city, String phoneNumber, User user) {
        this.name = name;
        this.companyName = companyName;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }
}
