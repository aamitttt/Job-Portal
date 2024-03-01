package com.amit.firstjobapp.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amit.firstjobapp.company.Company;
import com.amit.firstjobapp.company.CompanyRepository;
import com.amit.firstjobapp.company.CompanyService;


@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepository  companyRepository;
	
	
	

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		
		this.companyRepository = companyRepository;
	}




	@Override
	public List<Company> getAllCompanies() {
		
		return companyRepository.findAll();
	}




	@Override
	public boolean updateCompany(Company company, Long id) {
		
		  Optional<Company> companyOptional = companyRepository.findById(id);
		   
		if(companyOptional.isPresent())
		   {
			   Company companyToUpdate = companyOptional.get();
			   
			   companyToUpdate.setDescription(company.getDescription());
			   companyToUpdate.setName(company.getName());
			   companyToUpdate.setJobs(company.getJobs());
			   
			   companyRepository.save(companyToUpdate);
			   
			 return true;
		   }
		   else
	         return false;
	}




	@Override
	public void createComapny(Company company) {
		
		companyRepository.save(company);
	}




	@Override
	public boolean deleteCompanyById(Long id) {
	   
		   try {
			   companyRepository.deleteById(id);
			   return true;
			   
		   }catch(Exception e)
		   {
			   return false;
		   }
		
	}




	@Override
	public Company getCompanyById(Long companyId) {
		
		return companyRepository.findById(companyId).orElse(null);
	}
	
	

}
