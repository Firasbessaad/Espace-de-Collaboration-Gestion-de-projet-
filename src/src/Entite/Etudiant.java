package Entite;

public class Etudiant {
	private String id;
	private String nom;
	private String prenom;
	private String id_group;
	private String encadreur;
	private String id_projet;
	private String photo;
	private String mail;
	private Boolean connecté = false;
	private String couleur ;
	
	//getters and setters
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getId_group() {
		return id_group;
	}
	public void setId_group(String id_group) {
		this.id_group = id_group;
	}
	public String getEncadreur() {
		return encadreur;
	}
	public void setEncadreur(String encadreur) {
		this.encadreur = encadreur;
	}
	public String getId_projet() {
		return id_projet;
	}
	public void setId_projet(String id_projet) {
		this.id_projet = id_projet;
	}
	public Boolean getConnecté() {
		return connecté;
	}
	public void setConnecté(Boolean connecté) {
		this.connecté = connecté;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
