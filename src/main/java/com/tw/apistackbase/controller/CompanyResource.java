package com.tw.apistackbase.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tw.apistackbase.bean.Company;
import com.tw.apistackbase.bean.Employee;

@RestController
@RequestMapping("/companies")

public class CompanyResource {
	 	private static List<Employee> employeeList = new ArrayList<Employee>() {{
			add(new Employee(1));
			add(new Employee(2));
		}};
		private static List<Company> companyList = new ArrayList<Company>() {{
			add(new Company("0001","huawei",2300,employeeList));	
			add(new Company("0002","zybank",2600,employeeList));
		}};
		
		 	@GetMapping
		    public  ResponseEntity<List<Company>> getCompanies() {	 			 	
		        return ResponseEntity.ok(companyList);
		   }	 		 	
		 	 
		 	 //获取某个特定的公司
		 	 @GetMapping(path = "/{id}")
		 	 public ResponseEntity<Company> getOneCompany(@PathVariable String id) {	 		
		 	  for(Company company:companyList) {
		 	        if(company.getId().equals(id)) {
		 	          return ResponseEntity.ok(company);      
		 	        }
		 	       }
		 	        return null;
		 	 }
		 	//获取某个公司下的所有员工
		 		@GetMapping(path = "/{id}/employees")
		 		public ResponseEntity<Object> getAllemployeesOfOneCompany(@PathVariable String id){
		 			for(Company company:companyList) {
		 				if (company.getId().equals(id)) {
		 					return ResponseEntity.ok(company.getEmployees());
		 				}
		 			}
		 			return new ResponseEntity(HttpStatus.NOT_FOUND);
		 		}
		 		
		 		//分页查询
//		 		@GetMapping(path = "/{id}/employees")
//		 		public ResponseEntity<Object> getOnePageOfCompany(@PathVariable String id,
//		 				int page, int pageSize
//		 				
//		 				){
//		 			for(Company company:companyList) {
//		 				if (company.getId().equals(id)) {
//		 					return ResponseEntity.ok(company.getEmployees());
//		 				}
//		 			}
//		 			return new ResponseEntity(HttpStatus.NOT_FOUND);
//		 		}
		 				 		
		 		//添加一个公司
		 		@PostMapping(path = "/add") 
		 		public ResponseEntity<Object> addOneEmployee(@RequestBody Employee updateCompany){
		 			for (Company company:companyList) {		 			
		 					company.setId(company.getId());
		 					company.setCompanyName(company.getCompanyName());
		 					company.setEmployees(company.getEmployees());
		 					company.setEmployeesNumber(company.getEmployeesNumber());
		 					return ResponseEntity.ok(company);
		 			
		 			}		
		 			return new ResponseEntity(HttpStatus.NOT_FOUND);		
		 		}
		 		
		 		//更新一个公司的基本信息
//		 		@PutMapping(path = "/update/{id}") 
//		 		public ResponseEntity<Object> updateEmployee(@PathVariable String id){
//		 			for (Company company:companyList) {	 
//		 			if(company.getId().equals(id)) {		
//		 					company.setId(company.getId());
//		 					company.setCompanyName(company.getCompanyName());
//		 					company.setEmployees(company.getEmployees());
//		 					company.setEmployeesNumber(company.getEmployeesNumber());
//		 					return ResponseEntity.ok(company);
//		 			
//		 			}
//		 		}		
//		 			return new ResponseEntity(HttpStatus.NOT_FOUND);		
//		 		}
		 	   @PutMapping(consumes="application/json")
				public ResponseEntity<Company> updateCompany(@RequestBody Company company){
		 		  companyList.add(company);
		 		 return ResponseEntity.ok(company);
				}
		 	//删除一个公司
			    @DeleteMapping("/{id}")
				public ResponseEntity<Company> deleteEmployeeByID(@PathVariable String id){
			    	for (Company company:companyList) {
						if (company.getId().equals(id)) {
							companyList.remove(company);				
							return ResponseEntity.ok(company);
						}
					}
					return new ResponseEntity(HttpStatus.NOT_FOUND);
					 
				} 


			 
}
