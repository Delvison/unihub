<%@include file="header.jsp" %>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.unihub.app.ListingsObj, com.unihub.app.Stuff,
javax.ejb.EJB, com.unihub.app.ListingObjEJB, javax.naming.*" %>
<%! @EJB
    ListingObjEJB lis; %> 
<%
  Context context = new InitialContext();
  lis = (ListingObjEJB) context.lookup("ejb:unihub-ear/unihub-ejb//ListingObjEJB!com.unihub.app.ListingObjEJB?stateful");
  String id = (String)request.getParameter("id");
  String msg = "";
  msg = (String)request.getParameter("msg");
  int picAmount = lis.getPicAmount(Integer.parseInt(id));
%>

<body>
<div class='row-fluid'>
  <!--FORM PANE-->
  <div class='hero-unit span10 offset1' style="background-color:White" align="center">
  <center>
    <h1>Manage Photos</h1>
   <%if (msg != null){%><center>
     <%if (msg.equals("limit")){%>
        <div class="alert alert-error span9 offset1">
          <button type="button" class="close" data-dismiss="alert">&times;</button>
            Sorry, but you already have 4 photos.
        </div>
     <%}%>
     <%if (msg.equals("error")){%>
       <div class="alert alert-error span9 offset1">
         <button type="button" class="close" data-dismiss="alert">&times;</button>
           An error has occurred with your photo.
       </div>
     <%}%>
     <%if (msg.equals("removed")){%>
       <div class="alert alert-success span9 offset1">
         <button type="button" class="close" data-dismiss="alert">&times;</button>
           Your photo was successfully removed
       </div>
     <%}%>
     <%if (msg.equals("success")){%>
       <div class="alert alert-success span9 offset1">
         <button type="button" class="close" data-dismiss="alert">&times;</button>
           Your photo was uploaded successfully!
       </div>
     <%}%></center>  
      <br>
      <br>
   <%}%>
    <form action="upload" enctype="multipart/form-data" method="post">
      <input type="file" id="file" name="file" style="border: solid 1px blue" class="span4" >
      <input type="hidden" name="id" value="<%=id%>">
      <input class="btn btn-primary" type="submit" id="upload" value="Upload Now" />
      <p style="font-size:xx-small">
                <i>valid files are jpg and png</i></p>
    </form>
         <a href="item?id=<%=id%>">
        <button class="btn btn-success">Done with photos</button>
      </a>
   </center>
   <%if (picAmount > 0){ %>
     <center><h2>Current Photos</h2></center>
     <div class="row-fluid">
       <ul class="thumbnails">
         <devjsp:pic itemId="<%=id%>">
           <li class="span3">
               <a href="${imagePath}" rel="lightbox" class="thumbnail">
                <img src="${imagePath}"  rel="lightbox" style="height:130px">
               </a>
               <a class="btn btn-danger btn-mini" href="removePhoto?dir=${imageDir}">
              <i class="icon-trash icon-white"></i>Remove</a>
           </li>
      </devjsp:pic >
    </div>
    </div>
      <%}%>
  </div>

</div>
</body>
