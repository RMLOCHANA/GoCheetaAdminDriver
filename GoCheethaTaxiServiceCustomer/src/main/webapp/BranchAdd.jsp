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
      
      
         <a href="BranchServlet?command=ShowList" class="btn btn-Secondary btn-round ml-auto">Show Table</a>
          <h2 class="card-title font-weight-bold d-flex ">Add Branch </h2>
     <div class="row">
          <div class="col-md-6 grid-margin stretch-card">
			<form action="BranchServlet" method="post">
          
         <div class="card" id="addbranch" >
		 <div class="card-body">
								
								<div class="form-group row d-none">
											<input type="hidden" name="command" value="ADDDATA">
			                    	</div>
								
									<div class="form-group row d-none">
										<label class = "col-4 col-form-label" for="txtBranchId">Branch ID</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="BranchId " id="txtBranchId " value="${branch.branchId }" >
				                        
				                        </div>
			                    	</div>
			                    	
			                    	<div class="form-group row">
										<label class = "col-4 col-form-label" for="txtBranchName">Branch Name</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="BranchName" id="txtBranchName" value="${branch.branchName }" >
												
										</div>
			                    	</div>
			                    	
			                    		<div class="form-group row">
			                    	
										<label class = "col-4 col-form-label" for="txtCityId">City Name</label>
				                        <div class="col-8"> 
				                         	<select name="cityId" class="form-control ">
				                         		
											    <c:forEach items="${cityDrp}" var="city">
											        <option class="text-dark" value="${city.cityId}">${city.cityName}</option>
											    </c:forEach>
											    
											</select>
												
										</div>
			                    	</div>
			                    	
			                    	<div class="form-group row has-error has-feedback">
										<label for="errorInput">${error }</label>
			                    	</div>
									
								<div class="card-action">
									<button type="submit" class="btn btn-success ">Add</button>
									 <a href="BranchServlet?command=ShowList" class="btn btn-danger">Cancel</a>
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