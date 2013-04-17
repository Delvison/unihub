    <%@ page import="com.unihub.app.AuthUtilities" %>
<%@ include file="/delvison/bootstrap.jsp"  %>
<%@ page language="java" import="com.unihub.app.Dbase" %>
<%@ page errorPage="/error.jsp" %>

<!doctype html>
<html>

<head>
	<title>Login</title>
</head>

<body>
    <div class="container-fluid top-buffer">
    <div class="row-fluid">
    <div class="span8 offset2">
    <div class="well">
    <ul class="nav nav-tabs">
    <li class="active"><a href="#login" data-toggle="tab">Login</a></li>
    <li><a href="#create" data-toggle="tab">Create Account</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
    <div class="tab-pane active in" id="login">
    <form class="form-horizontal" action="login" method="POST">
    <fieldset>
    <div id="legend">
    <legend class="">Login</legend>
    </div>
    <div class="control-group">
    <!-- Username -->
    <label class="control-label" for="username">Username</label>
    <div class="controls">
    <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
    </div>
    </div>
    <div class="control-group">
    <!-- Password-->
    <label class="control-label" for="password">Password</label>
    <div class="controls">
    <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
    </div>
    </div>
    <div class="control-group">
    <!-- Button -->
    <div class="controls">
    <button class="btn btn-success">Login</button>
    </div>
    </div>
    </fieldset>
    </form>
    </div>
    
    <div class="tab-pane fade" id="create">
  <form class="form-horizontal" action='createuser' method="POST">
    <fieldset>
    <div id="legend">
    <legend class="">Register</legend>
    </div>
    <div class="control-group">
    <!-- Username -->
    <label class="control-label" for="username">Username</label>
    <div class="controls">
    <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
    <p class="help-block">Username can contain any letters or numbers, without spaces</p>
    </div>
    </div>
     
    <div class="control-group">
    <!-- E-mail -->
    <label class="control-label" for="email">E-mail</label>
    <div class="controls">
    <input type="text" id="email" name="email" placeholder="" class="input-xlarge">.edu
    <p class="help-block">Please provide a .edu E-mail</p>
    </div>
    </div>

    <div class="control-group">
    <!-- School -->
    <label class="control-label" for="school">School</label>
    <div class="controls">
    <input type="text" id="school" name="school" placeholder="" class="input-xlarge">
    </div>
    </div>
     
    <div class="control-group">
    <!-- Password-->
    <label class="control-label" for="password">Password</label>
    <div class="controls">
    <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
    <p class="help-block">Password should be at least 4 characters</p>
    </div>
    </div>
     
    <div class="control-group">
    <!-- Password -->
    <label class="control-label" for="password_confirm">Password (Confirm)</label>
    <div class="controls">
    <input type="password" id="password_confirm" name="" placeholder="" class="input-xlarge">
    <p class="help-block">Please confirm password</p>
    </div>
    </div>
     
    <div class="control-group">
    <!-- Button -->
    <div class="controls">
    <button class="btn btn-success">Register</button>
    </div>
    </div>
    </fieldset>
    </form>
    </div>
    </div>
</div>
</div>
</div>
</body>
</html>