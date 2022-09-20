package com.icbtassignment.gct.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.icbtassignment.gct.entities.City;
import com.icbtassignment.gct.services.CityServices;
import com.icbtassignment.gct.utils.EntityValidator;


@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name ="jdbc/gocheethataxiservicecustomer")
	private DataSource dataSource;

    public CityServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =null;
		command = request.getParameter("command");
		
			if(command.equals("ShowList"))
			{
				mainList(request,response);
			}
			else if(command.equals("ShowUpdate") )
			{
				edit(request,response);
			}
			else if(command.equals("ShowAdd") )
			{
				add(request,response);
			}
			else
			{
				deleteList(request,response);
			}
		
	}

	private void mainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		List<City> city =  CityServices.getCity(dataSource);
		
		request.setAttribute("citylists", city);
		request.getRequestDispatcher("CityList.jsp").forward(request, response);
		}catch(Exception e) {
			PrintWriter out = response.getWriter();
			out.print(e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =request.getParameter("command");
		
		if(command.equals("ADDDATA") )
		{
			addData(request,response);
		}
		if(command.equals("UPDATEDATA") )
		{
			update(request,response);
		}
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.getRequestDispatcher("/CityAdd.jsp").forward(request, response);
			
	}
	
	protected void addData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String cityName = request.getParameter("cityName");
		try {
				
				
					City city = new City(cityName);
					
					EntityValidator<City> validator = new EntityValidator<City>();
					String errors = validator.validate(city);
					
					if(!errors.isEmpty()) {
						request.setAttribute("city", city);
						request.setAttribute("error", errors);
						request.getRequestDispatcher("/CityAdd.jsp").forward(request, response);
					}else {
						CityServices.addCity(dataSource, city);
						 response.sendRedirect("CityServlet?command=ShowList");
					}
			
		
		} catch (Exception e) {
			
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			add(request, response);
		}
	
		
		
		
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String cityId= request.getParameter("id");	
		City city = CityServices.get(dataSource,cityId);
		
		request.setAttribute("city", city);
		request.getRequestDispatcher("/EditCity.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/EditCity.jsp").forward(request, response);
		}
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String CityId = request.getParameter("CityId");
		String CityName = request.getParameter("CityName");
		
		City city = new City(CityId,CityName);
		
		try {
			
				EntityValidator<City> validator = new EntityValidator<City>();
				String errors = validator.validate(city);
				request.setAttribute("exceptionerrorshow", "d-none");
				if(!errors.isEmpty()) {
					request.setAttribute("city", city);
					request.setAttribute("error", errors);
					request.getRequestDispatcher("/EditCity.jsp").forward(request, response);
				}else {
					CityServices.updateCity(dataSource, city);
					response.sendRedirect("CityServlet?command=ShowList");
				}
			
		} catch (Exception e) {
			request.setAttribute("city", city);
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			edit(request, response);
		}
			
	}
	
	protected void deleteList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityId= request.getParameter("id");	
		CityServices.deleteCity(dataSource,cityId);
		mainList(request,response);
	}



}
