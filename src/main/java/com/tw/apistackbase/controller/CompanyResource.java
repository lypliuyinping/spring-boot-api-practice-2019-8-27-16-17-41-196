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
	List<Company> companyList=new ArrayList<Company>();
	List<Employee> employeeList=new ArrayList<Employee>();
	
	 	@GetMapping
	    public  ResponseEntity<List> getCompanies() {	 		
	 		employeeList.add(new Employee(1));
	 		employeeList.add(new Employee(2));
	 		companyList.add(new Company("0001","huawei",2300,employeeList));
	 		companyList.add(new Company("0002","zybank",2600,employeeList));
	        return ResponseEntity.ok(companyList);
	   }

	 	
}
