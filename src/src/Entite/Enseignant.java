package Entite;

public class Enseignant {
	private String id;
	
	private String LOGIN ;
	private String NOM ;
	private String PASSWORD ;
	private String PRENOM ;
	private String PHOTO;
	private String MAIL;
private boolean connecté;
	public boolean isConnecté() {
	return connecté;
}
public void setConnecté(boolean connecté) {
	this.connecté = connecté;
}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLOGIN() {
		return LOGIN;
	}
	public void setLOGIN(String lOGIN) {
		LOGIN = lOGIN;
	}
	public String getNOM() {
		return NOM;
	}
	public void setNOM(String nOM) {
		NOM = nOM;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getPRENOM() {
		return PRENOM;
	}
	public void setPRENOM(String pRENOM) {
		PRENOM = pRENOM;
	}
	public String getPHOTO() {
		return PHOTO;
	}
	public void setPHOTO(String pHOTO) {
		PHOTO = pHOTO;
	}
	public String getMAIL() {
		return MAIL;
	}
	public void setMAIL(String mAIL) {
		MAIL = mAIL;
	}
	
}
