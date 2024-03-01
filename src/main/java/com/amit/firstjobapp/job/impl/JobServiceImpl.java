package com.amit.firstjobapp.job.impl;


import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.amit.firstjobapp.job.Job;
import com.amit.firstjobapp.job.JobRepository;
import com.amit.firstjobapp.job.JobService;


@Service
public class JobServiceImpl implements JobService{ 
	
	

	//private List<Job> jobs= new ArrayList<>();
	
	
	JobRepository jobRepository;
	
	
	public JobServiceImpl(JobRepository jobRepository) {
	
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAll()
	{
		return jobRepository.findAll();
	}
	
	@Override
	public void createJob(Job job)
	{
		
		//jobs.add(job);
		jobRepository.save(job);
	}
	@Override
	public Job getJobById(Long id)
	{
//		for(Job job:jobs)
//		{
//			if(job.getId().equals(id))
//				return job;
//			
//		}
//		return null;
		
		return jobRepository.findById(id).orElse(null);
	}
	
   @Override
   public boolean deleteJobById(Long id) {
	   
//	   Iterator<Job> iterator =jobs.iterator();
//	   while(iterator.hasNext())
//	   {
//		   Job job = iterator.next();
//		   if(job.getId().equals(id))
//			   iterator.remove();
//		       return true;
//	   }
//	   return false;
	   
	   try {
		   jobRepository.deleteById(id);
		   return true;
		   
	   }catch(Exception e)
	   {
		   return false;
	   }
	   
	   
   }
   
   
   @Override
   public boolean updateJob(Long id,Job updatedJob)
   {
//	   for(Job job:jobs)
//	   {
//		   if(job.getId().equals(id))
//		   {
//			   job.setTitle(updatedJob.getTitle());
//			   job.setDescription(updatedJob.getDescription());
//			   job.setMinSalary(updatedJob.getMinSalary());
//			   job.setLocation(updatedJob.getLocation());
//			   job.setMax   Salary(updatedJob.getMaxSalary());
//			 return true;
//		   }
//	   }
//	   return false;
	   
	   
	 
	    Optional<Job> jobOptional = jobRepository.findById(id);
		   if(jobOptional.isPresent())
		   {
			   Job job = jobOptional.get();
			   job.setTitle(updatedJob.getTitle());
			   job.setDescription(updatedJob.getDescription());
			   job.setMinSalary(updatedJob.getMinSalary());
			   job.setLocation(updatedJob.getLocation());
			   job.setMaxSalary(updatedJob.getMaxSalary());
			   jobRepository.save(job);
			   
			 return true;
		   }
		   else
	         return false;
   }

	
	

}
