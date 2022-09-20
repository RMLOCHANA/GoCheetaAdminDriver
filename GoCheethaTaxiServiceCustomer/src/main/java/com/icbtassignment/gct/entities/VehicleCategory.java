package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

public class VehicleCategory {

	private String VehicleId ;
	
	@NotBlank(message = "is required")
	private String VehicleName;
	
	@NotBlank(message = "is required")
	private String ServiceCharge;
	
	@NotBlank(message = "is required")
	private String ChargePerkm;
	
	
	public VehicleCategory() {
		
	}


	public VehicleCategory(String VehicleId) {
		super();
		this.VehicleId = VehicleId;
	}


	public VehicleCategory(String VehicleId, String  VehicleName, String ServiceCharge, String ChargePerkm) {
		super();
		this.VehicleId = VehicleId;
		this.VehicleName = VehicleName;
		this.ServiceCharge = ServiceCharge;
		this.ChargePerkm = ChargePerkm;
	}


	public String getVehicleId() {
		return VehicleId;
	}


	public void setVehicleId(String VehicleId) {
		this.VehicleId = VehicleId;
	}


	public String getVehicleName() {
		return VehicleName;
	}


	public void setVehicleName(String VehicleName) {
		this.VehicleName = VehicleName;
	}


	public String getServiceCharge() {
		return ServiceCharge;
	}


	public void setServiceCharge(String ServiceCharge) {
		this.ServiceCharge = ServiceCharge;
	}


	public String getChargePerkm() {
		return ChargePerkm;
	}


	public void setChargePerkm(String ChargePerkm) {
		this.ChargePerkm = ChargePerkm;
	}


	@Override
	public String toString() {
		return "VehicleCategory [VehicleId=" + VehicleId + ", VehicleName="
				+ VehicleName + ", ServiceCharge=" + ServiceCharge + ", ChargePerkm=" + ChargePerkm + "]";
	}
	
	

}
