package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entite.Demande;
import Entite.Proposition;

public class ManipProposition {

	
	public static List<Proposition> lister(String id_groupe){
		 List<Proposition> propositions = new ArrayList<Proposition>();
		 Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			int nbchoix = rang(id_groupe);
			if(nbchoix > 1){
				System.out.print("\n "+nbchoix+" choix trouvé \n");
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de propositions demander encadrement.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				
				pst = conn
						.prepareStatement("select * from TPROPOSITION, tenseignant where TPROPOSITION.ACCEPTE='1' and TENSEIGNANT.LOGIN = TPROPOSITION.ID_ENSEIGNANT and TPROPOSITION.idp not in (select ID_PROPOSITION from tchoix where ID_GROUPE =?)");
				pst.setString(1, id_groupe);
				System.out.print("\n pres d'etre exécuté  jd djjd \n");
				rs = pst.executeQuery();
				System.out.print("\n exécuté kkkdkkdkd");
				while(rs.next()){
					String id = rs.getString("IDp");
					
					String nom = rs.getString("NOMp");
	                String enseignant = "Dr "+ rs.getString("nom_enseignant") +" "+rs.getString("prenom_ENSEIGNANT");
	                String photo_enseignant = "./img/"+rs.getString("photo_enseignant");
	                int groupe_number = rs.getInt("NBGROUPE");
	                String corps = rs.getString("CORPS");
	                Proposition proposition = new Proposition();
	                proposition.setId(id);
	                proposition.setNom(nom);
	                proposition.setEnseignant(enseignant);
	                proposition.setGroupe_number(groupe_number);
	                proposition.setCorps(corps);
	                proposition.setPhotoenseignant(photo_enseignant);
	                proposition.setEtat("Demander encadrement");
	                	
	                propositions.add(proposition);	
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
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de propositions demande envoyé.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				
				pst = conn
						.prepareStatement("select * from TPROPOSITION, TENSEIGNANT, tchoix where TPROPOSITION.ACCEPTE='1' and  TENSEIGNANT.LOGIN = TPROPOSITION.ID_ENSEIGNANT and tchoix.ID_PROPOSITION = TPROPOSITION.idp and tchoix.ID_GROUPE=?");
				
				pst.setString(1, id_groupe);
				rs = pst.executeQuery();
				System.out.print("\n no data found \n");
				while(rs.next()){
					
	                 String id = rs.getString("IDp");
					
					String nom = rs.getString("NOMp");
	                String enseignant = "Dr "+ rs.getString("nom_enseignant") +" "+rs.getString("prenom_ENSEIGNANT");
	                String photo_enseignant = "./img/"+rs.getString("photo_enseignant");
	                int groupe_number = rs.getInt("NBGROUPE");
	                String corps = rs.getString("CORPS");
	                Proposition proposition = new Proposition();
	                proposition.setId(id);
	                proposition.setNom(nom);
	                proposition.setEnseignant(enseignant);
	                proposition.setGroupe_number(groupe_number);
	                proposition.setCorps(corps);
	                proposition.setPhotoenseignant(photo_enseignant);
	                proposition.setEtat("Envoyé");
	                	
	                propositions.add(proposition);	
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
			else{
				System.out.print("\n aucune choix trouvé \n");
				try {
					Class.forName(driver).newInstance();
					System.out.println("Oracle JDBC driver loaded ok get list de propositions demander encadrement.");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
					
					pst = conn
							.prepareStatement("select * from TPROPOSITION, TENSEIGNANT where TPROPOSITION.ACCEPTE='1' and TENSEIGNANT.LOGIN = TPROPOSITION.ID_ENSEIGNANT ");
					
					System.out.print("\n pres d'etre exécuté \n");
					rs = pst.executeQuery();
					System.out.print("\n exécuté");
					while(rs.next()){
						String id = rs.getString("IDp");
						
						String nom = rs.getString("NOMp");
		                String enseignant = "Dr "+ rs.getString("nom_enseignant") +" "+rs.getString("prenom_ENSEIGNANT");
		                String photo_enseignant = "./img/"+rs.getString("photo_enseignant");
		                int groupe_number = rs.getInt("NBGROUPE");
		                String corps = rs.getString("CORPS");
		                Proposition proposition = new Proposition();
		                proposition.setId(id);
		                proposition.setNom(nom);
		                proposition.setEnseignant(enseignant);
		                proposition.setGroupe_number(groupe_number);
		                proposition.setCorps(corps);
		                proposition.setPhotoenseignant(photo_enseignant);
		                proposition.setEtat("Demander encadrement");
		                	
		                propositions.add(proposition);	
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
				
				
			}
		 return propositions;	
	}

	public static int rang(String id_groupe){
		int rang=0;	

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
					.prepareStatement("SELECT COUNT(*) "+"COUNT"+" FROM tCHOIX WHERE ID_GROUPE=?");
			pst.setString(1,id_groupe);
			
			
			rs = pst.executeQuery();
			rs.next();
			rang = rs.getInt("COUNT");
			rang++;
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

		
		return rang;
	}

public static void EnvoyerDemande(String id_proposition , String id_groupe){
	
	 

		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		int visibilite = 0;
		//on va tester si c'est son premier choix alors qu'il sera visible pour l'enseignant sinon invisible
		int rang = rang( id_groupe);
		if(rang==1){
			visibilite = 1;
		}
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok pour envoyer une demande");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			System.out.print(id_proposition+"gggg");
			String id = id_groupe + id_proposition;
			pst = conn
					.prepareStatement("INSERT INTO tCHOIX(ID, ID_GROUPE, RANG, ID_PROPOSITION, ID_ENCADREUR, VISIBILITE) VALUES(?, ?, ?, ?, ?, ?)");
			pst.setString(1, id);
			pst.setString(2, id_groupe);
			pst.setInt(3, rang);
			pst.setString(4, id_proposition);
			
			pst.setString(5,id_encadreur(id_proposition));
			pst.setInt(6, visibilite);
			System.out.print("entrain de faire une insertion ");
			pst.executeUpdate();
			System.out.print("insertion est effectué");
			//pst.setString(2,id_proposition);
			
			
			
			
				
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
			
		}
			
}
public static String id_encadreur(String id_proposition){
	String id_encadreur = "";
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok pour get id-encadreur.");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		
		pst = conn
				.prepareStatement("select login from tPROPOSITION, tENSEIGNANT where tENSEIGNANT.login = tPROPOSITION.ID_ENSEIGNANT and tPROPOSITION.idp=?");
		pst.setString(1, id_proposition);
		
		rs = pst.executeQuery();
	    rs.next();
	    id_encadreur=rs.getString("login");
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
	    
	
	
	
	
	return id_encadreur;
	
}

public static List<Demande> listerDemande(String login) {
	// TODO Auto-generated method stub
	 List<Demande> demandes = new ArrayList<Demande>();
	 Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
       
		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		System.out.print("\n"+login+"\n");
		
		try {
			Class.forName(driver).newInstance();
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);

			
			pst = conn
					.prepareStatement("select Tchoix.ID_GROUPE,  NOMP, ID_MEMBRE1, ID_MEMBRE2, ID_MEMBRE3 from Tchoix, tgroupe, TPROPOSITION, tetudiant where Tchoix.ACCEPTE is null and tetudiant.login=ID_MEMBRE1 and tgroupe.id = tchoix.ID_GROUPE and tchoix.ID_ENCADREUR=? and VISIBILITE='1' and ID_PROPOSITION = IDP order by tchoix.ID_GROUPE ");
			pst.setString(1, login);
			
			rs = pst.executeQuery();
			while (rs.next()) {
				
				Demande demande = new Demande();
				
				demande.setId(rs.getString("ID_GROUPE"));
				demande.setNom(rs.getString("NOMP"));
				demande.setMemeber0(Authentification.getNomPrenom (rs.getString("ID_MEMBRE1")));
				demande.setMemeber1(Authentification.getNomPrenom (rs.getString("ID_MEMBRE2")));
				demande.setMemeber2(Authentification.getNomPrenom (rs.getString("ID_MEMBRE3")));
                demande.setPhotomemeber0(Authentification.getPhoto(rs.getString("ID_MEMBRE1")));
                demande.setPhotomemeber1(Authentification.getPhoto(rs.getString("ID_MEMBRE2")));
                demande.setPhotomemeber2(Authentification.getPhoto(rs.getString("ID_MEMBRE3")));
                demandes.add(demande);
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
		    
	
	return demandes;
}	
	
	
public static void accepter_Demande(String idgroupe){
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
				.prepareStatement("UPDATE tchoix SET ACCEPTE='accepte' WHERE ID_GROUPE=? and VISIBILITE='1'");
		pst.setString(1, idgroupe);
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
public static void refuser_Demande(String idgroupe){
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	int rang = get_Rang(idgroupe);
	supprimer(idgroupe);
	
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok pour get rang.");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		 pst = conn
				.prepareStatement("UPDATE tchoix SET VISIBILITE='1' WHERE ID_GROUPE=? and RANG=?");
		pst.setString(1, idgroupe);
		pst.setInt(2, rang);
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

public static int get_Rang(String idgroupe){
	int rang=0;
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
				.prepareStatement("select RANG from tchoix  WHERE ID_GROUPE=? and VISIBILITE='1'");
		pst.setString(1, idgroupe);
		rs= pst.executeQuery();
		System.out.print("\n c'est bon \n");
		while(rs.next()){
			rang=rs.getInt("RANG");
			rang++;
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
	return rang;
		
}
public static void supprimer(String idgroupe){
	
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
				.prepareStatement("delete tchoix  WHERE ID_GROUPE=? and VISIBILITE='1'");
		pst.setString(1, idgroupe);
		rs= pst.executeQuery();
		
		
		
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


public static void Soumettre_Proposition(String nom , String id_enseignat, String corps, int nbgroupe){
	
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok pour envoyer une demande");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		
		String id = "p"+getIdproposition();
		pst = conn 						
				.prepareStatement("INSERT INTO TPROPOSITION(IDP, NOMP, CORPS, ID_ENSEIGNANT, NBGROUPE, ACCEPTE) VALUES(?, ?, ?, ?, ?, ?)");
		pst.setString(1, id);
		pst.setString(2, nom);
		pst.setString(3, corps);
		pst.setString(4, id_enseignat);
		pst.setInt(5, nbgroupe);
		pst.setString(6,"0");
		
		System.out.print("entrain de faire une insertion ");
		pst.executeUpdate();
		System.out.print("insertion est effectué");
		//pst.setString(2,id_proposition);
		
		
		
		
			
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
		
	}
		
}

public static int getIdproposition() {
	int id=0;	

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
				.prepareStatement("SELECT COUNT(*) "+"COUNT"+" FROM TPROPOSITION");
		
		
		
		rs = pst.executeQuery();
		rs.next();
		id = rs.getInt("COUNT");
		id++;
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

	
	return id;
}

}
