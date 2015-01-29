/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.sax;

import java.util.Date;

/**
 *
 * @author andreas
 */
public class Employment {
    private String company;
    private int salary;
    private Date start;
    private Date end;

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
