<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	 <title>GoCheetha Taxi - City List</title>
	<jsp:include page="header.html"></jsp:include>
 

</head>

<body  class="dark-edition">

  	<div class="wrapper ">
  		<jsp:include page="sidebar.html"></jsp:include>
    <div class="main-panel">
      
      <jsp:include page="navbar.html"></jsp:include>
     
      
      <div class="content">
      
      
         <button type="button"  class="btn btn-secondary btn-round ml-auto" onclick="addcity();"> <i class="fa fa-plus"></i> Add City </button>
         <button type="button" class="btn btn-warning btn-round ml-auto" onclick="viewdata();">Show Table</button>
          
     <div class="row">
          <div class="col-md-6 grid-margin stretch-card">
			<form action="StreetControllerServlet" method="post">
          
         <div class="card" id="addcity" >
		 <div class="card-body">
								
									<div class="form-group row d-none">
											<input type="hidden" name="command" value="ADDDATA">
			                    	</div>
								
									<div class="form-group row d-none">
										<label class = "col-4 col-form-label" for="txtCityId">City ID</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="CityId" id="txtCityId" value="${citylists.CityId }" >
				                        
				                        </div>
			                    	</div>
			                    	
			                    	<div class="form-group row">
			                    	
										<label class = "col-4 col-form-label" for="txtCityName">City Name</label>
				                        <div class="col-8"> 
				                         	<input type="text" class="form-control" name="CityName" id="txtCityName" value="${citylists.CityName }" placeholder="Enter City">
												
										</div>
			                    	</div>
			                    	<div class="form-group row has-error has-feedback">
										<label for="errorInput">${error }</label>
			                    	</div>
									<div class="card-action">
									<button type="submit" class="btn btn-success ">Add</button>
									  <a href="CityControllerServlet" class="btn btn-danger">Cancel</a>
								</div>
									
				</div>
								
			</div>
			</form>
			</div>
			</div>
     
       <div class="row">
            <div class="col-lg-12 col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">City  Data  List</h4>
               
                </div>
                <div class="card-body table-responsive">
                  <table class="table table-hover">
                    <thead class="text-warning">
                      <div class="p-1 pl-0">
					     <label><input type="search" class="form-control form-control-sm" id="txtKeyW" autofocus="autofocus" onkeyup="SearchStart()" placeholder="Search Here"></label>										
					</div>
					
					<tr>
                      <th>City Name</th>
                      <th>Action Task</th>
                      </tr>

                    </thead>
                    <tbody>
                    <c:forEach  items="${citylists}" var="citylists">
                    
                      <tr>
                        <td>${citylists.CityId}</td>
                        <td>${citylists.Cityname}</td>
                        <td></td>
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