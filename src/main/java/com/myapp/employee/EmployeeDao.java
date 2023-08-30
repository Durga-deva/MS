package com.myapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;
	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Successfully added";
	}
	public String addExc(Employee e) {
		empRepo.save(e);
		return "Successfully added";
	}
	
	public Employee getEmployee(int id) {
		return empRepo.findById(id).get();
		
	}
	public String addEmp(List<Employee> e) {
		 empRepo.saveAll(e);
		 return "Successufully created data";
	}
	public List<Employee> getEmp() {
		return empRepo.findAll();	
	}
	public String delEmp(int id) {
		 empRepo.deleteById(id);
		 return "Successfully deleted one column";
	}
	public String upEmp(Employee e) {
		empRepo.save(e);
		return "Successfully update data";
	}
	public String deleteEmp() {
		 empRepo.deleteAll();
		 return "Delete All the rows";
	}
	public List<Employee> getEmployeeBySalary(int salary) {
		return empRepo.getEmployeeBySalary(salary);
	}
	public int getEmployeeMax() {
		return empRepo.getEmployeeMax();
	}
	public List<String> getEmpName() {
		return empRepo.getEmpName();
	}
	public List<String> getEmpNameasc() {
		return empRepo.getEmpNameasc();
	}

}
