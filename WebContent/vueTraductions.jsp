<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestion des Traductions</title>
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
		<form action = "controleurtraduction.php" method ="post">
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
		<form action = "controleurtraduction.php" method ="post">
		<input type="hidden" value="${model.mode}" name="mode">
			<table>
			<c:if test="${model.mode=='ajout'}">
				<tr>
					<td>ID :</td>
					<td><input type="number" name="id" value="${model.traduction.idTraduction}"/></td>
					<td></td>
				</tr>
			</c:if>
			<c:if test="${model.mode=='edit'}">
				<tr>
					<td>ID :</td>
					<!-- <td>${model.utilisateur.id}<input type="hidden" name="id" value="${model.utilisateur.id}"/></td>-->
					<td><input type="number" name="id" value="${model.traduction.idTraduction}"/></td>
					<td></td>
				</tr>
			</c:if>
				<tr>
					<td>Id Utilisateur :</td>
					<td><input type="number" name="idUtilisateur" value="${model.traduction.idUtilisateur}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>URL :</td>
					<td><input type="text" name="urlTraduction" value="${model.traduction.urlTraduction}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>Nb votes positifs :</td>
					<td><input type="number" name="votePositif" value="${model.traduction.votePositif}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>Nb votes negatifs :</td>
					<td><input type="number" name="voteNegatif" value="${model.traduction.voteNegatif}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>Nb total de votes :</td>
					<td><input type="number" name="totalVote" value="${model.traduction.totalVote}"/></td>
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
				<th>ID</th><th>Id Utilisateur</th><th>URL</th><th>Nb votes positifs</th><th>Nb votes negatifs</th><th>Nb total de votes</th>
			</tr>
			<c:forEach items="${model.traductions}" var="t">
				<tr>
					<td>${t.idTraduction}</td>
					<td>${t.idUtilisateur}</td>
					<td>${t.urlTraduction}</td>
					<td>${t.votePositif}</td>
					<td>${t.voteNegatif}</td>
					<td>${t.totalVote}</td>
					<td><a href="javascript:confirmer('controleurtraduction.php?action=delete&ref=${t.idTraduction}')">Supprimer</a></td>
					<td><a href="controleurtraduction.php?action=edit&ref=${t.idTraduction}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div> 
</body>
</html>