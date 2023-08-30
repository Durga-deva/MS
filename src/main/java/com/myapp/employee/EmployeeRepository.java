package com.myapp.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//@Query(value="select*from employee_details where salary>=?",nativeQuery=true)
//public List<Employee> getEmployeeBySalary(int salary);
	@Query(value="select max(salary) from employee_details",nativeQuery=true) 
	public int getEmployeeMax();
	@Query(value="select name from employee_details",nativeQuery=true)
	public List<String> getEmpName();
	@Query(value="select name from employee_details order by name desc",nativeQuery=true)
	public List<String> getEmpNameasc();
	@Query("select e from Employee e where e.salary>=:salary")
	public List<Employee> getEmployeeBySalary(@Param ("salary") int salary);
	//@Query("select e.name from Employee e")
	
	
}
