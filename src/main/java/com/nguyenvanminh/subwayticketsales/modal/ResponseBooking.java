package com.nguyenvanminh.subwayticketsales.modal;

import java.text.NumberFormat;
import java.util.Locale;

public class ResponseBooking {

	private int id;
	
	private String name;
	
	private String time;

	private String phone;
	
	private int total;
	
	private int quantity;
	
	private String address;
	
	private int status;
	
	public String totalFormat() {
		Locale localeVN = new Locale("vi", "VN");
	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	    String result = currencyVN.format(this.total);
		return result;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ResponseBooking() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ResponseBooking(String name, String time) {
		super();
		this.name = name;
		this.time = time;
	}
	
	
}
