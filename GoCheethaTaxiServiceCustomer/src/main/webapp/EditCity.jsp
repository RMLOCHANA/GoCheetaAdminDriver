 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	 <title>GoCheetha Taxi - City List</title>
	<jsp:include page="header.html"></jsp:include>
 

</head>

<body  class="Light-edition">

  	<div class="wrapper ">
  		<jsp:include page="sidebar.html"></jsp:include>
    <div class="main-panel">
      
      <jsp:include page="navbar.html"></jsp:include>
     
      
      <div class="content">
      
      
         <a href="CityServlet?command=ShowList" class="btn btn-Secondary btn-round ml-auto font-weight-bold">Show Table</a>
          <h2 class="card-title font-weight-bold d-flex ">Update City </h2>
     <div class="row">
          <div class="col-md-6 grid-margin stretch-card">
			<form action="CityServlet" method="post">
          
         <div class="card" id="addcity" >
		 <div class="card-body">
								
									<div class="form-group row d-none">
											<input type="hidden" name="command" value="UPDATEDATA">
			                    	</div>
								
									<div class="form-group row d-none">
										<label class = "col-4 col-form-label" for="txtCityId">City ID</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="CityId" id="txtCityId" value="${city.cityId }"  >
				                        
				                        </div>
			                    	</div>
			                    	
			                    	<div class="form-group row">
			                    	
										<label class = "col-4 col-form-label" for="txtCityName">City Name</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="CityName" id="txtCityName" value="${city.cityName }"  >
												
										</div>
			                    	</div>
			                    	<div class="form-group row has-error has-feedback">
										<label for="errorInput">${error }</label>
			                    	</div>
									<div class="card-action">
									<button type="submit" class="btn btn-success ">Update</button>
									  <a href="CityServlet?command=ShowList" class="btn btn-danger">Cancel</a>
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