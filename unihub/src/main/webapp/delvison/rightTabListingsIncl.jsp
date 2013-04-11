        <div class="shadow">
          <div class="container-fluid">
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
                <div class="tab-content"> <!--GROUP OF TAB CONTENT-->
                  <div class="tab-pane" id="allTab">
                    <center>
                      <h2>Classifieds</h2>
                        <% for(int i = 0; i < cats.length; i++) {
                             if(i % 2 == 0) { %>
                             <%= HtmlOutputUtilities.bootStrapRow(cats[i], i+1 < cats.length ? cats[i+1]: null) %>
                        <% } } %>
                    </center>
                  </div>
                  <div class="tab-pane active" id="bicyclesTab">
                    <h2>Recently Posted</h2>
                    <%@ include file="/delvison/singleListingIncl.jsp" %>
                  </div>
                  <div class="tab-pane" id="electronicsTab">
                    <h2>Recently Posted</h2>
                    <%@ include file="/delvison/singleListingIncl.jsp" %>
                  </div>
                </div> <!--END OF TAB CONTENT GROUP-->
              </div> <!--END OF TABBABLE RIGHT-->
          </div><!--container-->
        </div><!--/row-->