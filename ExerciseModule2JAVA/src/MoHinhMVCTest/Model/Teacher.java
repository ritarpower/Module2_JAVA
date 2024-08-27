package MoHinhMVCTest.Model;

import java.time.LocalDate;

public class Teacher extends Person {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher(String name, LocalDate birthDate, String code, String email, double salary) {
        super(name, birthDate, code, email);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                "," + " salary=" + salary +
                '}';
    }
}
