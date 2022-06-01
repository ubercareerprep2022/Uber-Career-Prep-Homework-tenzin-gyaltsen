package Assignment2;

import java.util.List;

import Assignment2.OrganizationStructure.Employee;

public class OrgTreeNode {
    public Employee data;
    public List<OrgTreeNode> subEmployees;

    public OrgTreeNode(Employee data, List<OrgTreeNode> subEmployees) {
      this.data = data;
      this.subEmployees = subEmployees;
    }
}
