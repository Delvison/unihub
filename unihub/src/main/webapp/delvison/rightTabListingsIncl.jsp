        <div class="shadow" style="height:450px">
          <div class="container-fluid">
              <h3>Recently Posted</h3>
              <div class="tabbable tabs-right span12">
                <ul class="nav nav-tabs">
                  <li><a href="#allTab" data-toggle="tab">All</a></li>
                  <li><a href="#artTab" data-toggle="tab">Art Supplies</a></li>
                  <li><a href="#booksTab" data-toggle="tab">Books</a></li>
                  <li class="active"><a href="#bicyclesTab" data-toggle="tab">Bicycles</a></li>
                  <li><a href="#electronicsTab" data-toggle="tab">Electronics</a></li>
                  <li><a href="#phoneTab" data-toggle="tab">Cell Phones</a></li>
                  <li><a href="#furnitureTab" data-toggle="tab">Furniture</a></li>
                  <li><a href="#musicTab" data-toggle="tab">Musical Instruments</a></li>
                  <li><a href="#miscTab" data-toggle="tab">Misc.</a></li>
                </ul>
<!--########--> <div class="tab-content"> <!--GROUP OF TAB CONTENT-->

                  <!---
                  <div class="tab-pane" id="allTab">
                    <devjsp:forEachListing limit="3">
                    <div class="item"><
                      <div class="container-fluid">
                        <div class="row -fluid">
                          <div class="span4 offset1"><br><br><br>
                            <a href="#" class="thumbnail">
                              <img src="listings/1/1.jpg" alt="">
                            </a>
                          </div>
                          <div class="span6">
                            <div>
                              <br><br>
                              <h4><strong><a href="#">${listingName} - $${listingPrice} (${listingUniversity},
                                 ${listingLocation})</a></strong>
                              </h4>
                            </div>
                            <br><br><br>
                            <p>
                              ${listingDescription}
                            </p>
                            <p><a class="btn" href="item?id=${listingId}">View Listing</a></p>
                          </div>
                        </div>
                        <div class="row-fluid">
                          <div class="span9 offset1">
                            <p></p>
                            <p>
                               <i class="icon-user"></i> by <a href="profile">${listingUser}</a>
                              | <a href="viewalllistings">${listingCategory}</a>
                              | <i class="icon-calendar"></i> ${listingDate}
                              | <i class="icon-comment"></i> <a href="#">3 Comments</a>
                              | <i class="icon-share"></i> <a href="#">39 Likes</a>
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                    </devjsp:forEachListing >
                  </div>
                -->

                  <!--Bikes tab-->
                  <div class="tab-pane active" id="bicyclesTab">
                    <div id="mylistingsCarousel" class="carousel slide">
                      <div class="carousel-inner">
                        <div class="item active">
                          <%@ include file="/delvison/singleListingIncl.jsp" %>
                        </div>
                        <div class="item">
                          <%@ include file="/delvison/singleListingInclude.jsp" %>
                        </div>
                      </div>
                      <a class="carousel-control left" href="#mylistingsCarousel" data-slide="prev"></a>
                      <a class="carousel-control right" href="#mylistingsCarousel" data-slide="next"></a>
                    </div>
                  </div>

                  <!--Electronics Tab-->
                  <div class="tab-pane" id="electronicsTab">
                    <h2>Recently Posted</h2>
                    <%@ include file="/delvison/singleListingIncl.jsp" %>
                  </div>


<!--########--> </div> <!--END OF TAB CONTENT GROUP-->
              </div> <!--END OF TABBABLE RIGHT-->
          </div><!--container-->
        </div><!--/row-->