package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.CityDao;
import com.icbtassignment.gct.entities.City;

public class CityServices {
	
	public static List<City> getCity(DataSource dataSource){
		
		return CityDao.getCity(dataSource);
	}
	
    public static City get(DataSource dataSource, String cityId) {
		
		return CityDao.get(dataSource,cityId);
	}
    
	public static void addCity(DataSource dataSource, City city) {
		CityDao.addCity(dataSource,city);
		
	}

	public static void updateCity(DataSource dataSource, City city) {
		
			CityDao.updateCity(dataSource,city);
		
		
		
	}
	
	public static void deleteCity(DataSource dataSource, String cityId) {
		 CityDao.deleteCity(dataSource,cityId);
		
	}
	
	
}
