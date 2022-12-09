<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>

<head>

<title>Student Confirmation !</title>

</head>

<body>

	<h2>Student Confirmation Succes</h2>

	Student Name : ${student.firstName }

	<br> Student LastName : ${student.lastName}
	<br> Country : ${student.country}
	<br> Favorite Language : ${student.favoriteLang}
	<br> Operating Systems :
	<c:forEach var="temp" items="${student.operationSystems }">
	<ul>
		<li>${temp}</li>
	</ul>
	</c:forEach>

</body>

</html>