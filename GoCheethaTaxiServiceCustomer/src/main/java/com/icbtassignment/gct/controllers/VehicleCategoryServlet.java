package com.icbtassignment.gct.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.icbtassignment.gct.entities.VehicleCategory;

import com.icbtassignment.gct.services.VehicleCategoryService;

/**
 * Servlet implementation class VehicleCategoryServlet
 */
@WebServlet("/VehicleCategoryServlet")
public class VehicleCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name ="jdbc/gocheethataxiservicecustomer")
	private DataSource dataSource;
	

    public VehicleCategoryServlet() {
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
				update(request,response);
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
			edit(request,response);
		}
	}
	
	
	private void mainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<VehicleCategory> vehicleCategory =  VehicleCategoryService.getCategory(dataSource);
			request.setAttribute("vehiclelists", vehicleCategory);			
			request.setAttribute("exceptionerrorshow", "d-none");
			request.getRequestDispatcher("/VehicleList.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/VehicleList.jsp").forward(request, response);
		}
		
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/VehicleAdd.jsp").forward(request, response);
		
	}
	
	
	
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void addData(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void deleteList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	


	


	

}
