<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div>
		<form action = "controleurvideo.php" method ="post">
			<table>
				<tr>
					<td> MotClé :</td>
					<td><input type="text" name="motCle" value=${videomodel.motCle}/></td>
					<td><input type="submit" value="chercher" name="action"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<table class="table1">
			<tr>
				<th>ID</th><th>Video</th><th>Date</th><th>URL</th><th>Duree</th><th>ID traduction</th><th>Etat Traduction</th>
			</tr>
			<c:forEach items="${videomodel.videos}" var="v">
				<tr>
					<td>${v.idVideo}</td>
					<td>${v.titreVideo}</td>
					<td>${v.dateVideo}</td>
					<td>${v.urlVideo}</td>
					<td>${v.dureeVideo}</td>
					<td>${v.idTraduction}</td>
					<td>${v.estTraduit}</td>
					<td><a href="controleurvideo.php?action=delete&ref=${v.idVideo}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div> 
</body>
</html>