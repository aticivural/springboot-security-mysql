




<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sample Page</title>
</head>
<body>
<h1>This is sample jsp page
</h1>
<form action="/login" method="get">
    <input type="submit" value="Sign in as different user" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
