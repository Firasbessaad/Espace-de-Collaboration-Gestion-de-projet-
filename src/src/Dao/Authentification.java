package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entite.Enseignant;
import Entite.Etudiant;

public class Authentification {

	
	public static Etudiant authentifications (String name, String pass) {
		Etudiant e = new Etudiant();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok pour l'authentification.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			
			pst = conn
					.prepareStatement("select * from tETUDIANT where LOGIN=? and PASSWORD=?");
			pst.setString(1, name);
			pst.setString(2, pass);
			
			rs = pst.executeQuery();
			while(rs.next()){ 								
				String id = rs.getString("LOGIN");
				 String nom = rs.getString("NOM");
				 String prenom = rs.getString("PRENOM");
				 String id_group = rs.getString("ID_GROUPE");
				 String encadreur = rs.getString("ID_ENCADREUR");
				 String id_projet = rs.getString("ID_PROJET");
				 String photo = "/img/"+rs.getString("PHOTO");
				 String mail = rs.getString("MAIL");
				 String couleur = rs.getString("couleur");
				 Boolean connecté = true;
				 e.setId(id);
				 e.setNom(nom);
				 e.setPrenom(prenom);
				 e.setId_group(id_group);
				 e.setEncadreur(encadreur);
				 e.setId_projet(id_projet);
				 e.setPhoto(photo);
				 e.setMail(mail);
				 e.setConnecté(connecté);
				 e.setCouleur(couleur);
				
				
				
				
				
			}
		}catch (Exception ex) {
			
			System.out.println("Threw a SQLException in"+ex);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		return e;
		
	}
	
	public static String getNomPrenom (String idmember){
		String Nom_Prenom ="";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok pour l'authentification.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			
			pst = conn
					.prepareStatement("select * from tETUDIANT where LOGIN=?");
			pst.setString(1, idmember);
			
			
			rs = pst.executeQuery();
			while(rs.next()){ 								
				String id = rs.getString("LOGIN");
				 String nom = rs.getString("NOM");
				 String prenom = rs.getString("PRENOM");
				 Nom_Prenom = nom+" "+prenom;
			}
}catch (Exception ex) {
			
			System.out.println("Threw a SQLException in"+ex);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		return Nom_Prenom;
		
		
		
	}
	public static Enseignant authentifications (String name, String pass ,String enseignant) {
		Enseignant e = new Enseignant();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok pour l'authentification.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			
			pst = conn
					.prepareStatement("select * from TENSEIGNANT where LOGIN=? and PASSWORD=?");
			pst.setString(1, name);
			pst.setString(2, pass);
			
			rs = pst.executeQuery();
			while(rs.next()){ 								
				String id = rs.getString("LOGIN");	
				 String nom = rs.getString("NOM_ENSEIGNANT");
				 String prenom = rs.getString("PRENOM_ENSEIGNANT");
				 
				 String photo = "/img/"+rs.getString("PHOTO_ENSEIGNANT");
				 String mail = rs.getString("MAIL");
				
				 Boolean connecté = true;
				 e.setId(id);
				 e.setNOM(nom);
				 e.setPRENOM(prenom);
				 e.setPHOTO(photo);
				 e.setMAIL(mail);
				 e.setConnecté(connecté);
			}
		}catch (Exception ex) {
			
			System.out.println("Threw a SQLException in"+ex);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		return e;
		
	}
	public static String getPhoto(String idmember){
		String Photo ="";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok pour l'authentification.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			
			pst = conn
					.prepareStatement("select * from tETUDIANT where LOGIN=?");
			pst.setString(1, idmember);
			
			
			rs = pst.executeQuery();
			while(rs.next()){ 								
				
				 Photo = "./img/"+rs.getString("PHOTO");
			}
}catch (Exception ex) {
			
			System.out.println("Threw a SQLException in"+ex);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		return Photo;
		
		
		
	}
	
}
