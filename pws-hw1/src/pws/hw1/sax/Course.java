/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.sax;

/**
 *
 * @author andreas
 */
public class Course {
    private String name, code;
    private int grade;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getGrade() {
        return grade;
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
}
