package hibernate;

import org.hibernate.Session;

import metier.Utilisateur;

public class UtilisateurManager {

	public static void main(String[] args) {
		UtilisateurManager mgr = new UtilisateurManager();
		
		if(args[0].equals("insert")) {
			mgr.createAndInsertUtilisateur("Login", "Email", "Mdp", "statut");
		}
	}
	
	private void createAndInsertUtilisateur(String login, String email, String mdp, String statut) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Utilisateur u = new Utilisateur();
		u.setLogin(login);
		u.setEmail(email);
		u.setMdp(mdp);
		u.setStatut(statut);
		
		session.getTransaction().commit();
	}

}
