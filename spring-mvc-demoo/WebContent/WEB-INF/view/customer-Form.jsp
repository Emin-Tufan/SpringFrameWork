<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>

<title>Customer Form</title>

<style>
.error {color:red}
</style>

</head>

<body>

	<form:form action="processForm" modelAttribute="customer">
	First Name : <form:input path="firstName" />
		<br>
		<br>
		
Last Name : <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"/>

		<br><br>
		
		Free Passes : <form:input path="freePass"/>
		<form:errors path="freePass" cssClass="error"></form:errors>
		
		<br><br>
		
		Posta Code : <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		
		<br><br>
		
		Course Code : <form:input path="CourseCode"/>
		<form:errors path="courseCode" cssClass="error"></form:errors>
		
		<br><br>

		<input type="submit" value="Submit">

	</form:form>

</body>



</html>