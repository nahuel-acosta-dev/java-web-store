/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nahuel
 */
public class Admin {
    private int idAdmin;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private boolean superUser;

    public Admin() {
    }

    public Admin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Admin(String name, String lastName, String email, String password, boolean superUser) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.superUser = superUser;
    }

    public Admin(int idAdmin, String name, String lastName, String email, String password, boolean superUser) {
        this.idAdmin = idAdmin;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.superUser = superUser;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getSuperUser() {
        return superUser;
    }

    public void setSuperUser(boolean superUser) {
        this.superUser = superUser;
    }
    

    @Override
    public String toString() {
        return "Admin{" + "idAdmin=" + idAdmin + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password=" + password + '}';
    }

    
    
}
