package Entite;

import java.util.List;

public class Soustache {
	private String id;
	private String titre;
	private Datetache debut;
	private Datetache fin;
	private String TACHE_Principal;
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
	public String getTACHE_Principal() {
		return TACHE_Principal;
	}
	public void setTACHE_Principal(String tACHE_Principal) {
		TACHE_Principal = tACHE_Principal;
	}

}
