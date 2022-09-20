package com.icbtassignment.gct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.icbtassignment.gct.entities.Street;
import com.icbtassignment.gct.utils.CustomException;


public class StreetDao {

	
	public static List<Street> getStreet(DataSource dataSource, String cityId){
		 
		List<Street> streets = new ArrayList<Street>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT StreetId,StreetName,street.CityId,city.CityName FROM street"
					+ " INNER JOIN city on street.CityId =city.CityId";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				String StreetId = rset.getString("StreetId");
				String StreetName = rset.getString("StreetName");
				String CityId = rset.getString("CityId");
				String CityName = rset.getString("CityName");
				Street street = new Street(StreetId,StreetName,CityId,CityName);
				streets.add(street);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return streets;
	}
	
	public static Street get(DataSource dataSource, String street_Id) {
		Street street = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from street where streetId = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, street_Id);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String streetId = rset.getString("streetId");
				String streetName = rset.getString("streetName");
				String cityId = rset.getString("cityId");
				street = new Street(streetId,streetName,cityId);
				
				
			}	
			
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return street;
	}
	
	public static List<Street> getStreetByCity(DataSource dataSource, String cityId){
		 
		List<Street> streets = new ArrayList<Street>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT StreetId,StreetName,street.CityId,city.CityName FROM street"
					+ " INNER JOIN city on street.CityId =city.CityId where street.CityId=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cityId);
			rset = stmt.executeQuery();
			
			while(rset.next()) {
				String StreetId = rset.getString("StreetId");
				String StreetName = rset.getString("StreetName");
				String CityId = rset.getString("CityId");
				String CityName = rset.getString("CityName");
				Street street = new Street(StreetId,StreetName,CityId,CityName);
				streets.add(street);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return streets;
	}

	public static void addStreet(DataSource dataSource, Street street) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into street (streetName,cityId) values(?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, street.getStreetName());
			pstmt.setString(2, street.getCityId());
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}
	
	public static void updateStreet(DataSource dataSource, Street street) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "UPDATE street SET streetName=?,cityID=? WHERE streetId=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, street.getStreetName());
			pstmt.setString(2, street.getCityId());
			pstmt.setString(3, street.getStreetId());
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomException(e.getMessage());
		}finally {
			close(con, pstmt, null);
		}
		
	}
	
	public static void deleteStreet(DataSource dataSource, String streetId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "DELETE FROM street WHERE streetId=?";
			 pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, streetId);
		
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			throw new CustomException(e.getMessage());
		}
		
	}

	

	

	

	

}
