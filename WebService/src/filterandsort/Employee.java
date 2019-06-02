package filterandsort;

import java.util.Objects;

public class Employee {
    private String name;
    private String family;
    private int salary;
    private boolean isMarried;

    public Employee(String name, String family, int salary, boolean isMarried) {
        this.name = name;
        this.family = family;
        this.salary = salary;
        this.isMarried = isMarried;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(family, employee.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, family);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", salary=" + salary +
                ", isMarried=" + isMarried +
                '}';
    }
}
