package com.nguyenvanminh.subwayticketsales.dao;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.entity.Day;

public interface DayDAO {

	
	public List<Day> listDays();
	
	public void addDay(Day day);
	
	public Day findDaybyDay(String day);
	
}
