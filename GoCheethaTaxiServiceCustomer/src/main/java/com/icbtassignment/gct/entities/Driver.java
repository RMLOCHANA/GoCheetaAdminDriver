package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

public class Driver {
	
	
	private String DriverId;
	
	private String DriverName;
	
	private String DriverUserName;
	
	private String DriverPassword;
	
	private String VehicleNumber;
	
	private String VehicleId;
	
	private String DriverNIC;
	
	private String DriverPhoneNumber;
	
	private String Status;

	
	public Driver () {
			
	}


	public Driver(String driverId, String driverName, String driverUserName, String driverPassword,
			String vehicleNumber, String vehicleId, String driverNIC, String driverPhoneNumber, String status) {
		super();
		DriverId = driverId;
		DriverName = driverName;
		DriverUserName = driverUserName;
		DriverPassword = driverPassword;
		VehicleNumber = vehicleNumber;
		VehicleId = vehicleId;
		DriverNIC = driverNIC;
		DriverPhoneNumber = driverPhoneNumber;
		Status = status;
	}


	public String getDriverId() {
		return DriverId;
	}


	public void setDriverId(String driverId) {
		DriverId = driverId;
	}


	public String getDriverName() {
		return DriverName;
	}


	public void setDriverName(String driverName) {
		DriverName = driverName;
	}


	public String getDriverUserName() {
		return DriverUserName;
	}


	public void setDriverUserName(String driverUserName) {
		DriverUserName = driverUserName;
	}


	public String getDriverPassword() {
		return DriverPassword;
	}


	public void setDriverPassword(String driverPassword) {
		DriverPassword = driverPassword;
	}


	public String getVehicleNumber() {
		return VehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		VehicleNumber = vehicleNumber;
	}


	public String getVehicleId() {
		return VehicleId;
	}


	public void setVehicleId(String vehicleId) {
		VehicleId = vehicleId;
	}


	public String getDriverNIC() {
		return DriverNIC;
	}


	public void setDriverNIC(String driverNIC) {
		DriverNIC = driverNIC;
	}


	public String getDriverPhoneNumber() {
		return DriverPhoneNumber;
	}


	public void setDriverPhoneNumber(String driverPhoneNumber) {
		DriverPhoneNumber = driverPhoneNumber;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	@Override
	public String toString() {
		return "Driver [DriverId=" + DriverId + ", DriverName=" + DriverName + ", DriverUserName=" + DriverUserName
				+ ", DriverPassword=" + DriverPassword + ", VehicleNumber=" + VehicleNumber + ", VehicleId=" + VehicleId
				+ ", DriverNIC=" + DriverNIC + ", DriverPhoneNumber=" + DriverPhoneNumber + ", Status=" + Status + "]";
	}
	
	
	
	
}


