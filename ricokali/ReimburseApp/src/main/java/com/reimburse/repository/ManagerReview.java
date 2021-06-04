package com.reimburse.repository;

import java.util.List;

import com.reimburse.hibernate.model.Manager_Request;

public interface ManagerReview 
{
List<Manager_Request> getReview(int manager_id);
}
