package com.nguyenvanminh.subwayticketsales.modal;

import java.text.NumberFormat;
import java.util.Locale;

public class ResponseRevenue {

	private String name;
	
	private int revenue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRevenue() {
		return revenue;
	}

	public ResponseRevenue() {
		super();
		this.name = "Chưa có số liệu";
		this.revenue = 0;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	
	public String revenueFormat() {
		Locale localeVN = new Locale("vi", "VN");
	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	    String result = currencyVN.format(this.revenue);
		return result;
	}
	
}
