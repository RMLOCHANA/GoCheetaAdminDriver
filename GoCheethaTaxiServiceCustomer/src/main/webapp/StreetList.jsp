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
      
         <a href="StreetServlet?command=ShowAdd"  class="btn btn-light btn-round ml-auto font-weight-bold"> <i class="fa fa-plus"></i> Add Street   </a> 
        <h2 class="card-title font-weight-bold d-flex ">Street List  </h2>	
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
                      <th class="d-none">Street ID</th>
                      <th><b>Street Name</b></th>
                      <th class="d-none">City ID</th>
                      <th><b>City Name</b></th>
                      
                      <th style="width: 10%"><b>Action Task</b></th>
                      </tr>

                    </thead>
                    <tbody id="tblBody">
                    <c:forEach  items="${streetlists}" var="street">
                    
                       <tr id="row_${street.streetId}">
                      <td class="d-none">${street.streetId}</td>                     
                        <td>${street.streetName}</td>
                        <td class="d-none">${street.cityId}</td>   
                        <td>${street.cityName}</td>
                        
                        <td style="width: 10%">
                        <div class="form-button-action">
                        
                        	<a href="StreetServlet?command=ShowUpdate&id=${street.streetId}"  class="table-icon text-primary">Edit
                        	<i class="fa fa-edit"></i>
                        	</a>
                        	&nbsp; &nbsp;
		                    <a href="StreetServlet?command=ShowDelete&id=${street.streetId}"  class="table-icon text-danger">Delete
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