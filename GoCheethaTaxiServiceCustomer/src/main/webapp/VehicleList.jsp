<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	 <title>GoCheetha Taxi - Vehicle List</title>
	<jsp:include page="header.html"></jsp:include>
 

</head>

<body  class="light-edition">

  	<div class="wrapper ">
  		<jsp:include page="sidebar.html"></jsp:include>
    <div class="main-panel">
      
      <jsp:include page="navbar.html"></jsp:include>
     
      
      <div class="content">
      
         <a href="VehicleCategoryServlet?command=ShowAdd"  class="btn btn-light btn-round ml-auto font-weight-bold"> <i class="fa fa-plus"></i> Add Vehicle   </a> 
        <h2 class="card-title font-weight-bold d-flex ">Vehicle List  </h2>	
       <div class="row">      
            <div class="col-lg-12 col-md-12 font-weight-bold ">
            
             <div class="card">
              <div class="card-body table-responsive">
              
              
              <div class="p-1 pl-0">
					<label><input type="search" class="form-control form-control" id="txtKeyW" autofocus="autofocus" onkeyup="SearchStart()" placeholder="Search Here"></label>		
					</div>				
					
						    											 
			
               <table class="table table-hover">
                    <thead class="text-info ">
                    
					<tr>
                      <th class="d-none">Vehicle ID</th>
                      <th><b>Vehicle Name</b></th>
                      <th><b>Service Charge</b></th>   
                      <th><b>Charge per Km</b></th>                                   
                      <th style="width: 10%"> <b>Action Task</b></th>
                      </tr>

                    </thead>
                    <tbody id="tblBody">
                    <c:forEach  items="${vehiclelists}" var="vehiclelists">
                    
                       <tr>
                      <td class="d-none">${vehiclelists.vehicleId }</td>                     
                        <td>${vehiclelists.vehicleName}</td>
                        <td>${vehiclelists.serviceCharge}</td>
                        <td>${vehiclelists.chargePerkm}</td>
                        
                        <td style="width: 10%">
                        <div class="form-button-action">
                        
                        	<a href="VehicleCategoryServlet?command=ShowUpdate&id=${vehiclelists.vehicleId}"  class="table-icon text-primary">Edit
                        	<i class="fa fa-edit"></i>
                        	</a>
                        	&nbsp; &nbsp;
		                    <a href="VehicleCategoryServlet?command=ShowDelete&id=${vehiclelists.vehicleId}"  class="table-icon text-danger">Delete
		                    <i class="fa fa-trash"></i>
		                    </a>
		                    </div>
		                </td>
                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            </div>
            </div>	
            <jsp:include page="footer.html"></jsp:include>
       </div>
      
        </div>
      
      
      
  
	
	
	
</body>

</html>