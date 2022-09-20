<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	 <title>GoCheetha Taxi - City List</title>
	<jsp:include page="header.html"></jsp:include>
 

</head>

<body  class="light-edition">

  	<div class="wrapper ">
  		<jsp:include page="sidebar.html"></jsp:include>
    <div class="main-panel">
      
      <jsp:include page="navbar.html"></jsp:include>
     
      
      <div class="content">
      
         <a href="DriverServlet?command=ShowAdd"  class="btn btn-light btn-round ml-auto font-weight-bold"> <i class="fa fa-plus"></i> Add Driver   </a> 
        <h2 class="card-title font-weight-bold d-flex ">Driver Details  </h2>	
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
							<th class="d-none">Driver ID</th>
							<th class="d-none">Branch ID</th>
							<th class="d-none">Type ID</th>
							<th><b>Branch</b></th>
							<th><b>Vehicle Type</b></th>
							<th><b>Driver Name</b></th>													
							<th><b>Mobile No</b></th>
							<th><b>Address</b></th>
							<th><b>Licence No</b> </th>
							<th><b>Password </b></th>							
							<th><b>Vehicle No</b> </th>
							<th style="width: 10%"><b>Action</b></th>
					</tr>
					
                    </thead>
                    <tbody id="tblBody">
                    <c:forEach  items="${driverlists}" var="driver">
                    
                       <tr id="row_${driver.driverId  }">
                      <td class="d-none">${driver.driverId}</td> 
                      <td class="d-none">${driver.branchId}</td>
                      <td class="d-none">${driver.vehicleId}</td>
                      <td>${driver.driverName}</td>                                                                                    
                      <td>${driver.branchName}</td>
                      <td>${driver.vehicleName}</td>
                      <td>${driver.phoneNo}</td>
                      <td>${driver.address}</td>                     
                      <td>${driver.licenceNo}</td>
                      <td>${driver.password}</td>
                      <td>${driver.vehicleNo}</td>
                      
                        <td style="width: 10%">
                        <div class="form-button-action">
                        
                        	<a href="DriverServlet?command=ShowUpdate&id=${driver.driverId}"  class="table-icon text-primary ">Edit
                        	<i class="fa fa-edit"></i>
                        	</a>
                        	&nbsp;
		                    <a href="DriverServlet?command=ShowDelete&id=${driver.driverId}"  class="table-icon text-danger">Delete
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