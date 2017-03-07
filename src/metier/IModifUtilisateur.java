package metier;

import java.util.List;

public interface IModifUtilisateur {
	public void modifUtilisateur(Utilisateur u);
	public void addUtilisateur(Utilisateur u);
	public void suppUtilisateur(int id);
	public List<Utilisateur> listUtilisateur();
	public List<Utilisateur> listUtilisateurMC(String mc);
	public Utilisateur getUtilisateur(int id);

}
