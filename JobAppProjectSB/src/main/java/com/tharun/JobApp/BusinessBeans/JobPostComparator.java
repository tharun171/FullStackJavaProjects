package com.tharun.JobApp.BusinessBeans;

import java.util.Comparator;

public class JobPostComparator implements Comparator<JobPost>{

	@Override
	public int compare(JobPost obj1, JobPost obj2) {
		//sort by id
		return ((obj1.getPostId()>obj2.getPostId())?1:-1);

	}

}
