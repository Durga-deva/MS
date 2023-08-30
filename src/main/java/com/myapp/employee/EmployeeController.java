package com.myapp.employee;

//import com.myapp.vehicle.Entity.Car;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService empSer;

	@PostMapping(value = "/add")
	public String addEmployee(@RequestBody Employee e) {
		return empSer.addEmployee(e);
	}
	@PostMapping(value = "/exception")
	public String addExc(@RequestBody Employee e) throws AgeException {
		
		return empSer.addExc(e);
		}

	@GetMapping(value = "/check/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empSer.getEmployee(id);
	}
	

	@PostMapping(value = "/postlist")
	public String addEmp(@RequestBody List<Employee> e) {
		return empSer.addEmp(e);
	}

	@GetMapping(value="/checks")
	public List<Employee> getEmp() {
		return empSer.getEmp();
	}
		@DeleteMapping(value="/del/{id}")
		public String delEmp(@PathVariable int id) {
			return empSer.delEmp(id);
		}
		@PutMapping(value="update")
		public String upEmp(@RequestBody Employee e) {
			return empSer.upEmp(e);
		}
		@DeleteMapping(value="/delete")
		public String deleteEmp() {
			return empSer.deleteEmp();
		}
		@GetMapping(value="/getByname/{name}")
		public List<Employee> getEmp(@PathVariable String name){
			return empSer.getByname(name);
		}
		
		@GetMapping(value="/getNames/{names}")
		public List<Employee> getNames(@PathVariable String names) throws NameNotFound{
			return empSer.getNames(names);
		}
		
		@GetMapping(value="/getname")
		public List<String> getNames()
		{
			return empSer.getNames();
		}
		@GetMapping(value="/getid")
		public List<Integer> getIds()
		{
			return empSer.getIds();
		}
		
		@GetMapping(value="/getage")
		public List<Integer> getAges()
		{
			return empSer.getAges();
		}
		@GetMapping(value="/getages/{ages}")
		public List<Employee> getAgese(@PathVariable int ages)throws AgeNotFoundException
		{
			return empSer.getAgese(ages);
		}
		@GetMapping(value="/getgender")
		public List<String> getGenders()
		{
			return empSer.getGenders();
		}
		@GetMapping(value="/getsalary")
		public List<Integer> getSalarys()
		{
			return empSer.getSalarys();
		}
		
		@GetMapping(value="/getBygender/{gender}")
		public List<Employee> getGender(@PathVariable String gender){
			return empSer.getGender(gender);
		}
		@GetMapping(value="/getBygender/{genders}")
		public List<String> getGenders(@PathVariable String genders){
			return empSer.getGenders(genders);
	 }
		
		@GetMapping(value="/getages")
		public List<Employee> getAGes(){
			return empSer.getAGes();
		}
		@GetMapping(value="getmaxSal/{salary}")
		public List<Employee> getEmployeeBySalary(@PathVariable int salary) {
			return empSer.getEmployeeBySalary(salary);
		}
		
		@GetMapping(value="getmax")
		public int getEmployeeMax() {
			return empSer.getEmployeeMax();
		}
		@GetMapping(value="getnames")
		public List<String> getEmpName() {
			return empSer.getEmpName();
		}
		@GetMapping(value="getnameasc")
		public List<String> getEmpNameasc() {
			return empSer.getEmpNameasc();
		}
		
		RestTemplate rest= new RestTemplate();
		
		@GetMapping(value="/getviaemployee")
			public List<Car> getviacar(){
			String url="http://localhost:8081/car/checks";
			ResponseEntity<List<Car>> response=rest.exchange(url,HttpMethod.GET,null,
					new ParameterizedTypeReference<List<Car>>(){});
		    List<Car> value=response.getBody();
		    return value;
		}
		@GetMapping(value="getIdviaemployee/{id}")
		public Car getviaId(@PathVariable int id) {
			String url="http://localhost:8081/car/check/";
			ResponseEntity<Car> response=rest.exchange(url+id,HttpMethod.GET,null,Car.class);
			Car value=response.getBody();
			return value;
		}
}



















