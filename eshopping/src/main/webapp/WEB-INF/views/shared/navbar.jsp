<!-- Using Spring Scurity Taglibraries  -->
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Shopping Cart</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
       <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item home">
              <a class="nav-link" href="${contextRoot}/home">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item products">
              <a class="nav-link" href="${contextRoot}/show/all/products">Products</a>
            </li>
            
            <!-- Only show to the ADMIN -->
            <security:authorize access="hasAuthority('ADMIN')">
				<li class="nav-item manageProducts"><a class="nav-link"
					href="${contextRoot}/manage/products">Manage Products</a>
				</li>
			</security:authorize>
			
            <li class="nav-item aboutUs">
              <a class="nav-link" href="${contextRoot}/aboutUs">About Us</a>
            </li>
            <li class="nav-item contactUs">
              <a class="nav-link" href="${contextRoot}/contactUs">Contact Us</a>
            </li>
          </ul>
          
          <ul class="navbar-nav navbar-right">
          	
          	<!-- to show ALL User -->
          	<security:authorize access="isAnonymous()">
            	<li class="nav-item register">
             	 	<a class="nav-link" href="${contextRoot}/register"> 
             	 		<button class="btn btn primary">Sign Up</button>
             	 	</a>
            	</li>
            	<li class="nav-item mt-2 login">
              		<a class="nav-link" href="${contextRoot}/login">Login</a>
            	</li>
           </security:authorize>
           
           <!-- Only show to the User ( who is registered ) -->
		   <security:authorize access="isAuthenticated()">
			<li id="cartDetails" class="nav-item mt-2 dropdown">
				<a	class="nav-link dropdown-toggle" href="javascript:void(0)"
					id="dropdownMenu1" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> 
					<i class="fa fa-user"></i> ${userModel.fullName} <span class="caret"></span>
				</a>
				<div class="dropdown-menu" aria-labelledby="dropdownMenu1">
					
					<!-- Only show to the User ( whose role is "USER" )-->
					<security:authorize access="hasAuthority('USER')">
						<a class="dropdown-item" href="${contextRoot}/cart/show"> <span
							class="fa fa-shopping-cart"></span> <span class="badge">
								${userModel.cart.cartLines}</span> - &#8377;
								${userModel.cart.grandTotal}
						</a>
						<div class="dropdown-divider"></div>
					</security:authorize>
					
					<a class="dropdown-item" href="${contextRoot}/perform-logout">logout</a>
				</div>
			</li>
		  </security:authorize> 
		</ul>
      </div><!-- Collapse -->
   </div><!-- Container -->
   
   <!-- Using this userRole in "eshopping.js" to show different icon for "ADMIN" & "USER" -->
   <script type="text/javascript">
   		window.userRole = '${userModel.role}';
   </script>
</nav>