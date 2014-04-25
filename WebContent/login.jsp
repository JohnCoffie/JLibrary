<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<style type="text/css" media="all">@import "css/style.css";</style> 
</head>

<body>

<div id="login-pg-top">
    <div id="login-input-area">
        <div id="input-area-center">
            <div id="area-logo">JLibrary
            </div>
            <div id="area-fields">
				<form action="user/login" name="loginForm" method="post">
					<div>username <input type="text" name="username" value="" ></div>
					<div>password <input type="password" name="password" value=""  ></div>
					<div><input type="submit" value="submit" ></div>
				</form>
			</div>
		</div>
	</div>
</div>

<div id="login-pg-bottom">
</div>

</body>
</html>