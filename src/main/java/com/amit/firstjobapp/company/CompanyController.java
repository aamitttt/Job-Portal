package com.amit.firstjobapp.company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Company>>getAllCompanies()
	{
		return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company)
	{
		companyService.updateCompany(company,id);
		return new ResponseEntity<>("company updated successfully",HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
		
		companyService.createComapny(company);
		
		return new ResponseEntity<>("Company Added successfully",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteCompany(@PathVariable Long id)
	{
		boolean company=companyService.deleteCompanyById(id);
		if(company)
		  return new ResponseEntity<>("comapny deleted succesfully",HttpStatus.OK);
		else
			return new ResponseEntity<>("comapny not found",HttpStatus.NOT_FOUND);
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company>getCompanyById(@PathVariable Long id)
	{
		return new ResponseEntity<>(companyService.getCompanyById(id),HttpStatus.OK);
	}
	

}
