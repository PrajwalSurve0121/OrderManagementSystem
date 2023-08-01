package com.Dao;

import com.Entity.Customer;

public interface CustomerDao {
	
	public void AddCustomer(Customer c);
	public void DeleteCustomer(int cid);
	public void UpdateCustomer(int cid);
	public void DisplayAllCustomer();
	public Customer SearchCustomerById(int cid);
	
}
