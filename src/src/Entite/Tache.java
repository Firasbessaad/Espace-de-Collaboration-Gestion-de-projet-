package Entite;

import java.util.List;

public class Tache {
	private String id;
	private String titre;
	private List<Soustache> soustaches;
	private Datetache debut;
	private Datetache fin;
	private String TACHE_SUIVANTE;
	private String ID_PROJETS;
	private String ID_member;
	private boolean editable;
	private String couleur;
	private Boolean finie;
	public Boolean getFinie() {
		return finie;
	}
	public void setFinie(Boolean finie) {
		this.finie = finie;
	}
	public String getID_member() {
		return ID_member;
	}
	public void setID_member(String iD_member) {
		ID_member = iD_member;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<Soustache> getSoustaches() {
		return soustaches;
	}
	public void setSoustaches(List<Soustache> soustaches) {
		this.soustaches = soustaches;
	}
	public Datetache getDebut() {
		return debut;
	}
	public void setDebut(Datetache debut) {
		this.debut = debut;
	}
	public Datetache getFin() {
		return fin;
	}
	public void setFin(Datetache fin) {
		this.fin = fin;
	}
	public String getTACHE_SUIVANTE() {
		return TACHE_SUIVANTE;
	}
	public void setTACHE_SUIVANTE(String tACHE_SUIVANTE) {
		TACHE_SUIVANTE = tACHE_SUIVANTE;
	}
	public String getID_PROJETS() {
		return ID_PROJETS;
	}
	public void setID_PROJETS(String iD_PROJETS) {
		ID_PROJETS = iD_PROJETS;
	}
	

}
