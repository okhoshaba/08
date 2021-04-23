package org.vntu.edittempl.model;
 
public class Employee {
 
    private Long empId;
	  private String fullName;
 		private String address;

    public Employee() {
 
    }
 
    public Employee(EmployeeForm empForm) {
        this.empId = empForm.getEmpId();
        this.fullName = empForm.getFullName();
        this.address = empForm.getAddress();
    }
 
    public Employee(Long empId, String fullName, String address) {
        this.empId = empId;
        this.fullName = fullName;
        this.address = address;
    }
 
    public Long getEmpId() {
        return empId;
    }
 
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
 
    public String getFullName() {
        return fullName;
    }
 
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }

}
