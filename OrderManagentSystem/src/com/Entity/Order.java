package com.Entity;

public class Order {
	
	private int orderid;
	private int custid;
	private int itemid;
	private int quantity;
	private float totaolcost;
	private String orderstatus;
	private String paymentstatus;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderid, int custid, int itemid,int quantity ,float totaolcost, String orderstatus, String paymentstatus) {
		this.orderid = orderid;
		this.custid = custid;
		this.itemid = itemid;
		this.quantity=quantity;
		this.totaolcost = totaolcost;
		this.orderstatus = orderstatus;
		this.paymentstatus = paymentstatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public float getTotaolcost() {
		return totaolcost;
	}

	public void setTotaolcost(float totaolcost) {
		this.totaolcost = totaolcost;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", custid=" + custid + ", itemid=" + itemid + ", quantity=" + quantity
				+ ", totaolcost=" + totaolcost + ", orderstatus=" + orderstatus + ", paymentstatus=" + paymentstatus
				+ "]";
	}

	
	

}
