package com.myapp.employee;

import java.util.List;
import java.util.stream.Collectors;

//import com.myapp.vehicle.Entity.Car;

//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;
	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}
	public String addExc(Employee e) throws AgeException{
		try {
	if(e.getAge()<18 && e.getAge()>62) {
		throw new AgeException("Age is not Eligible");
	}
	else {
		return empDao.addExc(e);
	
		}
	}
	catch(AgeException ae)
	{
		return ae.getMessage();
	}
	
}
		public Employee getEmployee(int id) {
		return empDao.getEmployee(id);
	}
		
		
		
	public String addEmp(List<Employee> e) {
		return empDao.addEmp(e);
	}
	public List<Employee> getEmp() {
		return empDao.getEmp();
	}
	public String delEmp(int id) {
		return empDao.delEmp(id);
	}
	public String upEmp(Employee e) {
		return empDao.upEmp(e);
	}
	public String deleteEmp() {
		return empDao.deleteEmp();
	}
	public List<Employee> getByname(String name) {
		List<Employee> li=empDao.getEmp();
		return li.stream().filter(x->x.getName().equalsIgnoreCase(name)).toList();
	}
	public List<Employee> getNames(String names) throws NameNotFound {
		List<Employee> li=empDao.getEmp();
		List<Employee> allName=li.stream().filter(x->x.getName().equalsIgnoreCase(names)).toList();
		if(allName.isEmpty()) {
			throw new NameNotFound("Give name is not found");
		}
		else {
			return allName;
		}
		
	}
	public List<String> getNames() {
		List<Employee> li=empDao.getEmp();
		return li.stream().map(x->x.getName()).toList();
	}
	public List<Integer> getIds() {
		List<Employee> li=empDao.getEmp();
		return li.stream().map(x->x.getId()).toList();
	}
	public List<Integer> getAges() {
		List<Employee> li=empDao.getEmp();
		return li.stream().map(x->x.getAge()).toList();
	}
	public List<Employee> getAgese(int ages)throws AgeNotFoundException {
		List<Employee> li=empDao.getEmp();
		List<Employee> allage=li.stream().filter(x->x.getAge()==ages).toList();
		if(allage.isEmpty()) {
			throw new AgeNotFoundException("Age not found");
		}
		else {
			return allage;
		}
		
	}
	public List<String> getGenders() {
		List<Employee> li=empDao.getEmp();
		return li.stream().map(x->x.getGender()).toList();
	}
	public List<Integer> getSalarys() {
		List<Employee> li=empDao.getEmp();
		return li.stream().map(x->x.getSalary()).toList();
	}
	
	public List<Employee> getGender(String gender) {
		List<Employee> li=empDao.getEmp();
		return li.stream().filter(x->x.getGender().equalsIgnoreCase(gender)).toList();
	}
	public List<String> getGenders(String genders) {
		List<Employee> li=empDao.getEmp();
		return li.stream().filter(x->x.getGender().equalsIgnoreCase(genders)).map(y->y.getName()).toList();
	}
	public List<Employee> getAGes() {
		List<Employee> li=empDao.getEmp();
		return li.stream().map(x->{ 
			
	    if(x.getAge()>=30&&x.getAge()<=35) {
		x.setSalary(x.getSalary()+x.getSalary()*10/100);
	      }
		 if(x.getAge()>35&&x.getAge()<=40) {
		 x.setSalary(x.getSalary()+x.getSalary()*15/100); 
		}
		 if(x.getAge()>40&& x.getAge()<=50) {
		 x.setSalary(x.getSalary()+x.getSalary()*20/100);
		}
		 return x;
		 }). collect(Collectors.toList());
	
			}
	public List<Employee> getEmployeeBySalary(int salary) {
		return empDao.getEmployeeBySalary(salary);
	}
	public int getEmployeeMax() {
		return empDao.getEmployeeMax();
	}
	public List<String> getEmpName() {
		return empDao.getEmpName();
	}
	public List<String> getEmpNameasc() {
		return empDao.getEmpNameasc();
	}

}
