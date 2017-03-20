<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestion des utilisateurs</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript">
	function confirmer(url) {
		var rep=confirm("Etes vous sûr(e) de vouloir supprimer ?");
		if(rep==true) {
			document.location=url;
		}
	}
	</script>
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
		<form action = "controleur.php" method ="post">
		<input type="hidden" value="${model.mode}" name="mode">
			<table>
			<c:if test="${model.mode=='ajout'}">
				<tr>
					<td>ID :</td>
					<td><input type="number" name="id" value="${model.utilisateur.id}"/></td>
					<td></td>
				</tr>
			</c:if>
			<c:if test="${model.mode=='edit'}">
				<tr>
					<td>ID :</td>
					<!-- <td>${model.utilisateur.id}<input type="hidden" name="id" value="${model.utilisateur.id}"/></td>-->
					<td><input type="number" name="id" value="${model.utilisateur.id}"/></td>
					<td></td>
				</tr>
			</c:if>
				<tr>
					<td>Login :</td>
					<td><input type="text" name="login" value="${model.utilisateur.login}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email" value="${model.utilisateur.email}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>Mdp :</td>
					<td><input type="text" name="mdp" value="${model.utilisateur.mdp}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>Statut :</td>
					<td><input type="text" name="statut" value="${model.utilisateur.statut}"/></td>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" name="action" value="save"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		${model.errors}
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
					<td><a href="javascript:confirmer('controleur.php?action=delete&ref=${u.id}')">Supprimer</a></td>
					<td><a href="controleur.php?action=edit&ref=${u.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div> 
</body>
</html>