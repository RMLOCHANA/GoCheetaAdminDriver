package com.icbtassignment.gct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.icbtassignment.gct.entities.Branch;
import com.icbtassignment.gct.utils.CustomException;

public class BranchDao {
	public static List<Branch> getBranch(DataSource dataSource, String cityId){
		 
		List<Branch> branchs = new ArrayList<Branch>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT BranchId ,BranchName,branch.CityId,city.CityName FROM branch"
					+ " INNER JOIN city on branch.CityId =city.CityId";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				String BranchId = rset.getString("BranchId");
				String BranchName = rset.getString("BranchName");
				String CityId = rset.getString("CityId");
				String CityName = rset.getString("CityName");
				Branch branch = new Branch(BranchId,BranchName,CityId,CityName);
				branchs.add(branch);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return branchs;
	}

	public static Branch get(DataSource dataSource, String branch_Id) {
		Branch branch = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from branch where branchId = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, branch_Id);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String branchId = rset.getString("branchId");
				String branchName = rset.getString("branchName");
				String cityId = rset.getString("cityId");
				branch = new Branch(branchId, branchName, cityId);
				
				
			}	
			
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return branch;
	}
		
	
	public static List<Branch> getBranchByCity(DataSource dataSource, String cityId) {
		List<Branch> branchs = new ArrayList<Branch>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT BranchId ,BranchName,branch.CityId,city.CityName FROM branch"
					+ " INNER JOIN city on branch.CityId =city.CityId where branch.CityId=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cityId);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String BranchId = rset.getString("BranchId");
				String BranchName = rset.getString("BranchName");
				String CityId = rset.getString("CityId");
				String CityName = rset.getString("CityName");
				Branch branch = new Branch(BranchId, BranchName, CityId, CityName);
				branchs.add(branch);
				
			}		
			
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return branchs;
	}
	
	
	public static void addBranch(DataSource dataSource, Branch branch) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into branch (branchName,cityId) values(?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, branch.getBranchName());
			pstmt.setString(2, branch.getCityId());
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}
	
	public static void updateBranch(DataSource dataSource, Branch branch) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "UPDATE branch SET branchName=?,cityID=? WHERE branchId=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, branch.getBranchName());
			pstmt.setString(2, branch.getCityId());
			pstmt.setString(3, branch.getBranchId());
			pstmt.execute();
			
		} catch (SQLException e) {
			
			throw new CustomException(e.getMessage());
		}finally {
			close(con, pstmt, null);
		}
		
	}
	
	public static void deleteBranch(DataSource dataSource, String branchId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			 sql = "DELETE FROM branch WHERE branchId=?";
			 pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, branchId);
		
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