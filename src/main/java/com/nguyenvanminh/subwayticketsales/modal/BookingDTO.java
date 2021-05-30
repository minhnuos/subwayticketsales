package com.nguyenvanminh.subwayticketsales.modal;

public class BookingDTO {

	private int id;
	
	private int total;
	
	private String time;
	
	private int status;
	
	private CustomerDTO customerDTO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int isStatus() {
		return status;
	}

	public void getStatus(int status) {
		this.status = status;
	}

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	
	
}
