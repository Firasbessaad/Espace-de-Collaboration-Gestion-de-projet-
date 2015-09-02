package Entite;

import java.util.List;

import Entite.Fichier;

public class Projet {
	private String id;
	private String nom;
	private String enseignant;
	private String idenseignant;
	private String ID_GROUPE;
	private String ID_PROPOSITION;
	private String photo_enseignant;
	private List<Fichier> fichiers;
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
	
	public String getID_GROUPE() {
		return ID_GROUPE;
	}
	public void setID_GROUPE(String iD_GROUPE) {
		ID_GROUPE = iD_GROUPE;
	}
	public String getID_PROPOSITION() {
		return ID_PROPOSITION;
	}
	public void setID_PROPOSITION(String iD_PROPOSITION) {
		ID_PROPOSITION = iD_PROPOSITION;
	}
	
	public String getPhoto_enseignant() {
		return photo_enseignant;
	}
	public void setPhoto_enseignant(String photo_enseignant) {
		this.photo_enseignant = photo_enseignant;
	}
	public String getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}
	public String getIdenseignant() {
		return idenseignant;
	}
	public void setIdenseignant(String idenseignant) {
		this.idenseignant = idenseignant;
	}
	public List<Fichier> getFichiers() {
		return fichiers;
	}
	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}
	
	
	

}
