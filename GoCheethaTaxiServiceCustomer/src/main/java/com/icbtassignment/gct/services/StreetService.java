package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.StreetDao;
import com.icbtassignment.gct.entities.Street;



public class StreetService {
	
	
	public static List<Street> getStreet(DataSource dataSource,String cityId){
			
			return StreetDao.getStreet(dataSource,cityId);
	}
	
	public static List<Street> getStreetByCity(DataSource dataSource,String cityId){
		
		return StreetDao.getStreetByCity(dataSource,cityId);
	}
	
	public static void addStreet(DataSource dataSource, Street street) {
		StreetDao.addStreet(dataSource, street);
	}
	
	public static void updateStreet(DataSource dataSource, Street street) {
		StreetDao.updateStreet(dataSource, street);
		
	}
	
	public static void deleteStreet(DataSource dataSource, String streetId) {
		StreetDao.deleteStreet(dataSource, streetId);
	}

	public static Street get(DataSource dataSource, String street_Id) {
		
		return (Street) StreetDao.getStreet(dataSource, street_Id) ;
	}
	
	
	
	
	
	

	

}
