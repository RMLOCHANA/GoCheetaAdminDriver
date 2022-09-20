<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	 <title>GoCheetha Taxi - Branch Add</title>
	<jsp:include page="header.html"></jsp:include>
 

</head>

<body  class="light-edition">

  	<div class="wrapper ">
  		<jsp:include page="sidebar.html"></jsp:include>
    <div class="main-panel">
      
      <jsp:include page="navbar.html"></jsp:include>
     
      
      <div class="content">
      
      
         <a href="DriverServlet?command=ShowList" class="btn btn-Secondary btn-round ml-auto">Show Table</a>
          
     <div class="row">
          <div class="col-md-6 grid-margin stretch-card">
			<form action="Driver" method="post">
          
         <div class="card" id="adddriver" >
		 <div class="card-body">
								
								<div class="form-group row d-none">
											<input type="hidden" name="command" value="ADDDATA">
			                    	</div>
								
									<div class="form-group row d-none">
										<label class = "col-4 col-form-label" for="txtDriverId">Driver ID</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="DriverId" id="txtDriverId" value="${driver.driverId }" >
				                        
				                        </div>
			                    	</div>
			                    	
			                    	<div class="form-group row">
										<label class = "col-4 col-form-label" for="txtdriverName">Driver Name</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="driverName" id="txtdriverName" value="${driver.driverName }" >
												
										</div>
			                    	</div>
			                    	
			                    	<div class="form-group row">
										<label class = "col-4 col-form-label" for="txtbranchName">Branch Name</label>
				                        <div class="col-8"> 
				                         	<select name="branchId" class="form-control">
				                         		
											    <c:forEach items="${branchDrp}" var="branch">
											        <option value="${branch.branchId}">${branch.branchName} - ${branch.cityName}</option>
											    </c:forEach>
											</select>
										</div>
			                    	</div>
			                    	
			                    	<div class="form-group row ">
										<label class = "col-4 col-form-label" for="txtvehicleId">Vehicle Type</label>
				                        <div class="col-8"> 
				                         	<select name="vehicleId" class="form-control">
				                         		
											    <c:forEach items="${vehicleDrp}" var="vehicle">
											        <option value="${vehicle.vehicleId}">${vehicle.vehicleName}</option>
											    </c:forEach>
											</select>
				                        </div>
			                    	</div>
			                    	
			                    	
			                    	<div class="form-group row">
										<label class = "col-4 col-form-label" for="txtphoneNo">TelePhone No</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="phoneNo" id="txtphoneNo" value="${driver.phoneNo }" >
												
										</div>
			                    	</div>
			                    	
			                    	<div class="form-group row">
										<label class = "col-4 col-form-label" for="txtaddress">Address</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="address" id="txtaddress" value="${driver.address }" >
												
										</div>
			                    	</div>
			                    	
			                    	<div class="form-group row">
										<label class = "col-4 col-form-label" for="txtlicenceNo">Licence No</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="licenceNo" id="txtlicenceNo" value="${driver.licenceNo }" >
												
										</div>
			                    	</div>
			                    	
			                    	<div class="form-group row">
										<label class = "col-4 col-form-label" for="txtpassword">Driver Password</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="password" id="txtpassword" value="${driver.password }" >
												
										</div>
			                    	</div>
			                    	
			                    	<div class="form-group row">
										<label class = "col-4 col-form-label" for="txtvehicleNo">Vehicle No</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="vehicleNo" id="txtvehicleNo" value="${driver.vehicleNo }" >
												
										</div>
			                    	</div>
			                    	
			                    	<div class="form-group row has-error has-feedback">
										<label for="errorInput">${error }</label>
			                    	</div>
									
								<div class="card-action">
									<button type="submit" class="btn btn-success ">Update</button>
									 <a href="BranchList.jsp" class="btn btn-danger">Cancel</a>
								</div>
								
								</div>
								
			</div>
			</form>
			</div>
			</div>
     
      
        </div>
          <jsp:include page="footer.html"></jsp:include>
      
      
    </div>
  </div>
 
	
	
	
</body>

</html>