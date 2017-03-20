<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" >
	<head>
		<!-- Ce site a �t� cr�� avec http://www.creer-son-website.fr/ -->
		<title>GudetamaFrance!</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="css/design3/style.css" />
		<!--[if IE 6]><link rel="stylesheet" media="screen" type="text/css" title="Design" href="design/ie6.css" /> <![endif]-->
	<script type="text/javascript">
����	function checkbox(){
	��������if(document.getElementById('precis').checked){
	������������document.getElementById('plage').disabled = 'disabled';
				document.getElementById('boxplagedeb').disabled = 'disabled';
				document.getElementById('boxplagefin').disabled = 'disabled';
	��������}
			else {
				document.getElementById('plage').disabled = '';
				document.getElementById('boxplagedeb').disabled = '';
				document.getElementById('boxplagefin').disabled = '';
			}
	��������if(document.getElementById('plage').checked){
	������������document.getElementById('precis').disabled = 'disabled';
				document.getElementById('boxprecis').disabled = 'disabled';
	��������}
			else {
				document.getElementById('precis').disabled = '';
				document.getElementById('boxprecis').disabled = '';
			}
			if(document.getElementById('oui').checked){
	������������document.getElementById('non').disabled = 'disabled';
	��������}
			else {
				document.getElementById('non').disabled = '';
			}
	��������if(document.getElementById('non').checked){
	������������document.getElementById('oui').disabled = 'disabled';
	��������}
			else {
				document.getElementById('oui').disabled = '';
			}				
����	}
</script>
	</head>

	<body>

		<div id="conteneur_1">

			<!-- D�but du menu horizontal -->
			<ul id="MH">
				<li><a href="index.jsp">Accueil</a></li>
				<li><a href="connexion.jsp">Connexion</a></li>
				<li><a href="inscription.jsp">Inscription</a></li>
				<li><a href="interface.jsp">Admin</a></li>
			</ul>
			<!-- Fin du menu horizontal -->

			<div id="banniere"><div id="logo"></div>
			<div id="search">
			<form id="searchthis"><!--action = "controleur.php" method ="post">-->
			<table>
				<tr>
					<td></td>
					<td><input type="text" name="motCle" id="searchbar"/><!--value=${model.motCle}/>--></td>
					<td><input type="submit" value="Rechercher" name="action" id="searchbutt"/></td>
				</tr>
				<tr>
					<td></td>
					<td>Dur�e vid�o</td>
					<td>Sous-titre</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" placeholder="		--:--" name="duree"></td>
					<td><input id="oui" type="checkbox" OnClick="checkbox();" name="field" value="oui">
						<label for="oui">Oui</label>
						<input id="non" type="checkbox" OnClick="checkbox();" name="field" value="non">
						<label for="non">Non</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input id="precis" type="checkbox" OnClick="checkbox();" name="field" value="option1">
						<label for="precis">Date pr�cise</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input id="boxprecis" type="date" name="debut"></td>
				</tr>
				<tr>
					<td></td>
					<td><input id="plage" type="checkbox" OnClick="checkbox();" name="field" value="option2">
						<label for="plage">Plage de dates</label></td>
					<td>
						<tr>
							<td></td>
							<td>Date d�but</td>
							<td>Date fin</td>
						</tr>
						<tr>
							<td></td>
							<td><input id="boxplagedeb" type="date" name="debut"></td>
							<td><input id="boxplagefin" type="date" name="fin"></td>
						</tr>
					</td>
				</tr>
			</table>
			</form>
			</div>
			</div>

			<div id="conteneur_2">

				<div id="corps">

					<!-- D�but du menu vertical -->
					<div id="MV">
						<div class="en_tete_MV">S�ries</div>
							<a class="lien_MV" href="menu1.jsp">F�vrier 2017</a>
							<a class="lien_MV" href="menu2.jsp">Mars 2017</a>
							<a class="lien_MV">Avril 2017(indisponible)</a>
							<a class="lien_MV">Mai 2017 (indisponible)</a>
						<div class="bottom_MV"></div>
						<div class="marge_MV"></div>
						<div class="en_tete_MV">Autres</div>
							<a class="lien_MV">Nouveaut�s</a>
							<a class="lien_MV">Toutes les Vid�os</a>
							<a class="lien_MV" href="https://www.sanrio.com/categories/gudetama">Page Sanrio</a>
							<a class="lien_MV" href="quisommesnous.jsp">Qui sommes-nous</a>
						<div class="bottom_MV"></div>
						<div class="marge_MV"></div>
					</div>
					<!-- Fin du menu vertical -->

					<div id="texte"><div id="overflow">

						<!-- D�but de la zone de texte -->
						<p>
						Bienvenue � toi ! Merci de t'�tre inscrit sur notre site GudetamaFrance!
						Tu peux maintenant contribuer aux traductions sur les vid�os de Gudetama et favoriser tes vid�os pr�f�r�es !
						</p>
						<p>
						Amuse-toi bien, ok bisou, la r�daction.
						</p><br />
						<!-- Fin de la zone de texte -->

					</div></div>

					<div id="clear_both"></div>

				</div>

			</div>

		</div>

		<div id="pied_de_page">
			<a>Hey coucou !</a>
		</div>

	</body>
</html>
