package web;

import java.util.ArrayList;
import java.util.List;

import metier.Traduction;

public class TraductionModel {
	private String motCle;
	private Traduction traduction = new Traduction();
	private List<Traduction> traductions = new ArrayList<Traduction>();
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
	public List<Traduction> getTraductions() {
		return traductions;
	}
	public void setTraductions(List<Traduction> traductions) {
		this.traductions = traductions;
	}
	public Traduction getTraduction() {
		return traduction;
	}
	public void setTraduction(Traduction traduction) {
		this.traduction = traduction;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	

}
