package com.tharun.JobApp.RepositoryDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tharun.JobApp.BusinessBeans.JobPost;

@Repository
public class JobRepo {

	//ArrayList to store all jobPost Objects
	List<JobPost> allJobPosts = new ArrayList<JobPost>();
	
	
	//get all JobPosts
	public List<JobPost> getAllJobPosts()
	{
		return allJobPosts;
	}
	
	//add a JobPost
	public void addJobPost(JobPost jobDetails)
	{
		allJobPosts.add(jobDetails);
		System.out.println("added...");
	}
	
	
	public JobRepo()
	{
		// Java Developer Job Post
				allJobPosts.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
						List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

				// Frontend Developer Job Post
				allJobPosts.add(
						new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
								3, List.of("HTML", "CSS", "JavaScript", "React")));

				// Data Scientist Job Post
				allJobPosts.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
						List.of("Python", "Machine Learning", "Data Analysis")));

				// Network Engineer Job Post
				allJobPosts.add(new JobPost(4, "Network Engineer",
						"Design and implement computer networks for efficient data communication", 5,
						List.of("Networking", "Cisco", "Routing", "Switching")));

				// Mobile App Developer Job Post
				allJobPosts
						.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
								3, List.of("iOS Development", "Android Development", "Mobile App")));

				// DevOps Engineer Job Post
				allJobPosts.add(
						new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
								4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")));

				// UI/UX Designer Job Post
				allJobPosts
						.add(new JobPost(7, "UI/UX Designer", "Create engaging user experiences and intuitive user interfaces",
								2, List.of("User Experience", "User Interface Design", "Prototyping")));

	}
}
