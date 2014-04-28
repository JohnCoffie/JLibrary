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
        <div id="login-input-area-center">
            <div id="login-area-logo">
                JLibrary
            </div>
            <div id="login-area-fields">
                <form action="user/login" name="loginForm" method="post">
                    <div class="login-input-row">
                        <span class="login-input-label">Username</span>
                        <input class="login-input-box" type="text" name="username" value="" ></div>
                    <div class="login-input-row">
                        <span class="login-input-label">Password</span>
                        <span ><input class="login-input-box" type="password" name="password" value="" ></span>
                    </div>
                    <div><input class="login-submit-button" type="submit" value="submit" ></div>
                </form>
            </div>
		</div>
	</div>
</div>

<div id="login-pg-bottom">
</div>

</body>
</html>