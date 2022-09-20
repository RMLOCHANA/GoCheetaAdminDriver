package com.icbtassignment.gct.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.entities.City;
import com.icbtassignment.gct.utils.CustomException;

public class CityDao {

	public static List<City> getCity(DataSource dataSource){
		 
		List<City> cities = new ArrayList<City>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from city";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				String cityId = rset.getString("CityId");
				String cityname = rset.getString("CityName");
				City city = new City(cityId,cityname);
				cities.add(city);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return cities;
 }
	

	public static City get(DataSource dataSource, String cityId) {
		City cities = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from city where CityId=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cityId);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String CityId = rset.getString("CityId");
				String CityName = rset.getString("CityName");
				cities = new City(CityId,CityName);
				
				
			}	
			
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return cities;
	}
	
	
	public static void addCity(DataSource dataSource, City city) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into city (CityName) values(?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, city.getCityName());
			
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}

	
	public static void updateCity(DataSource dataSource, City city) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "UPDATE city SET CityName=? WHERE CityId=?";
			 pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, city.getCityName());
			pstmt.setString(2, city.getCityId());
		
			pstmt.execute();
			
		} catch (SQLException e) {
			throw new CustomException(e.getMessage());
		}finally {
			close(con, pstmt, null);
		}
		
	}
	
	public static void deleteCity(DataSource dataSource, String CityId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "DELETE FROM city WHERE CityId=?";
			 pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, CityId);
		
			pstmt.execute();
			
		} catch (SQLException e) {
			throw new CustomException(e.getMessage());
		}finally {
			close(con, pstmt, null);
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

