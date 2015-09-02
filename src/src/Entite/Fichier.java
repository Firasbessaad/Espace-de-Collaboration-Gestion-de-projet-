package Entite;

import java.util.Date;

public class Fichier {
	private String IDFICHIER;	
	private String NOMFICHIER;	
	private String ID_PROJET	;
	private String ID_MEMBRE	;
	private String VISIBILITÉ	;
	private Date DATEMODIF;
	private String contenu;
	
	
	
	public String getIDFICHIER() {
		return IDFICHIER;
	}
	public void setIDFICHIER(String iDFICHIER) {
		IDFICHIER = iDFICHIER;
	}
	public String getNOMFICHIER() {
		return NOMFICHIER;
	}
	public void setNOMFICHIER(String nOMFICHIER) {
		NOMFICHIER = nOMFICHIER;
	}
	public String getID_PROJET() {
		return ID_PROJET;
	}
	public void setID_PROJET(String iD_PROJET) {
		ID_PROJET = iD_PROJET;
	}
	public String getID_MEMBRE() {
		return ID_MEMBRE;
	}
	public void setID_MEMBRE(String iD_MEMBRE) {
		ID_MEMBRE = iD_MEMBRE;
	}
	public String getVISIBILITÉ() {
		return VISIBILITÉ;
	}
	public void setVISIBILITÉ(String vISIBILITÉ) {
		VISIBILITÉ = vISIBILITÉ;
	}
	public Date getDATEMODIF() {
		return DATEMODIF;
	}
	public void setDATEMODIF(Date dATEMODIF) {
		DATEMODIF = dATEMODIF;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
