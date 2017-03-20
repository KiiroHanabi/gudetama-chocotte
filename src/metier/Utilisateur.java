package metier;

import java.io.Serializable;

public class Utilisateur implements Serializable {
	private int id;
	private String login;
	private String email;
	private String mdp;
	private String statut;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(int id, String login, String email, String mdp, String statut) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.mdp = mdp;
		this.statut = statut;
	}
	
	public Utilisateur(String login, String email, String mdp) {
		super();
		this.id = Integer.parseInt("");
		this.login = login;
		this.email = email;
		this.mdp = mdp;
		this.statut = "Membre";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
}
