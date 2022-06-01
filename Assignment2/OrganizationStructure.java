package Assignment2;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.*;;

public class OrganizationStructure {
    public Employee ceo;
    private Queue<Employee> employees = new LinkedList<>();
     
    public OrganizationStructure (Employee ceo) {
        this.ceo = ceo;
        employees.add(ceo);
    }

    public static class Employee {
        public String name;
        public String title;
        private List<Employee> directReports = new ArrayList<>();

        public void addDirectReports (Employee dEmployee) {
            directReports.add(dEmployee);
        }
    }

    // if the employee has a list of direct reporter, then print the list of employees
    // then, go by each direct reportee, and check if it also has direct reportee, and follow the same pattern
    // if they don't, we don't print

    public void printLevelByLevel () {
        while (!employees.isEmpty()) {
            // pop the queue and print the employee
            // if that employee has direct reportee, 
                // check if each employee has direct reportee
                // add direct report to the queue
            Employee cEmployee = employees.poll();
            System.out.print(cEmployee.title + " "+ cEmployee.name);
            if (cEmployee.directReports.size() > 0) {
                for (Employee e : cEmployee.directReports) {
                    employees.add(e);
                }
            }
        } 
    }


    public static void main(String[] args) {

        Employee ceo = new Employee();
        ceo.name = "A";
        ceo.title = "CEO";

        OrganizationStructure sparrow = new OrganizationStructure(ceo);

        // subemployee
        Employee cfo = new Employee();
        cfo.name = "B";
        cfo.title = "CFO";

        Employee cto = new Employee();
        cto.name = "C";
        cto.title = "CTO";

        ceo.addDirectReports(cfo);
        ceo.addDirectReports(cto);

        Employee managerOne = new Employee();
        managerOne.name = "D";
        managerOne.title = "M";

        cto.addDirectReports(managerOne);

        sparrow.printLevelByLevel();
    }
}
