<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" >
	<head>
		<!-- Ce site a été créé avec http://www.creer-son-website.fr/ -->
		<title>GudetamaFrance!</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ASCII" />
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="css/design/style2.css" />
		<!--[if IE 6]><link rel="stylesheet" media="screen" type="text/css" title="Design" href="design/ie6.css" /> <![endif]-->
	
			<script type="text/javascript">

function surligne(champ, erreur){
   if(erreur)
   champ.style.backgroundColor = "#fba";
  
  else
      champ.style.backgroundColor = "";
}


function verifLogin(champ){
   if(champ.value.length < 2 || champ.value.length > 25)
   {
      surligne(champ, true);
	  alert("indiquez votre login(entre 2 et 25 caractéres)");
      return false;
   }
   else
   {
      surligne(champ, false);
	        return true;
   }
}

function verifMdp(champ){
	if(champ.value.length < 2 || champ.value.length > 25)
   {
      surligne(champ, true);
	  alert("indiquez votre mot de passe (entre 2 et 25 caractéres)");
      return false;
   }
   else
   {
      surligne(champ, false);
	        return true;
   }
}

function verifMail(champ){
   var regex = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
   if(!regex.test(champ.value))
   {
      surligne(champ, true);
	  alert("indiquez une adresse mail valide");
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}
</script>
	</head>

	<body>

		<div id="conteneur_1">

			<!-- Début du menu horizontal -->
			<ul id="MH">
				<li><a href="index.jsp">Accueil</a></li>
				<li><a href="connexion.jsp">Connexion</a></li>
				<li><a href="inscription.jsp">Inscription</a></li>
				<li><a href="interface.jsp">Admin</a></li>
			</ul>
			<!-- Fin du menu horizontal -->

			<div id="banniere"><div id="logo"></div></div>

<!--			<div id="conteneur_2">
-->
				<div id="corps">

					<!-- Début du menu vertical -->
					<div id="MV">
						<div class="en_tete_MV">Inscription</div>
						<form method="post" action="controleurinscription.php">
						<input type="hidden" value="${model.mode}" name="mode">
							<p>Login</p><input type="text" name="login" value="${model.utilisateur.login}" onblur="verifLogin(this)"/>
							<p>Email</p><input type="text" name="email" value="${model.utilisateur.email}" onblur="verifMail(this)"/></p>
							<p>Mot de passe</p><input type="password" name="mdp" value="${model.utilisateur.mdp}" onblur="verifMdp(this);"/></p>
							
							</br>
							</br>
							<p><input type="submit" name="action" value="valider"></p>
							</form>
							<button><a href="connexion.jsp">Se connecter</a></button>
						<div class="bottom_MV"></div>
						<div class="marge_MV"></div>
					</div>
					<div>
					${model.errors}
					</div>

					<div id="texte"><div id="overflow">

					</br>
					</br>
					</br>
					</br>
					</br>
					</br>
					</br>
					</div></div>

					<div id="clear_both"></div>

				</div>

			</div>


					
		<div id="pied_de_page">
			<!--<a >Hey coucou!</a>-->
		</div>

	</body>
</html>
