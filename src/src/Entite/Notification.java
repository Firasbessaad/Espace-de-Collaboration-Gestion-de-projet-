package Entite;

import java.sql.Date;

public class Notification {
	 private  String ID;
	 private  String  SENDER;
	 private  String IDGROUPE;
	 private  String IMAGE;
	 private  String CONTENU;
	 private  String LIEN;
	 private  Date DATEENVOI;
	 private  String LU;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSENDER() {
		return SENDER;
	}
	public void setSENDER(String sENDER) {
		SENDER = sENDER;
	}
	public String getIDGROUPE() {
		return IDGROUPE;
	}
	public void setIDGROUPE(String iDGROUPE) {
		IDGROUPE = iDGROUPE;
	}
	public String getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}
	public String getCONTENU() {
		return CONTENU;
	}
	public void setCONTENU(String cONTENU) {
		CONTENU = cONTENU;
	}
	public String getLIEN() {
		return LIEN;
	}
	public void setLIEN(String lIEN) {
		LIEN = lIEN;
	}
	public Date getDATEENVOI() {
		return DATEENVOI;
	}
	public void setDATEENVOI(Date dATEENVOI) {
		DATEENVOI = dATEENVOI;
	}
	public String getLU() {
		return LU;
	}
	public void setLU(String lU) {
		LU = lU;
	}
}
