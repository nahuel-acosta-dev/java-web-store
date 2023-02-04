/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nahuel
 */
public class User {
    
    private int idUser;
    private String email;
    private int phone;
    private String firstname;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateProvinceRegion;
    private String zipcode;
    private String password;

    public User() {
    }

    public User(int idUser) {
        this.idUser = idUser;
    }

    public User(String email, int phone, String firstname, String lastName, String addressLine1, String city, String stateProvinceRegion, String zipcode, String password) {
        this.email = email;
        this.phone = phone;
        this.firstname = firstname;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.stateProvinceRegion = stateProvinceRegion;
        this.zipcode = zipcode;
        this.password = password;
    }

    public User(String email, int phone, String firstname, String lastName, String addressLine1, String addressLine2, String city, String stateProvinceRegion, String zipcode, String password) {
        this.email = email;
        this.phone = phone;
        this.firstname = firstname;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.stateProvinceRegion = stateProvinceRegion;
        this.zipcode = zipcode;
        this.password = password;
    }

    public User(int idUser, String email, int phone, String firstname, String lastName, String addressLine1, String city, String stateProvinceRegion, String zipcode, String password) {
        this.idUser = idUser;
        this.email = email;
        this.phone = phone;
        this.firstname = firstname;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.stateProvinceRegion = stateProvinceRegion;
        this.zipcode = zipcode;
        this.password = password;
    }

    public User(int idUser, String email, int phone, String firstname, String lastName, String addressLine1, String addressLine2, String city, String stateProvinceRegion, String zipcode, String password) {
        this.idUser = idUser;
        this.email = email;
        this.phone = phone;
        this.firstname = firstname;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.stateProvinceRegion = stateProvinceRegion;
        this.zipcode = zipcode;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvinceRegion() {
        return stateProvinceRegion;
    }

    public void setStateProvinceRegion(String stateProvinceRegion) {
        this.stateProvinceRegion = stateProvinceRegion;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", email=" + email + ", phone=" + phone + ", firstname=" + firstname + ", lastName=" + lastName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", stateProvinceRegion=" + stateProvinceRegion + ", zipcode=" + zipcode + ", password=" + password + '}';
    }

}
