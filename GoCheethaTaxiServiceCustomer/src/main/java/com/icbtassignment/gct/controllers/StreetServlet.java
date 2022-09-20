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
import com.icbtassignment.gct.entities.Street;
import com.icbtassignment.gct.services.CityServices;
import com.icbtassignment.gct.services.StreetService;
import com.icbtassignment.gct.utils.EntityValidator;


@WebServlet("/StreetServlet")
public class StreetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name ="jdbc/gocheethataxiservicecustomer")
	private DataSource dataSource;
       
   
    public StreetServlet() {
        super();
    }

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =null;
		command = request.getParameter("command");
		
			if(command==null)
			{
				mainList(request,response);
			}
		
			if(command.equals("ShowList"))
			{
				mainList(request,response);
			}
			if(command.equals("ADDDATA"))
			{
				add(request,response);
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
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =request.getParameter("command");
		
		if(command.equals("ADDDATA"))
		{
			addData(request,response);
		}
		if(command.equals("UPDATEDATA") )
		{
			update(request,response);
		}	
		
	}
	
	private void mainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Street> street =  StreetService.getStreet(dataSource,"");
			List<City> cityDrp =  CityServices.getCity(dataSource);
			request.setAttribute("streetlists", street);
			request.setAttribute("cityDrp", cityDrp);
			request.setAttribute("exceptionerrorshow", "d-none");
			request.getRequestDispatcher("/StreetList.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/StreetList.jsp").forward(request, response);
		}
		
	}
	
	
	
		
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<City> cityDrp =  CityServices.getCity(dataSource);
			request.setAttribute("cityDrp", cityDrp);
		
			request.getRequestDispatcher("/StreetAdd.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/StreetAdd.jsp").forward(request, response);
		}
		
	}


	
	protected void addData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String streetName = request.getParameter("StreetName");
			
				
				String cityId = request.getParameter("cityId");
				Street street = new Street(streetName,cityId);
				
				EntityValidator<Street> validator = new EntityValidator<Street>();
				String errors = validator.validate(street);
				request.setAttribute("exceptionerrorshow", "d-none");
				if(!errors.isEmpty()) {
					request.setAttribute("street", street);
					request.setAttribute("error", errors);
				}else {
					StreetService.addStreet(dataSource, street);
					
					 response.sendRedirect("StreetServlet?command=ShowList");
				}
			
			
		} catch (Exception e) {
			
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/StreetAdd.jsp").forward(request, response);
		}
		
	}


	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String streetId= request.getParameter("id");	
			Street street = StreetService.get(dataSource,streetId);
			
			List<City> cityDrp =  CityServices.getCity(dataSource);
			request.setAttribute("cityDrp", cityDrp);
			
			request.setAttribute("street", street);
			request.getRequestDispatcher("/EditStreet.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/EditStreet.jsp").forward(request, response);
			}
		
	}
	
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String streetId = request.getParameter("streetId");
		String streetName = request.getParameter("streetName");
		String cityId = request.getParameter("cityId");
		
		Street street = new Street(streetId,streetName,cityId);
		try {
			
			
				EntityValidator<Street> validator = new EntityValidator<Street>();
				String errors = validator.validate(street);
				request.setAttribute("exceptionerrorshow", "d-none");
				if(!errors.isEmpty()) {
					request.setAttribute("street", street);
					request.setAttribute("error", errors);
					request.getRequestDispatcher("/EditStreet.jsp").forward(request, response);
				}else {
					StreetService.updateStreet(dataSource, street);
					response.sendRedirect("StreetServlet?command=ShowList");
				}
		
				
		} catch (Exception e) {
			request.setAttribute("street", street);
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			edit(request, response);
		}
		
	}
	

	private void deleteList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String streetId= request.getParameter("id");	
		StreetService.deleteStreet(dataSource,streetId);
		mainList(request,response);
		
	}


	


	

}
