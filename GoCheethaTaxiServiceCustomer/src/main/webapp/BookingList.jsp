<!DOCTYPE html>
<html>

<head>
	 <title>GoCheetha Taxi</title>
	<jsp:include page="header.html"></jsp:include>
 

</head>

<body  class="light-edition">

  	<div class="wrapper ">
  		<jsp:include page="SidebarDriver.html"></jsp:include>
    <div class="main-panel">
      <!-- Navbar -->
      <jsp:include page="navbar.html"></jsp:include>
      <!-- End Navbar -->
      <div class="content">
      
         
        <h2 class="card-title font-weight-bold d-flex ">Booking Details  </h2>	
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
                      <th class="d-none">Booking ID</th>
                      <th><b>Booking No</b></th>                      
                      <th><b>Customer</b></th>
                      <th><b>Pickup Location</b></th>                 
                      <th><b>Droppping Location</b></th>
                      <th><b>Booking Date</b></th>
                                            
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
  <!--   Core JS Files   -->
  
	
	
	
</body>

</html>