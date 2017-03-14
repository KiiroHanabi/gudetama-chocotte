package metier;

import java.io.Serializable;

public class Traduction implements Serializable {
	private int idTraduction;
	private int idUtilisateur;
	private String urlTraduction;
	private int votePositif;
	private int voteNegatif;
	private int totalVote;
	
	public Traduction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Traduction(int idTraduction, int idUtilisateur, String urlTraduction, int votePositif, int voteNegatif, int totalVote) {
		super();
		this.idTraduction = idTraduction;
		this.idUtilisateur = idUtilisateur;
		this.urlTraduction = urlTraduction;
		this.votePositif = votePositif;
		this.voteNegatif = voteNegatif;
		this.totalVote = totalVote;
	}
	public int getIdTraduction() {
		return idTraduction;
	}
	public void setIdTraduction(int idTraduction) {
		this.idTraduction = idTraduction;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getUrlTraduction() {
		return urlTraduction;
	}
	public void setUrlTraduction(String urlTraduction) {
		this.urlTraduction = urlTraduction;
	}
	public int getVotePositif() {
		return votePositif;
	}
	public void setVotePositif(int votePositif) {
		this.votePositif = votePositif;
	}
	public int getVoteNegatif() {
		return voteNegatif;
	}
	public void setVoteNegatif(int voteNegatif) {
		this.voteNegatif = voteNegatif;
	}
	public int getTotalVote() {
		return totalVote;
	}
	public void setTotalVote(int totalVote) {
		this.totalVote = totalVote;
	}
	
}
