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
public class Transcript {
    private String name, university, degree;
    private int year;
    List<Course> courses;

    public Transcript() {
        courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String getDegree() {
        return degree;
    }

    public int getYear() {
        return year;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        String result = "";
        result += "name: " + name;
        result += "\nuniversity: " + university;
        result += "\ndegree: " + degree;
        result += "\nyear: " + year;
        result += "\nCourses:";
        for(Course course : courses) {
            result += "\n------------";
            result += "\n" + course.getName();
            result += "\n" + course.getCode();
            result += "\n" + course.getGrade();
        }
        
        return result;
    }
}
