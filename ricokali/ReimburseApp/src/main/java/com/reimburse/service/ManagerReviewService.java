package com.reimburse.service;

import java.util.List;

import com.reimburse.hibernate.model.Manager_Request;
import com.reimburse.repository.*;

public class ManagerReviewService 
{
	private ManagerReview managerReview = new ManagerReviewDAOImpl();
	
	public List<Manager_Request> getReview(int manager_id)
	{
			return this.managerReview.getReview(manager_id);
	}
}
