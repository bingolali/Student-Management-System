package exercise1.models;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class ConstantTeacher extends Teacher{

    private double fixedSalary;

    public ConstantTeacher(String name, String address, long phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public ConstantTeacher(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public ConstantTeacher() {

    }

    public double getfixedSalarySalary() {
        return fixedSalary;
    }

    public void setfixedSalarySalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ConstantTeacher that = (ConstantTeacher) o;
        return Double.compare(that.fixedSalary, fixedSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fixedSalary);
    }

    @Override
    public String toString() {
        return "ConstantTeacher{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}
