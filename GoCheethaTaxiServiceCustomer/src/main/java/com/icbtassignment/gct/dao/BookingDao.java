package com.icbtassignment.gct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.entities.Booking;

import com.icbtassignment.gct.utils.CustomException;

public class BookingDao {
	
	
	public static List<Booking> getBooking(DataSource dataSource,String customerId){
		 
		List<Booking> bookings = new ArrayList<Booking>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from booking where customer_Id=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customerId);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String booking_Id = rset.getString("booking_Id");
				String driver_Id = rset.getString("driver_Id");
				String customer_Id = rset.getString("customer_Id");
				String source_Location = rset.getString("source_Location");
				String destinationation_Location = rset.getString("destinationation_Location");
				String pickup_Time = rset.getString("pickup_Time");
				String drop_Time = rset.getString("drop_Time");
				String booking_Status = rset.getString("booking_Status");
				String vehicle_category_Id = rset.getString("vehicle_category_Id");
				
				Booking booking = new Booking(booking_Id,driver_Id,customer_Id,source_Location,destinationation_Location,pickup_Time,drop_Time,booking_Status,vehicle_category_Id);
				bookings.add(booking);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return bookings;
	}

	public static void addBooking(DataSource dataSource, Booking booking) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "INSERT INTO booking(booking_Id,driver_Id,customer_Id,source_Location,destinationation_Location,pickup_Time,drop_Time,booking_Status,vehicle_category_Id)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, booking.getBooking_Id());
			pstmt.setString(2, booking.getDriver_Id());
			pstmt.setString(3, booking.getCustomer_Id());
			pstmt.setString(4, booking.getSource_Location());
			pstmt.setString(5, booking.getDestinationation_Location());
			pstmt.setString(6, booking.getPickup_Time());
			pstmt.setString(7, booking.getDrop_Time());
			pstmt.setString(8, booking.getBooking_Status());
			pstmt.setString(9, booking.getVehicle_category_Id());
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}
	
	private static void close(Connection con,Statement stmt,ResultSet rset) {
		try {
			if(rset != null)
			{
				rset.close();
			}
			if(stmt != null)
			{
				stmt.close();
			}
			
			if(con != null)
			{
				con.close();
			}
			
		} catch (SQLException e) {
			throw new CustomException(e.getMessage());
		}
		
	}


}
