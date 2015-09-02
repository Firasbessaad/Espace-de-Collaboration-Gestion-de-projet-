package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import Entite.Datetache;
import Entite.Soustache;
import Entite.Tache;

public class CalendrierManip {
	
	public static List<Tache> listermytache(String idprojet,String login){
		 List<Tache> taches = new ArrayList<Tache>();
		 Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de tache ");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				pst = conn
				.prepareStatement("select * from tache where tache.ID_PROJETS=? and tache.idmember=? ");
				pst.setString(1, idprojet);
				pst.setString(2, login);
				rs = pst.executeQuery();
				while(rs.next()){
					
					
						Tache tache = new Tache();
						Datetache debut = new Datetache();
						Datetache fin = new Datetache();
						
						tache.setId(rs.getString("IDTACHE"));
						tache.setID_member(login);
						tache.setTACHE_SUIVANTE(rs.getString("TACHE_SUIVANTE"));	
						tache.setCouleur(rs.getString("couleur"));
						String test = rs.getString("FINI");
						System.out.print("\n"+test+" jdjdjjdjd \n");
						if(test!=null)
						{tache.setEditable(false);
						}
						else{
						tache.setEditable(true);
						}
						debut.setJour(rs.getInt("Jd"));
						
						debut.setMois(rs.getInt("Md"));
						
						debut.setAnnee(rs.getInt("Ad"));
						
						fin.setJour(rs.getInt("Jf"));
						fin.setMois(rs.getInt("Mf"));
						fin.setAnnee(rs.getInt("Af"));
						tache.setDebut(debut);
						tache.setFin(fin);	
						tache.setID_PROJETS(rs.getString("ID_PROJETS"));	
						tache.setTitre(rs.getString("TITRE"));
					    System.out.print("laaaaaaaaaaa"+tache.getTitre()+tache.getFin().getJour()+"/"+tache.getFin().getMois()+"/"+tache.getFin().getAnnee()+"\n");
					    tache.setFinie(rs.getString("fini") != null);
					    taches.add(tache);	
		                
		                Date d = new Date((tache.getFin().getAnnee()-1900), tache.getFin().getMois(), tache.getFin().getJour());
		                Date now = new Date();
		                DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
		                        DateFormat.SHORT,
		                        DateFormat.SHORT);
		                
		                now.setMinutes(00);
		                now.setSeconds(00);
		                System.out.print("oui "+"hh \n"+now.before(d)+"\n"+d+"\n"+now+"\n");
		                if(now.after(d)&!tache.getFinie()){
		                	
		                Datetache finretard = new Datetache();	
		                	String datd = shortDateFormat.format(now);
		                	String jd = datd.substring(0, 2);
		                	String md = datd.substring(3, 5);
		                	String dd = datd.substring(6, 8);
		                	dd="20"+dd;
		                	fin.setJour(fin.getJour());
		                	

		                	
		                	finretard.setJour(Integer.parseInt(jd));
		                	finretard.setMois(Integer.parseInt(md)-1);
		                	finretard.setAnnee(Integer.parseInt(dd));

		                	
		                	
		                	
		                	
		                	Tache tacheretard = new Tache();
		                	Datetache debutretard = new Datetache();
		                	tacheretard.setId(rs.getString("IDTACHE"));
		                	tacheretard.setID_member(login);
		                	tacheretard.setTACHE_SUIVANTE(rs.getString("TACHE_SUIVANTE"));	
		                	tacheretard.setCouleur("#d9534f");
		                	tacheretard.setEditable(true);
							debutretard.setJour(rs.getInt("Jf")+1);
							
							debutretard.setMois(rs.getInt("Mf"));
							
							debutretard.setAnnee(rs.getInt("Af"));
							
							
							tacheretard.setDebut(debutretard);
							tacheretard.setFin(finretard);	
							tacheretard.setID_PROJETS(rs.getString("ID_PROJETS"));	
							tacheretard.setTitre(rs.getString("TITRE")+" en retard");
							tacheretard.setFinie(true);
							
			                taches.add(tacheretard);
		                }
		                
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
			return taches;
			}
	public static List<Tache> listerothertache(String idprojet,String login){
		 List<Tache> taches = new ArrayList<Tache>();
		 Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de tache ");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				pst = conn
				.prepareStatement("select * from tache where tache.ID_PROJETS=? and tache.idmember!=?  ");
				pst.setString(1, idprojet);
				pst.setString(2, login);
				rs = pst.executeQuery();
				while(rs.next()){
					
					
						Tache tache = new Tache();
						Datetache debut = new Datetache();
						Datetache fin = new Datetache();
						
						tache.setId(rs.getString("IDTACHE"));
						tache.setID_member(rs.getString("idmember"));
						tache.setTACHE_SUIVANTE(rs.getString("TACHE_SUIVANTE"));	
						tache.setCouleur(rs.getString("couleur"));
						tache.setEditable(false);
						debut.setJour(rs.getInt("Jd"));
						
						debut.setMois(rs.getInt("Md"));
						
						debut.setAnnee(rs.getInt("Ad"));
						
						fin.setJour(rs.getInt("Jf"));
						fin.setMois(rs.getInt("Mf"));
						fin.setAnnee(rs.getInt("Af"));
						tache.setDebut(debut);
						tache.setFin(fin);	
						tache.setID_PROJETS(rs.getString("ID_PROJETS"));	
						tache.setTitre(rs.getString("TITRE"));
						tache.setFinie(rs.getString("fini") != null);
					    
		                taches.add(tache);
		                Date d = new Date((tache.getFin().getAnnee()-1900), tache.getFin().getMois(), tache.getFin().getJour());
		                Date now = new Date();
		                DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
		                        DateFormat.SHORT,
		                        DateFormat.SHORT);
		                
		                if(now.after(d)& !tache.getFinie()){
		                	
		                Datetache finretard = new Datetache();	
		                	String datd = shortDateFormat.format(now);
		                	String jd = datd.substring(0, 2);
		                	String md = datd.substring(3, 5);
		                	String dd = datd.substring(6, 8);
		                	dd="20"+dd;
		                	

		                	
		                	finretard.setJour(Integer.parseInt(jd));
		                	finretard.setMois(Integer.parseInt(md)-1);
		                	finretard.setAnnee(Integer.parseInt(dd));

		                	
		                	
		                	
		                	
		                	Tache tacheretard = new Tache();
		                	Datetache debutretard = new Datetache();
		                	tacheretard.setId(rs.getString("IDTACHE"));
		                	tacheretard.setID_member(login);
		                	tacheretard.setTACHE_SUIVANTE(rs.getString("TACHE_SUIVANTE"));	
		                	tacheretard.setCouleur("#ff0000");
		                	tacheretard.setEditable(false);
							debutretard.setJour(rs.getInt("Jf")+1);
							
							debutretard.setMois(rs.getInt("Mf"));
							
							debutretard.setAnnee(rs.getInt("Af"));
							
							
							tacheretard.setDebut(debutretard);
							tacheretard.setFin(finretard);	
							tacheretard.setID_PROJETS(rs.getString("ID_PROJETS"));	
							tacheretard.setTitre(rs.getString("TITRE")+" en retard");
							tacheretard.setFinie(true);
							
			                taches.add(tacheretard);
		                }
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
			return taches;
			}
	public static int nbtachefini(String idprojet){
		
		 int av=0;
		Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de soustache demander encadrement.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				pst = conn
				.prepareStatement("select COUNT(*) "+"COUNT"+" from tache where tache.ID_PROJETS=? and tache.fini is not null");
				pst.setString(1, idprojet);
				rs = pst.executeQuery();
				while(rs.next()){
					av = rs.getInt("COUNT") ; 
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
			
			return av;
			}
	public static int nbtache(String idprojet){
		
		 int av=1;
		Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de soustache demander encadrement.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				pst = conn
				.prepareStatement("select COUNT(*) "+"COUNT"+" from tache where tache.ID_PROJETS=?");
				pst.setString(1, idprojet);
				rs = pst.executeQuery();
				while(rs.next()){
					av = rs.getInt("COUNT") ; 
					
					
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
			
			return av;
			}
	public static List<Tache> Avancement(float nbtache, float nbtachfinie, String login){
		List<Tache>  Avancement = new ArrayList<Tache>();
		String poucentage = "";
		
		double c = new Double(nbtache);
		 
        double resultat = nbtachfinie/c;
        double resultatFinal = resultat*100;
 
 
        DecimalFormat df = new DecimalFormat("###.##");
        poucentage= df.format(resultatFinal) + " %";
		System.out.print("aaaaaahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+poucentage);
		
		Tache tache = new Tache();
		Datetache debut = new Datetache();
		Datetache fin = new Datetache();
		 Datetache finannee = new Datetache();
		 Date now = new Date();
         DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                 DateFormat.SHORT,
                 DateFormat.SHORT);
     	String datd = shortDateFormat.format(now);
     	String jd = datd.substring(0, 2);
     	String md = datd.substring(3, 5);
     	String dd = datd.substring(6, 8);
     	dd="20"+dd;
     	

     	
     	fin.setJour(Integer.parseInt(jd));
     	fin.setMois(Integer.parseInt(md)-1);
     	fin.setAnnee(Integer.parseInt(dd));
		
		tache.setID_member(login);	
		tache.setCouleur("#F8F8FF");
		tache.setEditable(false);
		debut.setJour(1);
		
		debut.setMois(1);
		
		debut.setAnnee(2015);
		
		
		tache.setDebut(debut);
		tache.setFin(fin);		
		tache.setTitre("Votre avancement est : "+poucentage);
		tache.setFinie(true);
		Avancement.add(tache);
		finannee.setJour(30);
		finannee.setMois(4);
		finannee.setAnnee(2015);
		Tache tache1 = new Tache();
		tache1.setID_member(login);	
		tache1.setCouleur("transparent");
		tache1.setEditable(false);
		Datetache debutnow = new Datetache();
		debutnow.setJour(fin.getJour()+1);
		debutnow.setMois(fin.getMois());
		debutnow.setAnnee(fin.getAnnee());
		finannee.setJour(30);
		finannee.setMois(05);
		finannee.setAnnee(fin.getAnnee());
		tache1.setDebut(debutnow);
		tache1.setFin(finannee);
		tache1.setFinie(true);
		Avancement.add(tache1);
		
		return Avancement;
		
	}
	
	public static void insertTache(Tache tache){
	
		Connection conn = null;
		PreparedStatement pst = null;
		
       
		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		
		
			
		
		try {
			Class.forName(driver).newInstance();
			System.out.println("Insert tache .");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			pst = conn  				
					.prepareStatement("INSERT INTO tache(IDTACHE, TACHE_SUIVANTE, Jd, MD, AD, ID_PROJETS, TITRE, JF, MF, AF, IDMEMBER, COULEUR) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			String id = Setidtache()+"";

			pst.setString(1, id);
			pst.setString(2, tache.getTACHE_SUIVANTE());
			pst.setInt(3,tache.getDebut().getJour());
			pst.setInt(4,tache.getDebut().getMois());
			pst.setInt(5,tache.getDebut().getAnnee());
			pst.setString(6, tache.getID_PROJETS()); 
			pst.setString(7, tache.getTitre());
			pst.setInt(8,tache.getFin().getJour());
			pst.setInt(9,tache.getFin().getMois());
			pst.setInt(10,tache.getFin().getAnnee());
	        pst.setString(11, tache.getID_member());
	        pst.setString(12, tache.getCouleur());
	        pst.executeUpdate();
			
			
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
	public static int Setidtache() {
		int id = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok pour get id tache.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			
			pst = conn
					.prepareStatement("SELECT COUNT(*) "+"COUNT"+" FROM tache");
		
			
			
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
	/*public static Tache Avancement(String idprojet){
		
		Connection conn = null;
		PreparedStatement pst = null;
		
       
		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		
		
		
		
			
		
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok for insertion soustache.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			pst = conn  				 
					.prepareStatement("INSERT INTO soustache(IDSTACHE, STITRE, JDS, MDS, ADS, IDTACHES, JFS, MFS, AFS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			String id = Setidsoustache()+"";
			pst.setString(1, id);
			pst.setString(2, soustache.getTitre());
			pst.setInt(3,soustache.getDebut().getJour());
			pst.setInt(4,soustache.getDebut().getMois());
			pst.setInt(5,soustache.getDebut().getAnnee());
			pst.setString(6, soustache.getTACHE_Principal());
			pst.setInt(7,soustache.getFin().getJour());
			pst.setInt(8,soustache.getFin().getMois());
			pst.setInt(9,soustache.getFin().getAnnee()); 
			
			
	
			pst.executeUpdate();
			
			
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
}}*/
	public static int Setidsoustache() {
		int id = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok pour get id soutache.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			
			pst = conn
					.prepareStatement("SELECT COUNT(*) "+"COUNT"+" FROM SOUSTACHE");
		
			
			
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
	
public static int convertAnnee(String date){
	int a = 0;
	String y = date.substring(date.lastIndexOf('/')+1);
	a=Integer.parseInt(y);
	
	return a;
	
}
public static int convertmois(String date){
	int m = 0;
	String mois = date.substring(3,5);
	m=Integer.parseInt(mois);
	
	return m;
	
}			
public static int convertJour(String date){
	int j = 0;
	String jour = date.substring(0,2);
	j=Integer.parseInt(jour);
	
	return j;
	
}
public static Tache selecttitretachesui(String titretache, String idprojet){
	Tache tache = new Tache();	
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;



String driver ="oracle.jdbc.driver.OracleDriver";
String userName = "FIRAS1";
String password = "firas";

try {
	Class.forName(driver).newInstance();
	//System.out.println("\n selecttitretachesui \n");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
	pst = conn
	.prepareStatement("select * from tache where tache.ID_PROJETS=? and tache.TITRE=?");
	pst.setString(1, idprojet);
	pst.setString(2, titretache);
	rs = pst.executeQuery();
	
	while(rs.next()){
		
		
		Datetache debut = new Datetache();
		Datetache fin = new Datetache();
		
		tache.setId(rs.getString("IDTACHE"));
		
		tache.setTACHE_SUIVANTE(rs.getString("TACHE_SUIVANTE"));	
		
		debut.setJour(rs.getInt("Jd"));
		
		debut.setMois(rs.getInt("Md"));
		
		debut.setAnnee(rs.getInt("Ad"));
		
		fin.setJour(rs.getInt("Jf"));
		fin.setMois(rs.getInt("Mf"));
		fin.setAnnee(rs.getInt("Af"));
		tache.setDebut(debut);
		//System.out.print(tache.getDebut().getJour()+"/"+tache.getDebut().getMois()+"/"+tache.getDebut().getAnnee());
		tache.setFin(fin);	
		tache.setID_PROJETS(rs.getString("ID_PROJETS"));	
		tache.setTitre(rs.getString("TITRE"));
		
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

return tache;
}
public static List<Tache> deplacer( int nbjour, Tache tache , String idprojet ){
List<Tache> taches = new ArrayList<Tache>();
Tache uptache = tache;
System.out.print(tache.getTitre());
int i=0;
DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
        DateFormat.SHORT,
        DateFormat.SHORT);
GregorianCalendar calendar = new java.util.GregorianCalendar();
Date datfint = new Date((tache.getFin().getAnnee()-2000), tache.getFin().getMois(), tache.getFin().getJour());
calendar.setTime(datfint);
calendar.add (Calendar.DATE, nbjour);
String datd = shortDateFormat.format(calendar.getTime());
String jd = datd.substring(0, 2);
String md = datd.substring(3, 5);
String dd = datd.substring(6, 8);
dd="20"+dd;
Datetache fin = new Datetache();

calendar.add (Calendar.DATE, nbjour);
fin.setJour(Integer.parseInt(jd));
fin.setMois(Integer.parseInt(md)-1);
fin.setAnnee(Integer.parseInt(dd));


tache.setFin(fin);
String titresui = tache.getTitre();

System.out.print(tache.getTitre()+"commence : "+tache.getDebut().getJour()+"/"+tache.getDebut().getMois()+"/"+tache.getDebut().getAnnee()+"\n");
System.out.print(tache.getTitre()+"se termine apres un decalage de"+nbjour+" jours  le : "+tache.getFin().getJour()+"/"+tache.getFin().getMois()+"/"+tache.getFin().getAnnee()+"\n");
taches.add(uptache);
titresui= selecttitretachesui(titresui,idprojet).getTACHE_SUIVANTE();
while (titresui!=null) {
	System.out.print(titresui+idprojet+selecttitretachesui(titresui,idprojet).getTitre());
	
Tache suitache = selecttitretachesui(titresui,idprojet);
System.out.print(suitache.getTitre());
Datetache debutsui = new Datetache();
Datetache finsui = new Datetache();	
//instance de date de debut
Date datdebu = new Date((suitache.getDebut().getAnnee()-2000), suitache.getDebut().getMois(), suitache.getDebut().getJour());
calendar.setTime(datdebu);
calendar.add (Calendar.DATE, nbjour);
String datds = shortDateFormat.format(calendar.getTime());
String jds = datds.substring(0, 2);
String mds = datds.substring(3, 5);
String dds = datds.substring(6, 8);
dds="20"+dds;

debutsui.setJour(Integer.parseInt(jds));
debutsui.setMois(Integer.parseInt(mds)-1);
debutsui.setAnnee(Integer.parseInt(dds));
//instance date de fin 
Date datfin = new Date((suitache.getFin().getAnnee()-2000), suitache.getFin().getMois(), suitache.getFin().getJour());
calendar.setTime(datfin);
calendar.add (Calendar.DATE, nbjour);
datds = shortDateFormat.format(calendar.getTime());
 jds = datds.substring(0, 2);
 mds = datds.substring(3, 5);
 dds = datds.substring(6, 8);
dds="20"+dds;
finsui.setJour(Integer.parseInt(jds));
finsui.setMois(Integer.parseInt(mds)-1);
finsui.setAnnee(Integer.parseInt(dds));
suitache.setDebut(debutsui);
suitache.setFin(finsui);
System.out.print(suitache.getDebut().getJour()+"/"+suitache.getDebut().getMois()+"/"+suitache.getDebut().getAnnee()+"\n");
System.out.print(suitache.getFin().getJour()+"/"+suitache.getFin().getMois()+"/"+suitache.getFin().getAnnee()+"\n");
taches.add(suitache);

titresui=selecttitretachesui(titresui,idprojet).getTACHE_SUIVANTE();	
}	
	
	
return taches;}
	
public static void updateTache(List<Tache> taches, String idprojet) throws SQLException{
	for(int i=0;i<taches.size();i++){
		update(taches.get(i), idprojet);
	}
}
public static void update(Tache tache, String idprojet) throws SQLException{
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
				.prepareStatement("UPDATE tache SET JD=?, MD=?, AD=?, JF=? , MF=? , AF=? WHERE TITRE=? and ID_PROJETS=?");
		pst.setString(1, tache.getDebut().getJour()+"");
		pst.setString(2, tache.getDebut().getMois()+"");
		pst.setString(3, tache.getDebut().getAnnee()+"");
		pst.setString(4, tache.getFin().getJour()+"");
		pst.setString(5, tache.getFin().getMois()+"");
		pst.setString(6, tache.getFin().getAnnee()+"");
		pst.setString(7, tache.getTitre());
		pst.setString(8, idprojet);
		
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
	conn.close();
}
public static void finirtache(String id){
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	System.out.print("\n c'est bon \n");
	 Date now = new Date();
     DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
             DateFormat.SHORT,
             DateFormat.SHORT);
	Datetache finretard = new Datetache();	
	String datd = shortDateFormat.format(now);
	String jd = datd.substring(0, 2);
	String md = datd.substring(3, 5);
	String dd = datd.substring(6, 8);
	dd="20"+dd;
	

	
	finretard.setJour(Integer.parseInt(jd));
	finretard.setMois(Integer.parseInt(md)-1);
	finretard.setAnnee(Integer.parseInt(dd));
	
	String driver ="oracle.jdbc.driver.OracleDriver";
	String userName = "FIRAS1";
	String password = "firas";
	try {
		Class.forName(driver).newInstance();
		System.out.println("Oracle JDBC driver loaded ok pour update fini.");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
		 pst = conn
				.prepareStatement("UPDATE tache SET FINI=?, JF=? , MF=? , AF=? WHERE IDTACHE=?");
		 pst.setString(1, "finie");
		 pst.setString(2, finretard.getJour()+"");
		 pst.setString(3, finretard.getMois()+"");
		 pst.setString(4, finretard.getAnnee()+"");
		 pst.setString(5, id);
		pst.executeUpdate();
		
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
}
