 <!--COMMENTS PANE-->
        <div class='span4 sidebar' style="background-color:White">
            <center><h2>Comments</h2></center>
              <!--section that displays comments posted-->
              <div name="displayComments">
                  <i class="icon-user"></i><a href="#">sketchyBuyer1:</a> 
                     <i> sell for $2?</i><hr>
                  <devjsp:forEachComment itemId="<%=id%>" >
                     <p>
                      <i class="icon-user"></i><a href="#">${commentsUser}:</a> 
                      <i>${theComment}</i>
                     </p>
                     <hr>
                  </devjsp:forEachComment>
              </div>
            
              <!--section where a comment can be posted -->
              <div name="postComments">
                <FORM ACTION="addcomment" METHOD="get">
                  <center>
                    <textarea name="comment" style="width:260px;height:70px" 
                               placeholder="Post Comment"></textarea>
                    <input type="hidden" name="user" value="<%=user%>">
                    <input type="hidden" name="itemId" value="<%=id%>">
                    <devjsp:cmntUser user="<%=user%>" />
                    <a href="#processComment" role="button" class="btn btn-primary" 
                      data-toggle="modal">Comment</a>
                  </center>
                  <!-- popup that confirms comment -->
                  <div id="processComment" class="modal hide fade" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-header">
                      <h3 id="myModalLabel">Post Comment</h3>
                    </div>
                    <div class="modal-body">
                      <%if (user != null) {%>
                        <p>Are you sure you want to post this comment?</p>
                      <%}else{%>
                        <p>Sorry, but you are not logged in :(</p>
                      <%}%>
                    </div>
                    <div class="modal-footer">
                      <button class="btn" data-dismiss="modal" aria-hidden="true">
                        Cancel</button>
                      <%if (user != null) {%>
                        <input type="submit" class="btn btn-primary" value="Comment">
                      <%}else{%>
                        <a class="btn btn-primary" href="login">Login</a>
                      <%}%>
                      </FORM><br>
                    </div>
              </div>      
        </div> <!--COMMENT PANE DIV-->