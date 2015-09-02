package Dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.sql.DATE;
import Entite.Demande;
import Entite.Groupe;
import Entite.Fichier;
import Entite.Projet;
import Entite.Proposition;

public class EspaceManip {

	public static List<Groupe> listergroupe(String login){
		 List<Groupe> groupes = new ArrayList<Groupe>();
		 Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de propositions demander encadrement.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				pst = conn
				.prepareStatement("select ID_GROUPE from Tetudiant where login=?");
				pst.setString(1, login);
				
				rs = pst.executeQuery();
				while(rs.next()){
											
					String id = rs.getString("ID_GROUPE");
					
	                
	                
	                
	                Groupe groupe = new Groupe();
	                groupe.setId(id);
	                
	  	
	                groupes.add(groupe);	
				}
				
				
			}catch (Exception e) {
				
				System.out.println(e);
				
			}finally {
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
			return groupes;
			}

	public static List<Projet> listerprojet(String login){
		 List<Projet> projets = new ArrayList<Projet>();
		 Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de propositions demander encadrement.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				pst = conn
						.prepareStatement("select * from TPROjet, tenseignant, tetudiant where tetudiant.login=? and tprojet.ID_GROUPE=tetudiant.	ID_GROUPE and tprojet.ID_ENSEIGNANT=tenseignant.login");
				pst.setString(1, login);
				
				rs = pst.executeQuery();
				while(rs.next()){
							
					String id = rs.getString("IDPROJET");
					String idprop = rs.getString("ID_PROPOSITION");
					String idenseignant = rs.getString("ID_ENSEIGNANT");
					String nom = rs.getString("NOMPROJET");
	                String enseignant = "Dr "+ rs.getString("nom_enseignant") +" "+rs.getString("prenom_ENSEIGNANT");
	                String photo_enseignant = "./img/"+rs.getString("photo_enseignant");
	                String idgroupe = rs.getString("ID_GROUPE");
	                
	                
	                Projet projet = new Projet();
	                projet.setId(id);
	                projet.setNom(nom);
	                projet.setEnseignant(enseignant);
	                projet.setID_GROUPE(idgroupe);
	                projet.setID_PROPOSITION(idprop);
	                projet.setPhoto_enseignant(photo_enseignant);
	                projet.setIdenseignant(idenseignant);
	                projet.setFichiers(listerfichier(id));
	                	
	                projets.add(projet);	
				}
				
				
			}catch (Exception e) {
				
				System.out.println(e);
				
			}finally {
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
			return projets;
			}
	public static List<Fichier> listerfichier(String idprojet){
		 List<Fichier> fichiers = new ArrayList<Fichier>();
		 Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de propositions demander encadrement.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				pst = conn
						.prepareStatement("select * from TFICHIER, tetudiant where TFICHIER.ID_PROJET =? and tfichier.ID_MEMBRE=tetudiant.login");
				pst.setString(1, idprojet);
				
				rs = pst.executeQuery();
				while(rs.next()){
											
					String id = rs.getString("IDFICHIER");
					String nomf = rs.getString("NOMFICHIER");
					String ID_PROJET = rs.getString("ID_PROJET");
					String ID_MEMBRE = rs.getString("NOM");
	                Date DATEMODIF = rs.getDate("DATEMODIF");
	                String contenu = rs.getString("contenu"); 
	                String VISIBILITÉ = rs.getString("VISIBILITÉ");
	                
	                
	                Fichier fichier = new Fichier();
	                fichier.setIDFICHIER(id);
	                fichier.setNOMFICHIER(nomf);
	                fichier.setID_PROJET(ID_PROJET);
	                fichier.setID_MEMBRE(ID_MEMBRE);
	                fichier.setDATEMODIF(DATEMODIF);
	                fichier.setVISIBILITÉ(VISIBILITÉ);
	                fichier.setContenu(contenu);
	       
	                	
	                fichiers.add(fichier);	
				}
				
				
			}catch (Exception e) {
				
				System.out.println(e);
				
			}finally {
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
			return fichiers;
			}

	public static void nvgroupe(String idmember0, String idmember1, String idmember2, String idmember3 ){
		Connection conn = null;
		PreparedStatement pst = null;
		
       
		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		if(!appartient_groupe(idmember0) & !appartient_groupe(idmember1) & !appartient_groupe(idmember2) & !appartient_groupe(idmember3)){
			
		
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok .");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			pst = conn  				
					.prepareStatement("INSERT INTO tgroupe(ID, ID_MEMBRE1, ID_MEMBRE2, ID_MEMBRE3, ID_MEMBRE4) VALUES(?, ?, ?, ?, ?)");
			String id = SetidGroupe()+"";
			pst.setString(1, id);
			pst.setString(2, idmember0);
			pst.setString(3, idmember1);
			pst.setString(4, idmember2); 
			pst.setString(5,idmember3);
			
	
			pst.executeUpdate();
			PreparedStatement pst2 = conn
					.prepareStatement("UPDATE tetudiant SET ID_GROUPE=? , COULEUR=? WHERE login=?");
			pst2.setString(1, id);
			pst2.setString(2, "#12c025");
			pst2.setString(3, idmember0);
			String nom= Authentification.getNomPrenom(idmember0);
			if(idmember2!=null){
			Notification.notifgroupe(idmember0, idmember1, "groupe.png", "http://localhost:8081/Pcd2test/Espace", "Votre ami "+nom+" vous propose de travailler avec lui.  Le groupe est formé par : "+Authentification.getNomPrenom(idmember0)+","+Authentification.getNomPrenom(idmember1)+" et "+Authentification.getNomPrenom(idmember2)+".");
			Notification.notifgroupe(idmember0, idmember2, "groupe.png", "http://localhost:8081/Pcd2test/Espace", "Votre ami "+nom+" vous propose de travailler avec lui.  Le groupe est formé par : "+Authentification.getNomPrenom(idmember0)+","+Authentification.getNomPrenom(idmember1)+" et "+Authentification.getNomPrenom(idmember2)+".");
			}else{
				Notification.notifgroupe(idmember0, idmember1, "groupe.png", "http://localhost:8081/Pcd2test/Espace", "Votre ami "+nom+" vous propose de travailler avec lui.  Le groupe est formé par : "+Authentification.getNomPrenom(idmember0)+" et "+Authentification.getNomPrenom(idmember1)+".");
					
			}
			pst2.executeUpdate();
			
			}
		
		
catch (Exception e) {
	
	System.out.println(e);
	
}finally {
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
}}

	}
	public static boolean appartient_groupe(String idmembre){
		boolean status = false;
		 Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de propositions demander encadrement.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				pst = conn
				.prepareStatement("select ID_GROUPE from Tetudiant where login=? and ID_GROUPE is not null");
				pst.setString(1, idmembre);
				
				rs = pst.executeQuery();
				 while(rs.next())
				 {  
					
						status = true ;
					
					 
					 
					 
				 }
				}catch (Exception e) {
					
					System.out.println(e);
					
				}
			finally {
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
			}
		
		return status;
		
	}

	public static void nvprojet(String groupe) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pst = null;
		
       
		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		Proposition proposition = infoproposition(groupe);
			
		
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok .");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			pst = conn  								
					.prepareStatement("INSERT INTO tprojet(IDPROJET, NOMPROJET, ID_PROPOSITION, ID_ENSEIGNANT, ID_GROUPE) VALUES(?, ?, ?, ?, ?)");
			String id = proposition.getId()+groupe;
			pst.setString(1, id);
			pst.setString(2, nomprojet(proposition.getId()));
			pst.setString(3, proposition.getId());
			pst.setString(4, proposition.getEnseignant()); 
			pst.setString(5,groupe);
			
			
			
			
	
			pst.executeUpdate();
			PreparedStatement pst2 = conn
					.prepareStatement("UPDATE tetudiant SET ID_PROJET=? WHERE login in (select ID_MEMBRE1  from tgroupe where id=?) or login in (select ID_MEMBRE2  from tgroupe where id=?) or login in (select ID_MEMBRE3  from tgroupe where id=?)");
			pst2.setString(1, id);
			pst2.setString(2, groupe);
			pst2.setString(3, groupe);
			pst2.setString(4, groupe);
			pst2.executeUpdate();
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
	finally {
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
	}
		
		
		
		
		
		
		
	}
   public static Proposition infoproposition(String groupe){
	   
	   Proposition proposition = new Proposition();
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
					.prepareStatement("select ID_PROPOSITION, ID_ENCADREUR from tchoix where ID_GROUPE=? and ACCEPTE='accepte'");
			pst.setString(1, groupe);
			rs = pst.executeQuery();
			while(rs.next()){ 
				
				 
				 String id = rs.getString("ID_PROPOSITION");
				 String idencadreur = rs.getString("ID_ENCADREUR");
				 proposition.setEnseignant(idencadreur);
				 proposition.setId(id);
				
			}
			}catch (Exception ex) {
				
				System.out.println("Threw a SQLException in"+ex);
				
			}finally {
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
   
   
   
   
   
   
return proposition;
   }
   public static String nomprojet(String idprop){
   String nomprojet = null;
   
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
				.prepareStatement("select NOMP from TPROPOSITION where IDP=?");
		pst.setString(1, idprop);
		rs = pst.executeQuery();
		while(rs.next()){ 
			nomprojet = rs.getString("NOMP");
		}}catch (Exception ex) {
			
			System.out.println("Threw a SQLException in"+ex);
			
		}finally {
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
   
   
   return nomprojet;
   }
 public static String getidgroupe(String login){
	String idgroupe = null;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
   
	
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok get list de propositions demander encadrement.");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		pst = conn
		.prepareStatement("select * from tetudiant where tetudiant.login=?");
		pst.setString(1, login);
		
		System.out.print("n'est pas erreur ici \n");
		rs = pst.executeQuery();
		System.out.print("erreur ici \n");
		while(rs.next()){
									
			idgroupe = rs.getString("ID_GROUPE");
		}}catch (Exception ex) {
			
			System.out.println("Threw a SQLException in"+ex);
			
		}finally {
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
			}}
	   
	
	
	
	
	
	
	 
	 return idgroupe;
 }
 public static List<Groupe> listersugestgroupe(String login){
	 List<Groupe> groupes = new ArrayList<Groupe>();
	 Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
       
		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		if(!EspaceManip.appartient_groupe(login)){
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok get list de propositions demander encadrement.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			pst = conn
			.prepareStatement("select * from Tgroupe where ID_MEMBRE2=? or ID_MEMBRE3=? or ID_MEMBRE4=?");
			pst.setString(1, login);
			pst.setString(2, login);
			pst.setString(3, login);
			
			
			rs = pst.executeQuery();
			while(rs.next()){
										
				String id = rs.getString("id");
				String idmember0 = rs.getString("ID_MEMBRE1");
				String idmember1 = rs.getString("ID_MEMBRE2");
				String idmember2 = rs.getString("ID_MEMBRE3");
                
                String idmember3 = rs.getString("ID_MEMBRE4"); 
                String nom = Authentification.getNomPrenom(idmember0);
                                
                Groupe groupe = new Groupe();
                groupe.setId(id);
                groupe.setIdmember0(nom);
                groupe.setIdmember1(idmember1);
                groupe.setIdmember2(idmember2);
                groupe.setIdmember3(idmember3);
  	
                groupes.add(groupe);	
			}
			
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}finally {
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
		}}
		return groupes;
		}	
public static void validerappartenance(String login, String idgroupe){
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	System.out.print("\n c'est bon \n");
	
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	
	String couleur = "#7"+Integer.parseInt(login.substring(0, 2))+"f0"+Integer.parseInt(login.substring(login.length()%2,(login.length()%2)+1));
	
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok pour get rang.");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		 pst = conn
				.prepareStatement("UPDATE tetudiant SET ID_GROUPE=?, Couleur=? WHERE login=?");
		pst.setString(1, idgroupe);
		pst.setString(2, "#5e3972");
		pst.setString(3, login);
		
		
		pst.executeUpdate();
	System.out.print("\n c'est bon \n");
	
	}catch (Exception e) {
		
		System.out.println(e);
		
	}finally {
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
	
	
}
public static int SetidGroupe(){
	int idgroupe= 0;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok pour get rang.");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		
		pst = conn
				.prepareStatement("SELECT COUNT(*) "+"COUNT"+" FROM tgroupe");
	
		
		
		rs = pst.executeQuery();
		rs.next();
		idgroupe = rs.getInt("COUNT");
		idgroupe++;
	}catch (Exception e) {
		
		System.out.println(e);
		
	}finally {
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

	
	return idgroupe;
}

public static void ajouter_fichier(String	NOMFICHIER, String	ID_PROJET, String	ID_MEMBRE, String VISIBILITÉ, String dATEMODIF	){

	Connection conn = null;
	PreparedStatement pst = null;
	
   
	
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	String date = dATEMODIF+", 'mm/dd/yyyy' ";
	System.out.print(date+"hgjdjjfj");	
	
	
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok .");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		pst = conn  								
				.prepareStatement("INSERT INTO tfichier(IDFICHIER, NOMFICHIER, ID_PROJET, ID_MEMBRE, VISIBILITÉ, DATEMODIF, CONTENU) VALUES(?, ?, ?, ?, ?, TO_DATE(?, 'dd/MM/yy'), ?)");
		String id = SetfichierId()+"";
		pst.setString(1, id);
		pst.setString(2, NOMFICHIER);
		pst.setString(3, ID_PROJET);
		pst.setString(4, ID_MEMBRE); 
		pst.setString(5, VISIBILITÉ);
		pst.setString(6,dATEMODIF);
		pst.setString(7,"test");
		pst.executeUpdate();
	}catch (Exception e) {
		
		System.out.println(e);
		
	}
finally {
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
}
	
	
	
	
	
	
	
}
public static int SetfichierId(){
	int idfich=0;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok pour get rang.");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		
		pst = conn
				.prepareStatement("SELECT COUNT(*) "+"COUNT"+" FROM tfichier");
	
		
		
		rs = pst.executeQuery();
		rs.next();
		idfich = rs.getInt("COUNT");
		idfich++;
	}catch (Exception e) {
		
		System.out.println(e);
		
	}finally {
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
	
	
	
	
	return idfich;
}
public static List<Demande> listerprojets(String login){
	 List<Demande> groupes = new ArrayList<Demande>();
	 Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
      
		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok get list de propositions demander encadrement.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			pst = conn
			.prepareStatement("select * from TPROjet, TGroupe  where ID_ENSEIGNANT=? and TPROJET.ID_GROUPE=TGROUPE.id");
			pst.setString(1, login);
			
			rs = pst.executeQuery();
			while(rs.next()){
				
               Demande groupe = new Demande();
               groupe.setId(rs.getString("IDPROJET"));
               groupe.setMemeber0(Authentification.getNomPrenom (rs.getString("ID_MEMBRE1")));
               groupe.setMemeber1(Authentification.getNomPrenom (rs.getString("ID_MEMBRE2")));
               groupe.setMemeber2(Authentification.getNomPrenom (rs.getString("ID_MEMBRE3")));
               groupe.setPhotomemeber0(Authentification.getPhoto(rs.getString("ID_MEMBRE1")));
               groupe.setPhotomemeber1(Authentification.getPhoto(rs.getString("ID_MEMBRE2")));
               groupe.setPhotomemeber2(Authentification.getPhoto(rs.getString("ID_MEMBRE3")));
 	
               groupes.add(groupe);	
			}
			
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}finally {
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
		return groupes;
		}

public static void supprimer_fichier(String id) {
	Connection conn = null;
	PreparedStatement pst = null;
	
   
	
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	
	
	
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok .");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		pst = conn  								
				.prepareStatement("delete  tfichier where IDFICHIER=? ");
		
		pst.setString(1, id);
		
		pst.executeQuery();
	}catch (Exception e) {
		
		System.out.println(e);
		
	}
finally {
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
}
	
	
}


}

