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
		<form action = "controleur.php" method ="post">
			<table>
				<tr>
					<td> Mot Clé :</td>
					<td><input type="text" name="motCle" value=${model.motCle}/></td>
					<td><input type="submit" value="chercher" name="action"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<table class="table1">
			<tr>
				<th>ID</th><th>Login</th><th>Email</th><th>MDP</th><th>Statut</th>
			</tr>
			<!-- (environ 1:07:00) Attention ! Ici on utilise jstl. Mais il faut importer les librairies jstl.jar et 
			standard.jar dans le dossier lib. Elles se trouvent dans le dossier de tomcat ->webapps->example->web-ing->lib -->
			<c:forEach items="${model.utilisateurs}" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.login}</td>
					<td>${u.email}</td>
					<td>${u.mdp}</td>
					<td>${u.statut}</td>
					<td><a href="controleur.php?action=delete&ref=${u.id}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div> 
</body>
</html>