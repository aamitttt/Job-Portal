package com.amit.firstjobapp.company;

import java.util.List;

import com.amit.firstjobapp.job.Job;
import com.amit.firstjobapp.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy="company")
	private List<Job>jobs;
	
	@OneToMany(mappedBy="company")
  private List<Review>review;

	public Company()
	{
		
	}
	public Company(Long id, String name, String description, List<Job> jobs) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
	}
	
	

	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	
	
	
	
}
