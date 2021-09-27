package exercise1.models;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class GuestTeacher extends Teacher {

    private double hourlySalary;

    public GuestTeacher(String name, String address, long phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public GuestTeacher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public GuestTeacher() {

    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GuestTeacher that = (GuestTeacher) o;
        return Double.compare(that.hourlySalary, hourlySalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlySalary);
    }

    @Override
    public String toString() {
        return "GuestTeacher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
