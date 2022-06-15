package Assignment2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;;

public class OrganizationStructure {
    private Employee ceo;
    private Queue<Employee> employees = new LinkedList<>();
    private int levels;

    public OrganizationStructure(Employee ceo) {
        this.ceo = ceo;
        levels = 1;
        employees.add(ceo);
    }

    public Employee getCeo () {
        return ceo;
    }

    public static class Employee {
        private String name;
        private String title;
        private List<Employee> directReports = new ArrayList<>();

        public Employee (String name, String title) {
            this.name = name;
            this.title = title;
        }

        public String getName () {
            return name;
        }

        public String getTitle () {
            return title;
        }

        public void addDirectReports(Employee dEmployee) {
            directReports.add(dEmployee);
        }
    }

    // if the employee has a list of direct reporter, then print the list of employees and update employees at same level
    // then, go by each direct reportee, and check if it also has direct reportee,
    // and follow the same pattern
    // if they don't, we don't print
    public void printLevelByLevel() {
        traverseOrgByLevel(true);
    }

    public int traverseOrgByLevel (Boolean toPrint) {
        levels = 0;
        employees.clear();
        employees.add(ceo);
        int employeesAtSameLevel = employees.size();
        while (!employees.isEmpty()) {
            // pop the queue and print the employee, and reduce employee at same level by one count
            // if that employee has direct reportee,
            // check if each employee has direct reportee
            // add direct report to the queue
            // when employee at same level is 0, then update the length of employee at same level by the size of queue and direct report size
            Employee cEmployee = employees.poll();
            employeesAtSameLevel--;
            
            if(toPrint) {
                System.out.print(cEmployee.title + "   ");
            }

            if (employeesAtSameLevel == 0) {
                if(toPrint) {
                    System.out.println();
                }
                employeesAtSameLevel += employees.size() + cEmployee.directReports.size();
                levels++;
            } 

            if (cEmployee.directReports.size() > 0) {
                for (Employee e : cEmployee.directReports) {
                    employees.add(e);
                }
            }
        }
        return levels;
    }

    public void printNumLevels () {
        System.out.println(traverseOrgByLevel(false));
    }

    public static void main(String[] args) {

        Employee ceo = new Employee("Braden", "CEO");
        OrganizationStructure sparrow = new OrganizationStructure(ceo);

        // subemployee
        Employee cfo = new Employee("Gautam", "CFO");
        Employee cto = new Employee("Shubham", "CTO");
        ceo.addDirectReports(cfo);
        ceo.addDirectReports(cto);

        Employee finAdvisor = new Employee("Raju", "Advisor");
        cfo.addDirectReports(finAdvisor);

        Employee manager = new Employee("Rahul", "Manager");
        cto.addDirectReports(manager);

        Employee assistant = new Employee("Tashi", "Assistant");
        manager.addDirectReports(assistant);

        sparrow.printLevelByLevel();
        System.out.println();
        sparrow.printNumLevels();
    }
}
