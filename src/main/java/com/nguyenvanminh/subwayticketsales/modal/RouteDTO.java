package com.nguyenvanminh.subwayticketsales.modal;

public class RouteDTO {

	private int id;
	
	private StopPointDTO stopPointDTOStart;
	
	private StopPointDTO stopPointDTOEnd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StopPointDTO getStopPointDTOStart() {
		return stopPointDTOStart;
	}

	public void setStopPointDTOStart(StopPointDTO stopPointDTOStart) {
		this.stopPointDTOStart = stopPointDTOStart;
	}

	public StopPointDTO getStopPointDTOEnd() {
		return stopPointDTOEnd;
	}

	public void setStopPointDTOEnd(StopPointDTO stopPointDTOEnd) {
		this.stopPointDTOEnd = stopPointDTOEnd;
	}
	
	
	
}
