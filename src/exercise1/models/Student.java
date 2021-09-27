package exercise1.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private LocalDate birthDay;

    private String address;

    private StudentGender gender;

    @ManyToMany
    private List<Lesson> lessons = new ArrayList<>();


    public Student(String name, LocalDate birthDay, String address, StudentGender gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
    }

    public Student(){

    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StudentGender getGender() {
        return gender;
    }

    public void setGender(StudentGender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(birthDay, student.birthDay) && Objects.equals(address, student.address) && gender == student.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDay, address, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
