package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

public class Street {
	
	private String StreetId;
	
	@NotBlank(message = "is required")
	private String StreetName;
	
	@NotBlank(message = "is required")
	private String CityId;
	
	private String CityName;
	
	public Street() {
		
	}

	public Street(String StreetId) {
		super();
		this.StreetId = StreetId;
	}
	
	public Street(String StreetName,String CityId) {
		super();
		
		this.StreetName = StreetName;
		this.CityId = CityId;
	}

	public Street(String StreetId, String StreetName,String CityId) {
		super();
		this.StreetId = StreetId;
		this.StreetName = StreetName;
		this.CityId = CityId;
	}

	public Street(String StreetId, String StreetName,String CityId, String CityName) {
		super();
		this.StreetId = StreetId;
		this.StreetName = StreetName;
		this.CityId = CityId;
		this.CityName = CityName;
	}

	public String getStreetId() {
		return StreetId;
	}

	public void setStreetId(String streetId) {
		StreetId = streetId;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getCityId() {
		return CityId;
	}

	public void setCityId(String cityId) {
		CityId = cityId;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	@Override
	public String toString() {
		return "Street [StreetId=" + StreetId + ", StreetName=" + StreetName + ", CityId=" + CityId + ", CityName="
				+ CityName + "]";
	}

	
	
	
	
	
	
	
	
	

}
