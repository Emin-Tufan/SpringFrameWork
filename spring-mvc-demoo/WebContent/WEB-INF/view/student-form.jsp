<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
	
		Last name: <form:input path="lastName" />
		
		<br><br>
	
		Country:
		
		<form:select path="country">
		
			<form:options items="${student.countryOptions}" />
						
		</form:select>
		
		<br><br>
	
	Favorite Language : 		
			Java <form:radiobutton value="Java" path="favoriteLang"/>
			C# <form:radiobutton value="C#" path="favoriteLang"/>
			Ruby <form:radiobutton value="Ruby" path="favoriteLang"/>
			Php <form:radiobutton value="Php" path="favoriteLang"/>
			Swift <form:radiobutton value="Swift" path="favoriteLang"/>
			JavaScript <form:radiobutton value="JavaScript" path="favoriteLang"/>
				
		<br><br>
		
		Operation Systems:<br>
		Linux <form:checkbox value="Linux" path="operationSystems"/>
		Mac Os<form:checkbox value="MacOs" path="operationSystems"/>
		Windows<form:checkbox value="Windows" path="operationSystems"/>
		
		<br><br>
	
		<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>












