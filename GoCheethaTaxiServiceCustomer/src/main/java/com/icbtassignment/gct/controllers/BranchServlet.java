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

import com.icbtassignment.gct.entities.Branch;
import com.icbtassignment.gct.entities.City;
import com.icbtassignment.gct.services.BranchService;
import com.icbtassignment.gct.services.CityServices;
import com.icbtassignment.gct.utils.EntityValidator;



@WebServlet("/BranchServlet")
public class BranchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name ="jdbc/gocheethataxiservicecustomer")
	private DataSource dataSource;
  
    public BranchServlet() {
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
			List<Branch> branch =  BranchService.getBranch(dataSource,"");
			List<City> cityDrp =  CityServices.getCity(dataSource);
			request.setAttribute("branchlists", branch);
			request.setAttribute("cityDrp", cityDrp);
			request.setAttribute("exceptionerrorshow", "d-none");
			request.getRequestDispatcher("/BranchList.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/BranchList.jsp").forward(request, response);
		}
		
	}
	
		
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<City> cityDrp =  CityServices.getCity(dataSource);
			request.setAttribute("cityDrp", cityDrp);
		
			request.getRequestDispatcher("/BranchAdd.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/BranchAdd.jsp").forward(request, response);
		}
		
	}
	
	private void addData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String branchName = request.getParameter("BranchName");
			
				
				String cityId = request.getParameter("cityId");
				Branch branch = new Branch(branchName,cityId);
				
				EntityValidator<Branch> validator = new EntityValidator<Branch>();
				String errors = validator.validate(branch);
				request.setAttribute("exceptionerrorshow", "d-none");
				if(!errors.isEmpty()) {
					request.setAttribute("branch", branch);
					request.setAttribute("error", errors);
				}else {
					BranchService.addBranch(dataSource, branch);
					
					 response.sendRedirect("BranchServlet?command=ShowList");
				}
			
			
		} catch (Exception e) {
			
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/BranchAdd.jsp").forward(request, response);
		}
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String branchId= request.getParameter("id");	
			Branch branch = BranchService.get(dataSource,branchId);
			
			List<City> cityDrp =  CityServices.getCity(dataSource);
			request.setAttribute("cityDrp", cityDrp);
			
			request.setAttribute("branch", branch);
			request.getRequestDispatcher("/EditBranch.jsp").forward(request, response);
			}catch (Exception e) {
				request.setAttribute("exceptionerror", e.toString());
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/EditBranch.jsp").forward(request, response);
			}
		
	}
	

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branchId = request.getParameter("branchId");
		String branchName = request.getParameter("branchName");
		String cityId = request.getParameter("cityId");
		
		Branch branch = new Branch(branchId,branchName,cityId);
		try {
			
			
				EntityValidator<Branch> validator = new EntityValidator<Branch>();
				String errors = validator.validate(branch);
				request.setAttribute("exceptionerrorshow", "d-none");
				if(!errors.isEmpty()) {
					request.setAttribute("branch", branch);
					request.setAttribute("error", errors);
					request.getRequestDispatcher("/EditBranch.jsp").forward(request, response);
				}else {
					BranchService.updateBranch(dataSource, branch);
					response.sendRedirect("BranchServlet?command=ShowList");
				}
		
				
		} catch (Exception e) {
			request.setAttribute("branch", branch);
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			edit(request, response);
			
		}
		
	}

	

	private void deleteList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branchId= request.getParameter("id");	
		BranchService.deleteBranch(dataSource,branchId);
		mainList(request,response);
		
	}


	




	

	


}
