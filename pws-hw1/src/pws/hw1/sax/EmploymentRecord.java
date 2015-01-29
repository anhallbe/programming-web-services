/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.sax;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreas
 */
public class EmploymentRecord {
    private String surName, lastName;
    private List<Employment> employments;

    public EmploymentRecord() {
        employments = new ArrayList<>();
    }

    public String getSurName() {
        return surName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Employment> getEmployments() {
        return employments;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setEmployments(List<Employment> employments) {
        this.employments = employments;
    }
    
    public void addEmployment(Employment employment) {
        employments.add(employment);
    }

    @Override
    public String toString() {
        String result = "";
        result += "first name: " + surName;
        result += "\nlast name: " + lastName;
        result += "\nemployments:";
        for(Employment course : employments) {
            result += "\n------------";
            result += "\n" + course.getCompany();
            result += "\n" + course.getSalary();
            result += "\n" + course.getStart();
            result += "\n" + course.getEnd();
        }
        
        return result;
    }
}
