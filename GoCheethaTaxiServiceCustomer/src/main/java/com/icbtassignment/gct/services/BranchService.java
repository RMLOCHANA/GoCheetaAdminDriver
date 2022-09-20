package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.BranchDao;
import com.icbtassignment.gct.entities.Branch;




public class BranchService {
	
	public static List<Branch> getBranch(DataSource dataSource, String cityId){
		
		return BranchDao.getBranch(dataSource,cityId);
	}

	public static List<Branch> getBranchByCity(DataSource dataSource, String cityId) {
		return BranchDao.getBranchByCity(dataSource,cityId);
		
	}
	
	public static void addBranch(DataSource dataSource, Branch branch) {
		BranchDao.addBranch(dataSource, branch);
		
	}
	
	public static void updateBranch(DataSource dataSource, Branch branch) {
		BranchDao.updateBranch(dataSource, branch);
		
	}
	
	public static void deleteBranch(DataSource dataSource, String branchId) {
		BranchDao.deleteBranch(dataSource, branchId);
	}
	
	public static Branch get(DataSource dataSource, String branch_Id) {
		// TODO Auto-generated method stub
		return (Branch) BranchDao.getBranch(dataSource, branch_Id) ;
	}
	
}