package pws.hw1.sax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andreas
 */
public class Transcript {
    private String name, university, degree;
    private BigDecimal year;
    private List<Course> courses;
    
    public Transcript() {
        name = "";
        university = "";
        degree = "";
        year = BigDecimal.ZERO;
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
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

    public BigDecimal getYear() {
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

    public void setYear(BigDecimal year) {
        this.year = year;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    
}
