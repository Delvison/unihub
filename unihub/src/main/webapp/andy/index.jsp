<!--This shall be our main home screen -->
<%@ page import="com.unihub.app.HtmlOutputUtilities, com.unihub.app.Event, 
				com.unihub.app.Events,
				javax.ejb.*, java.util.ArrayList, javax.naming.InitialContext, 
				com.unihub.app.EventsBean" %>
<%! @EJB Events bean; %>
<%
	/*
	This will temporarily be here since I will get this info from
	the database when its set up*/
	String[] cats = new String[] {"Art Supplies", "Books", "Bicycles", "Jobs", 
									"Electronics", "Cars", "Cell Phones", "Furniture", 
									"Musical Instruments", "Misc."};

	//EventListHolder holder = EventListHolder.getInstance();
	InitialContext context = new InitialContext();
	bean = (Events) context.lookup("ejb:unihub-ear/unihub-ejb//EventsBean!com.unihub.app.Events");
	ArrayList<Event> list = bean.getEvents();
%>



<%@ include file="/delvison/header.jsp" %>

	<body>



		<div id="myCarousel" class="carousel slide">
			<div class="carousel-inner">

					<div class="item active">
						<img src="design/images/books.jpg">
						<div class="container">
							<div class="carousel-caption">
						        <h1 style="color:white">Welcome to UniHub!</h1>
						        <p class="lead"> UniHub is an online classified listing service specifically geared towards the college ecosystem. On UniHub, you are able to sell and buy things from fellow members of your university. The stuff you need quick and easy. So go ahead and give it a try!</p>
						        <br> 
						        <a class="btn btn-large btn-primary" href="signup">Sign up today</a> 
						    </div>				    
					   </div>
					</div>
		    </div>
        </div>

        <!-- Centers the rest of the page -->
        <div class="container-fluid">



        	<div class="row-fluid" >
        		<div class="span4">
        			<CENTER>
	        			<img class="img-circle" src="design/images/what_icon.png" 
	        			style="width: 140px; height: 140px">
	        			<h3>What is Unihub?</h3>
	        			<p style="font-weight: 200; color: #888; font-size: 14px">Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
        			</CENTER>
        		</div>
        		<div class="span4">
        			<CENTER>
	        			<img class="img-circle" src="design/images/what_icon.png" 
	        			style="width: 140px; height: 140px">
	        			<h3>Who is it for?</h3>
	        			<p style="font-weight: 200; color: #888; font-size: 14px">Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
        			</CENTER>
        		</div>
        		<div class="span4">
        			<CENTER>
	        			<img class="img-circle" src="design/images/what_icon.png" 
	        			style="width: 140px; height: 140px">
	        			<h3>Why you'll love it!</h3>
	        			<p style="font-weight: 200; color: #888; font-size: 14px">Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
        			</CENTER>
        		</div>
        	</div>

        	<hr class="featurette-divider">


        	<div class="row-fluid bottom-buffer">
        		<div class="span6" style="height: 300px; background: #000">

        		</div>
        		<div class="span6" >
	        		<h4>Some title</h4>
	        		<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
        		</div>
        	</div>

        	<div class="row-fluid bottom-buffer">
        		<div class="span6">
	        		<h4>Some title</h4>
	        		<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
        		</div>
        		<div class="span6" style="height: 300px; background: #000">

        		</div>
        	</div>
        	<hr class="featurette-divider">


        	<div class="row-fluid bottom-buffer">
        		<div class="span6" style="height: 300px; background: #000">
        		</div>
        		<div class="span5">
        			<h3>We Are Students. Just like you.</h3>
        			<p style="font-weight: 200; color: #888; font-size: 14px">Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
        		</div>
        	</div>



        </div>












	</body>

</html>