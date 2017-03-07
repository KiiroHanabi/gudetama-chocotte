package metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) {
		IModifUtilisateur metier = new ModifUtilisateurImpl();
		//metier.addUtilisateur(new Utilisateur(7,"Zoe","zoe.maillet@gmail.com","zoemaillet",""));
		/*List<Utilisateur> util = metier.listUtilisateur();
		for(Utilisateur u:util){
			System.out.println(u.getId());
		}
		System.out.println("--------------------------");
		List<Utilisateur> util2 = metier.listUtilisateur();
		for(Utilisateur u:util2){
			System.out.println(u.getLogin());
		}
		System.out.println("--------------------------");
		List<Utilisateur> util3 = metier.listUtilisateur();
		for(Utilisateur u:util3){
			System.out.println(u.getEmail());
		}
		System.out.println("--------------------------");
		List<Utilisateur> util4 = metier.listUtilisateur();
		for(Utilisateur u:util4){
			System.out.println(u.getMdp());
		}
		System.out.println("--------------------------");
		List<Utilisateur> util5 = metier.listUtilisateur();
		for(Utilisateur u:util5){
			System.out.println(u.getStatut());
		}*/
		/*List<Utilisateur> util = metier.listUtilisateurMC("pau");
		for(Utilisateur u:util){
			System.out.println(u.getLogin());
		}*/
		/*try {
			Utilisateur u = metier.getUtilisateur(4);
			System.out.println(u.getLogin());
			u.setLogin("Martin");
			metier.modifUtilisateur(u);
			Utilisateur u2 = metier.getUtilisateur(4);
			System.out.println(u2.getLogin());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}*/
		//metier.suppUtilisateur(7);
	}

}
