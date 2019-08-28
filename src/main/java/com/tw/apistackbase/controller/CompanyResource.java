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
		 	 public ResponseEntity<Company> queryCompany(@PathVariable String id) {
		 		
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
		 		

	 	
}
