package com.nguyenvanminh.subwayticketsales.modal;

import java.text.NumberFormat;
import java.util.Locale;

public class RevenueMonth {

	private int total;
	private double percent;
	private int quantitySold;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	
	public String numberFormat(int number) {
		Locale localeVN = new Locale("vi", "VN");
	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	    String result = currencyVN.format(number);
		return result;
	}
	
	
}
