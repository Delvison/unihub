<%@ page language="java" import="java.util.*,
                                 javax.ejb.EJB,
                                 javax.naming.*,
                                 com.unihub.app.UserStatefulBI,
                                 com.unihub.app.User,
                                 com.unihub.app.Dbase,
                                 com.unihub.app.ListingsObj,
                                 com.unihub.app.Stuff,
                                 com.unihub.app.Message,
                                java.security.*,
                                javax.servlet.*,
                                javax.servlet.http.*"
    isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/markjsp-taglib.tld" prefix="markjsp"%>

<!DOCTYPE html>

<%@ include file="../delvison/header.jsp"%>
<%! @EJB UserStatefulBI usr; %>
<% 
    String usernm = (String)session.getAttribute("username");
    Context context = new InitialContext();
    usr = (UserStatefulBI) context.lookup("ejb:unihub-ear/unihub-ejb//UserStatefulBean!com.unihub.app.UserStatefulBI");
%>   

<body style="background-color:#CCC">

<!-- A Collapsable Menu BootSnipp -->
<script>
    $(document).ready(function () {
        $('label.tree-toggler').click(function () {
            $(this).parent().children('ul.tree').toggle(300);
        });
    });
</script>

<div class="row-fluid span12">
<div class="well span4 offset2" style="padding: 8px 0;">
  <center><h4>Sent Messages</h4>
    <div style="overflow-y: hidden; overflow-x: hidden; height: 500px;">
        <ul class="nav nav-list">
            <markjsp:listmsgs user="<%=usernm%>" type="sent">
            <li><label class="tree-toggler nav-header" data-toggle="collapse">To: ${toName}</label>
                <ul class="nav nav-list tree">
                    <li>${msgContents}</li>
                </ul>
            </li>
            <li class="divider"></li>
            </markjsp:listmsgs>
        </ul>
    </div>
</div>

<div class="well span4" style="padding: 8px 0;">
  <center><h4>Received Messages</h4>
    <div style="overflow-y: hidden; overflow-x: hidden; height: 500px;">
        <ul class="nav nav-list">
            <markjsp:listmsgs user="<%=usernm%>" type="received">
            <li><label class="tree-toggler nav-header" data-toggle="collapse">From: ${fromName}</label>
                <ul class="nav nav-list tree">
                    <li>${msgContents}</li>
                </ul>
            </li>
            <li class="divider"></li>
            </markjsp:listmsgs>
        </ul>
    </div>
</div>
</div>

</body>
</html>
