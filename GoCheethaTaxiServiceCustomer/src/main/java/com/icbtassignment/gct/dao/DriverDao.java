package com.icbtassignment.gct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.entities.Driver;
import com.icbtassignment.gct.entities.VehicleCategory;
import com.icbtassignment.gct.utils.CustomException;

public class DriverDao {
	
	public static List<Driver> getCategory(DataSource dataSource){
		 
		List<Driver> Driver = new ArrayList<Driver>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from driver";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				String DriverId  = rset.getString("DriverId");
				String DriverName = rset.getString("DriverName");
				String DriverUserName = rset.getString("DriverUserName");
				String DriverPassword = rset.getString("DriverPassword");
				String VehicleNumber = rset.getString("VehicleNumber");
				String VehicleId = rset.getString("VehicleId");
				String DriverNIC = rset.getString("DriverNIC");
				String DriverPhoneNumber = rset.getString("DriverPhoneNumber");
				String Status = rset.getString("Status");
				Driver driver = new Driver(DriverId,DriverName,DriverUserName, DriverPassword, VehicleNumber, VehicleId, DriverNIC, DriverPhoneNumber, Status  );
				Driver.add(driver);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return Driver;
	
	}
	
	
	public static List<Driver> getCategoryByCity(DataSource dataSource, String DriverId){
		 
		List<Driver> drivers = new ArrayList<Driver>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT DriverId,driver.branch_Id,city.city_Name,driver.vehicle_category_Id,vehicle_category.vehicle_type_Name, vehicle_category.service_Charge,vehicle_category.charge_per_Km, driver_Name,phone_No,address,licence_No,password,vehicle_No FROM driver inner join branch on branch.branch_Id = driver.branch_Id inner join vehicle_category on vehicle_category.vehicle_category_Id = driver.vehicle_category_Id inner join city on city.city_Id = branch.city_Id where branch.city_Id=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, DriverId);
			rset = stmt.executeQuery();
			
			while(rset.next()) {
				String DriverId = rset.getString("DriverId");
				String DriverName = rset.getString("DriverName");
				String DriverUserName = rset.getString("DriverUserName");
				String DriverPassword = rset.getString("DriverPassword");
				String VehicleNumber = rset.getString("VehicleNumber");
				String VehicleId = rset.getString("VehicleId");
				String DriverNIC = rset.getString("DriverNIC");
				String DriverPhoneNumber = rset.getString("DriverPhoneNumber");
				String Status = rset.getString("Status");
				Driver driver = new Driver(DriverId,DriverName,DriverUserName,DriverPassword, VehicleNumber, VehicleId, DriverNIC, DriverPhoneNumber, Status);
				drivers.add(driver);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return drivers;
	}
	
	
	

	public static Driver get(DataSource dataSource,String DriverId){
		 
		Driver Drivers = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from driver where DriverId=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, DriverId);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				
				String DriverId = rset.getString("DriverId");
				String DriverName = rset.getString("DriverName");
				String DriverUserName = rset.getString("DriverUserName");
				String DriverPassword = rset.getString("DriverPassword");
				String VehicleNumber = rset.getString("VehicleNumber");
				String VehicleId = rset.getString("VehicleId");
				String DriverNIC = rset.getString("DriverNIC");
				String DriverPhoneNumber = rset.getString("DriverPhoneNumber");
				String Status = rset.getString("Status");
				Drivers = new Driver(DriverId, DriverName, DriverUserName, DriverPassword, VehicleNumber, VehicleId, DriverNIC, DriverPhoneNumber, Status );
				
							
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return Drivers;
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
	
	
	
	
	
	
	private static void close(Connection con, Statement stmt, Object object) {
		// TODO Auto-generated method stub
		
	}
	
	

}

