<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des Videos</title>
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
		<form action = "controleurvideo.php" method ="post">
			<table>
				<tr>
					<td> MotClé :</td>
					<td><input type="text" name="motCle" value=${model.motCle}/></td>
					<td><input type="submit" value="Rechercher" name="action"/></td>
				</tr>
			</table>
		</form>
	</div>
		<div>
		<form action = "controleurvideo.php" method ="post">
		<input type="hidden" value="${model.mode}" name="mode"/>
			<table>
			<c:if test="${model.mode=='ajout'}">
				<tr>
					<td>ID :</td>
					<td><input type="number" name="id" value="${model.video.idVideo}"/></td>
					<td></td>
				</tr>
			</c:if>
			<c:if test="${model.mode=='edit'}">
				<tr>
					<td>ID :</td>
					<!-- <td>${model.utilisateur.id}<input type="hidden" name="id" value="${model.utilisateur.id}"/></td>-->
					<td><input type="number" name="id" value="${model.video.idVideo}"/></td>
					<td></td>
				</tr>
			</c:if>
				<tr>
					<td>Video :</td>
					<td><input type="text" name="titreVideo" value="${model.video.titreVideo}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>Date :</td>
					<td><input type="date" name="dateVideo" value="${model.video.dateVideo}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>URL :</td>
					<td><input type="text" name="urlVideo" value="${model.video.urlVideo}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>Duree :</td>
					<td><input type="time" name="dureeVideo" value="${model.video.dureeVideo}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>ID traduction :</td>
					<td><input type="number" name="idTraduction" value="${model.video.idTraduction}"/></td>
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
				<th>ID</th><th>Video</th><th>Date</th><th>URL</th><th>Duree</th><th>ID traduction</th>
			</tr>
			<c:forEach items="${model.videos}" var="v">
				<tr>
					<td>${v.idVideo}</td>
					<td>${v.titreVideo}</td>
					<td>${v.dateVideo}</td>
					<td>${v.urlVideo}</td>
					<td>${v.dureeVideo}</td>
					<td>${v.idTraduction}</td>
					<td><a href="controleurvideo.php?action=delete&ref=${v.idVideo}">Supprimer</a></td>
					<td><a href="controleurvideo.php?action=edit&ref=${v.idVideo}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div> 
</body>
</html>