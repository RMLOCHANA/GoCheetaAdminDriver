package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

public class Branch {
	
	private String BranchId ;
	
	@NotBlank(message = "is required")
	private String BranchName;
	
	@NotBlank(message = "is required")
	private String CityId;
	

	private String CityName;
	
	public Branch() {
		
	}
	
	public Branch(String BranchId) {
		super();
		this.BranchId = BranchId;
	}

	public Branch(String BranchName, String CityId) {
		super();
		
		this.BranchName = BranchName;
		this.CityId = CityId;
	}
	
	public Branch(String BranchId, String BranchName, String CityId) {
		super();
		
		this.BranchId = BranchId;
		this.BranchName = BranchName;
		this.CityId = CityId;
	}

	public Branch(String BranchId, String BranchName, String CityId, String CityName) {
		super();
		this.BranchId = BranchId;
		this.BranchName = BranchName;
		this.CityId = CityId;
		this.CityName = CityName;
	}

	public String getBranchId() {
		return BranchId;
	}

	public void setgetBranchId(String branchId) {
		this.BranchId = branchId;
	}

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		this.BranchName = branchName;
	}

	public String getCityId() {
		return CityId;
	}

	public void setCityId(String cityId) {
		this.CityId = cityId;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		this.CityName = cityName;
	}

	@Override
	public String toString() {
		return "Branch [BranchId=" + BranchId + ", BranchName=" + BranchId + ", CityId=" + CityId
				+ ", CityName=" + CityName + "]";
	}
	
	
}
