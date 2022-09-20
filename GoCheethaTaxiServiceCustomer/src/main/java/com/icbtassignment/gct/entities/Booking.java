package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

public class Booking {
	
	private String booking_Id ;
	
	private String driver_Id;
	
	private String customer_Id;
	
	@NotBlank(message = "is required")
	private String source_Location;
	
	@NotBlank(message = "is required")
	private String destinationation_Location;
	
	private String pickup_Time;
	private String drop_Time;
	
	@NotBlank(message = "is required")
	private String booking_Status;
	
	@NotBlank(message = "is required")
	private String vehicle_category_Id;
	
	public  Booking() {
		
	}

	public Booking(String booking_Id, String customer_Id, String source_Location, String destinationation_Location,
			String booking_Status, String vehicle_category_Id) {
		super();
		this.booking_Id = booking_Id;
		this.customer_Id = customer_Id;
		this.source_Location = source_Location;
		this.destinationation_Location = destinationation_Location;
		this.booking_Status = booking_Status;
		this.vehicle_category_Id = vehicle_category_Id;
	}

	public Booking(String booking_Id, String driver_Id, String customer_Id, String source_Location,
			String destinationation_Location, String pickup_Time, String drop_Time, String booking_Status,
			String vehicle_category_Id) {
		super();
		this.booking_Id = booking_Id;
		this.driver_Id = driver_Id;
		this.customer_Id = customer_Id;
		this.source_Location = source_Location;
		this.destinationation_Location = destinationation_Location;
		this.pickup_Time = pickup_Time;
		this.drop_Time = drop_Time;
		this.booking_Status = booking_Status;
		this.vehicle_category_Id = vehicle_category_Id;
	}

	public String getBooking_Id() {
		return booking_Id;
	}

	public void setBooking_Id(String booking_Id) {
		this.booking_Id = booking_Id;
	}

	public String getDriver_Id() {
		return driver_Id;
	}

	public void setDriver_Id(String driver_Id) {
		this.driver_Id = driver_Id;
	}

	public String getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getSource_Location() {
		return source_Location;
	}

	public void setSource_Location(String source_Location) {
		this.source_Location = source_Location;
	}

	public String getDestinationation_Location() {
		return destinationation_Location;
	}

	public void setDestinationation_Location(String destinationation_Location) {
		this.destinationation_Location = destinationation_Location;
	}

	public String getPickup_Time() {
		return pickup_Time;
	}

	public void setPickup_Time(String pickup_Time) {
		this.pickup_Time = pickup_Time;
	}

	public String getDrop_Time() {
		return drop_Time;
	}

	public void setDrop_Time(String drop_Time) {
		this.drop_Time = drop_Time;
	}

	public String getBooking_Status() {
		return booking_Status;
	}

	public void setBooking_Status(String booking_Status) {
		this.booking_Status = booking_Status;
	}

	public String getVehicle_category_Id() {
		return vehicle_category_Id;
	}

	public void setVehicle_category_Id(String vehicle_category_Id) {
		this.vehicle_category_Id = vehicle_category_Id;
	}

	@Override
	public String toString() {
		return "Booking [booking_Id=" + booking_Id + ", driver_Id=" + driver_Id + ", customer_Id=" + customer_Id
				+ ", source_Location=" + source_Location + ", destinationation_Location=" + destinationation_Location
				+ ", pickup_Time=" + pickup_Time + ", drop_Time=" + drop_Time + ", booking_Status=" + booking_Status
				+ ", vehicle_category_Id=" + vehicle_category_Id + "]";
	}
	
	

}
