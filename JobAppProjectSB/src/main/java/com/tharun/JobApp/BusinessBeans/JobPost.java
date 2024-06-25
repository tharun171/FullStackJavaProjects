package com.tharun.JobApp.BusinessBeans;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {
	
	
	private Integer postId;
	private String postProfile;
	private String postDescription;
	private Integer requiredExp;
	private List<String> postTechStack;

}
