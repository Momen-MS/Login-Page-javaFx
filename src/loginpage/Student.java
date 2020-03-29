/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

/**
 *
 * @author MOMEN
 */
public class Student {
    private int id ;
    private String name ; 
    private String Majer ;
    private double Grade ;

    public Student(int id, String name, String Majer, double Grade) {
        this.id = id;
        this.name = name;
        this.Majer = Majer;
        this.Grade = Grade;
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

    public String getMajer() {
        return Majer;
    }

    public void setMajer(String Majer) {
        this.Majer = Majer;
    }

    public double getGrade() {
        return Grade;
    }

    public void setGrade(double Grade) {
        this.Grade = Grade;
    }
    
}
