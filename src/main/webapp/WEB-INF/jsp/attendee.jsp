<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendee Page</title>
<style type="text/css">
	.error{
		color: #ff0000;
	}
	.errorblock{
		color: #000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8x;
		margin: 16px;
	}
</style>
</head>
<body>
	<form:form commandName="attendee"> <!-- form is tied to the event object what we added to the Model in the Controller -->
		<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
		<label for="textinput1">Enter Name:</label>
		<form:input path="name" cssErrorClass="error"/>
		<form:errors path="name" cssErrorClass="error"></form:errors>
		<br>
		<label for="textinput2">Enter E-mail Address:</label>
		<form:input path="emailAddress" cssErrorClass="error"/>
		<form:errors path="emailAddress" cssErrorClass="error"></form:errors>
		<br>
		<input type="submit" class="btn" value="Enter Attendee"/>
	</form:form>
</body>
</html>