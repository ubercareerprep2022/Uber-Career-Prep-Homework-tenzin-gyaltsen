package Assignment2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;;

public class OrganizationStructure {
    public Employee ceo;
    private Queue<Employee> employees = new LinkedList<>();

    public OrganizationStructure(Employee ceo) {
        this.ceo = ceo;
        employees.add(ceo);
    }

    public static class Employee {
        public String name;
        public String title;
        private List<Employee> directReports = new ArrayList<>();

        public void addDirectReports(Employee dEmployee) {
            directReports.add(dEmployee);
        }
    }

    // if the employee has a list of direct reporter, then print the list of employees and update employees at same level
    // then, go by each direct reportee, and check if it also has direct reportee,
    // and follow the same pattern
    // if they don't, we don't print
    public void printLevelByLevel() {
        int employeesAtSameLevel = 1;
        while (!employees.isEmpty()) {
            // pop the queue and print the employee, and reduce employee at same level by one count
            // if that employee has direct reportee,
            // check if each employee has direct reportee
            // add direct report to the queue
            // when employee at same level is 0, then update the length of employee at same level by the size of queue and direct report size
            Employee cEmployee = employees.poll();
            employeesAtSameLevel--;
            System.out.print(cEmployee.title + "   ");

            if (employeesAtSameLevel == 0 && !(employeesAtSameLevel < 0)) {
                System.out.println();
                employeesAtSameLevel += employees.size() + cEmployee.directReports.size();
            } 

            if (cEmployee.directReports.size() > 0) {
                for (Employee e : cEmployee.directReports) {
                    employees.add(e);
                }
            }
        }
    }

    public static void main(String[] args) {

        Employee ceo = new Employee();
        ceo.name = "Braden";
        ceo.title = "CEO";

        OrganizationStructure sparrow = new OrganizationStructure(ceo);

        // subemployee
        Employee cfo = new Employee();
        cfo.name = "Gautam";
        cfo.title = "CFO";

        Employee cto = new Employee();
        cto.name = "Shubham";
        cto.title = "CTO";

        ceo.addDirectReports(cfo);
        ceo.addDirectReports(cto);

        Employee finAdvisor = new Employee();
        finAdvisor.name = "Raju";
        finAdvisor.title = "Advisor";
        cfo.addDirectReports(finAdvisor);

        Employee manager = new Employee();
        manager.name = "Rahul";
        manager.title = "Manager";
        cto.addDirectReports(manager);

        Employee assistant = new Employee();
        assistant.name = "Tashi";
        assistant.title = "Assistant";
        manager.addDirectReports(assistant);

        sparrow.printLevelByLevel();
    }
}
