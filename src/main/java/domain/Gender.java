/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nahuel
 */
public class Gender {
    private int idGender;
    private String name;
    
    public Gender(){}

    public Gender(int idGender) {
        this.idGender = idGender;
    }

    public Gender(String name) {
        this.name = name;
    }

    public Gender(int idGender, String name) {
        this.idGender = idGender;
        this.name = name;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gender{" + "idGender=" + idGender + ", name=" + name + '}';
    }
    
}
