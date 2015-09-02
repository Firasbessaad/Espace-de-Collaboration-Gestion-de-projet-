package Entite;

public class Proposition {
	private String id;
	private String nom;
	private String enseignant;
	private String corps;
	private int groupe_number;
	private String etat;
	private String photoenseignant;
	
	
	public String getPhotoenseignant() {
		return photoenseignant;
	}
	public void setPhotoenseignant(String photoenseignant) {
		this.photoenseignant = photoenseignant;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
	public int getGroupe_number() {
		return groupe_number;
	}
	public void setGroupe_number(int groupe_number) {
		this.groupe_number = groupe_number;
	}
	


}
