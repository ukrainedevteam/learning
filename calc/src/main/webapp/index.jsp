<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<form method="post" action="execute">
First number: <input type="text" name="firstnumber"><br>
Second number: <input type="text" name="secondnumber"><br>

<input name="sum" value="Sum" type="submit" >
<input name="multiply" value="Multiply" type="submit" >
<input name="minus"  value="Minus" type="submit" >
<input name="sqr" value="Sqr" type="submit" ><br>
<c:out value="${requestScope.result}"></c:out>
</form>

</body>
</html>
