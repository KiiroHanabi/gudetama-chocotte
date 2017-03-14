package web;

import java.util.ArrayList;
import java.util.List;

import metier.Utilisateur;

public class UtilisateurModel {
	private String motCle;
	private Utilisateur utilisateur = new Utilisateur();
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	private String errors;
	private String mode = "ajout";
	
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	

}
