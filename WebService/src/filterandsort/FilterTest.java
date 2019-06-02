package filterandsort;

import java.util.*;

public class FilterTest {
    static Collection<Employee> empList = new ArrayList<>();

    static void initData() {
        empList.add(new Employee("James", "Dean", 2000, true));
        empList.add(new Employee("John", "Smith", 5000, false));
        empList.add(new Employee("Michael", "Corry", 4600, true));
        empList.add(new Employee("Emy", "Assad", 7500, true));
        empList.add(new Employee("Alexa", "Kim", 12000, true));
        empList.add(new Employee("Kate", "Homes", 2800, false));
        empList.add(new Employee("Olga", "Shin", 4900, true));
        empList.add(new Employee("Daniel", "Lee", 3300, true));

        System.out.println("---- Initial data ----");
        empList.forEach(e -> System.out.println(e));
    }

    static void sortUsingStreamFilter() {
        System.out.println("\n---- sort using stream");
        empList.stream()
                .filter(e -> e.isMarried() && e.getSalary() > 3000)
                .sorted((e1, e2) -> e2.getSalary() - e1.getSalary())    // descending order
                // .sorted(Comparator.comparing(Employee::getSalary).reversed())       // other way
                .limit(5)   // get top 5
                .forEach(e -> System.out.println(e));   // print using lambda
                // .forEach(System.out::println);       // other way
    }

    static void sortWithoutStreamUsingLoop() {
        System.out.println("\n---- sort without stream");

        ArrayList<Employee> filteredEmpList = new ArrayList<>();
        empList.forEach(employee -> {
            if (employee.isMarried() && employee.getSalary() > 3000) filteredEmpList.add(employee);
        });

        // descending order
        Collections.sort(filteredEmpList, (e1, e2) -> e2.getSalary() - e1.getSalary());

        // to test reverse method
        // Collections.reverse(filteredEmpList);

        // print list of maximum 5 married people
        for (int i = 0; i < filteredEmpList.size() || i < 5; i++) {
            System.out.println(filteredEmpList.get(i));
        }
    }

    static public void main(String[] args) {
        // initialize data
        initData();

        // using stream
        sortUsingStreamFilter();

        // test without stream
        sortWithoutStreamUsingLoop();
    }
}
