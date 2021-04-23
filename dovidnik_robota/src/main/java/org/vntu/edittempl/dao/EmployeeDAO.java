package org.vntu.edittempl.dao;
  
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
  
import org.vntu.edittempl.model.Employee;
import org.vntu.edittempl.model.EmployeeForm;
import org.springframework.stereotype.Repository;
  
@Repository
public class EmployeeDAO {
  
    private static final Map<Long, Employee> empMap = new HashMap<Long, Employee>();
  
    static {
        initEmps();
    }
  
    private static void initEmps() {
			//  Введення тестових даних
        Employee emp1 = new Employee(1L, "Петров Іван Васильович.", "с. Гайдамаки, тел. 093-638-97-12");
        Employee emp2 = new Employee(2L, "Грищенко Сергій Петрович", "компанія Сиві Зорі, тел. 096-528-23-82");
        Employee emp3 = new Employee(3L, "Зінченко Валентина Федірівна", "с. Пастушки, тел. 097-132-23-56");
  
        empMap.put(emp1.getEmpId(), emp1);
        empMap.put(emp2.getEmpId(), emp2);
        empMap.put(emp3.getEmpId(), emp3);
    }
  
    public Long getMaxEmpId() {
        Set<Long> keys = empMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }
  
    public Employee getEmployee(Long empId) {
        return empMap.get(empId);
    }
  
    public Employee addEmployee(EmployeeForm empForm) {
        Long empId= this.getMaxEmpId() + 1;
        empForm.setEmpId(empId);
        Employee newEmp = new Employee(empForm);  
         
        empMap.put(newEmp.getEmpId(), newEmp);
        return newEmp;
    }
  
    public Employee updateEmployee(EmployeeForm empForm) {
        Employee emp = this.getEmployee(empForm.getEmpId());
        if(emp!= null)  {
            emp.setFullName(empForm.getFullName());
            emp.setAddress(empForm.getAddress());
        }  
        return emp;
    }
  
    public void deleteEmployee(Long empId) {
        empMap.remove(empId);
    }
  
    public List<Employee> getAllEmployees() {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }
  
}
