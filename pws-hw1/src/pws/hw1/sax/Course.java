/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.sax;

/**
 *
 * @author Andreas
 */
public class Course {
    private String name, code;
    private int grade, credits;
    
    public Course() {
        name = "";
        code = "";
        grade = 0;
        credits = 0;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getGrade() {
        return grade;
    }

    public int getCredits() {
        return credits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
