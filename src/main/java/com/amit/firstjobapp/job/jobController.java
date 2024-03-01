package com.amit.firstjobapp.job;


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
@RequestMapping("/jobs")
public class jobController {
	
	
	
	private JobService jobService;
	
	
	public jobController(JobService jobService) {
		
		this.jobService = jobService;
	}

	@GetMapping("")
	public ResponseEntity<List<Job>>findAll()
	{
		return new ResponseEntity<List<Job>>(jobService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<String> createJob(@RequestBody Job job)
	{
		
		
		jobService.createJob(job);
		return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	
		public ResponseEntity<Job> getJobById(@PathVariable Long id)
		{
		  Job job =jobService.getJobById(id);
		
			if(job!=null)
				return new ResponseEntity<>(job,HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id)
	{
	  boolean deleted =jobService.deleteJobById(id);
	
		if(deleted)
			return new ResponseEntity<>("job deleted succesfully",HttpStatus.OK);
		else
			return new ResponseEntity<>("job not found",HttpStatus.NOT_FOUND);
			
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob)
	{
		boolean update = jobService.updateJob(id,updatedJob);
		
		if(update)
			return new ResponseEntity<>("job updated succesfully",HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	

}
