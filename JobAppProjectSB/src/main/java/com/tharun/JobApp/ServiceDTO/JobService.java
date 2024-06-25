package com.tharun.JobApp.ServiceDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharun.JobApp.BusinessBeans.JobPost;
import com.tharun.JobApp.RepositoryDAO.JobRepo;

@Service
public class JobService {

	@Autowired
	private JobRepo repo;
	
	
	//get all JobPosts
	public List<JobPost> getAllJobPosts()
	{
		return repo.getAllJobPosts();
	}
	
	//add a JobPost
	public void addJobPost(JobPost jobDetails)
	{
		repo.addJobPost(jobDetails);
	}
}
