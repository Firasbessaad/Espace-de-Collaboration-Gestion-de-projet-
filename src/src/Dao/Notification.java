package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Notation;

public class Notification {

	public static void notifgroupe(String login, String IDGROUPE, String IMAGE, String LIEN, String CONTENU) {
		Connection conn = null;
		PreparedStatement pst = null;
		
       
		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		
		Date now = new Date(0);
		
		
			
		
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok pour notifier groupe .");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			pst = conn  				
					.prepareStatement("INSERT INTO NOTIFICATIONS(ID, SENDER, IDGROUPE, IMAGE, CONTENU, LIEN, DATEENVOI, LU) VALUES( ?, ?, ?, ?, ?, ?, ?, ?)");
			String id = Setidnotif()+"";

			pst.setString(1, id);
			pst.setString(2, login);System.out.print(id);
			pst.setString(3,IDGROUPE);
			pst.setString(4,IMAGE);
			pst.setString(5,LIEN);
			pst.setString(6,CONTENU); 
			pst.setDate(7, now);
			pst.setString(8,"lu");
			
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
}
		
	}

	public static int Setidnotif() {
		int id = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok pour get id notif.");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			
			pst = conn
					.prepareStatement("SELECT COUNT(*) "+"COUNT"+" FROM NOTIFICATIONS");
		
			
			
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
	public static List<Entite.Notification> lister(String id_groupe,String login){
		 List<Entite.Notification> notifications = new ArrayList<Entite.Notification>();
		 Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
				
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de notifications demander encadrement.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				
				pst = conn 
						.prepareStatement("select * from notifications where notifications.IDGROUPE=? and notifications.SENDER !=?");
				pst.setString(1, id_groupe);
				pst.setString(2, login);
				 
				
				rs = pst.executeQuery();
				
				while(rs.next()){
					String id = rs.getString("ID");
					
					String IDGROUPE = rs.getString("IDGROUPE");
	                String SENDER =  rs.getString("SENDER");
	                String IMAGE = "./img/"+rs.getString("IMAGE");
	                String CONTENU = rs.getString("CONTENU");
	                String LIEN = rs.getString("LIEN");
	                Date DATEENVOI = rs.getDate("DATEENVOI");
	                String LU = rs.getString("LU");
	                Entite.Notification notification = new Entite.Notification();
	                notification.setID(id);
	                notification.setIDGROUPE(IDGROUPE);
	                notification.setSENDER(SENDER);
	                notification.setCONTENU(CONTENU);
	                notification.setIMAGE(IMAGE);
	                notification.setLIEN(LIEN);
	                notification.setLU(LU);
	                notification.setDATEENVOI(DATEENVOI);
	                	
	                notifications.add(notification);	
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
			return notifications;}


/*	public static List<Entite.Notification> listerSuggestion(String login){
		 List<Entite.Notification> notifications = new ArrayList<Entite.Notification>();
		 Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	       
			
			
			String driver ="oracle.jdbc.driver.OracleDriver";
			String userName = "FIRAS1";
			String password = "firas";
			
				
			try {
				Class.forName(driver).newInstance();
				System.out.println("Oracle JDBC driver loaded ok get list de notifications demander encadrement.");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
				
				pst = conn 
						.prepareStatement("select * from NOTIFGROUP where  notifications.SENDER !=? and (NOTIFGROUP.MEMBRE3=? or NOTIFGROUP.MEMBRE3=? or NOTIFGROUP.MEMBRE3=?)" );
		               pst.setString(1, login);
		               pst.setString(2, login);
		               pst.setString(3, login);
		               pst.setString(4, login);
				
				rs = pst.executeQuery();
				
				while(rs.next()){
					String id = rs.getString("ID");
					
					//String IDGROUPE = rs.getString("IDGROUPE");
	                String SENDER =  rs.getString("SENDER");
	                String IMAGE = "./img/"+rs.getString("IMAGE");
	                String CONTENU = rs.getString("CONTENU");
	                String LIEN = rs.getString("LIEN");
	                Date DATEENVOI = rs.getDate("DATEENVOI");
	                String LU = rs.getString("LU");
	                Entite.Notification notification = new Entite.Notification();
	                notification.setID(id);
	                //notification.setIDGROUPE(IDGROUPE);
	                notification.setSENDER(SENDER);
	                notification.setCONTENU(CONTENU);
	                notification.setIMAGE(IMAGE);
	                notification.setLIEN(LIEN);
	                notification.setLU(LU);
	                notification.setDATEENVOI(DATEENVOI);
	                	
	                notifications.add(notification);	
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
			return notifications;}

	
	public static void notif_ajout_groupe(String login, String membre1, String membre2, String membre3, String IMAGE, String LIEN, String CONTENU) {
		Connection conn = null;
		PreparedStatement pst = null;
		
       
		
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String userName = "FIRAS1";
		String password = "firas";
		
		Date now = new Date(0);
		
		
			
		
		try {
			Class.forName(driver).newInstance();
			System.out.println("Oracle JDBC driver loaded ok .");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",userName, password);
			pst = conn  				
					.prepareStatement("INSERT INTO NOTIFGROUP(ID, SENDER, membre1, membre2, membre3, IMAGE, CONTENU, LIEN, DATEENVOI, LU) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			String id = Setidnotif()+"";

			pst.setString(1, id);
			pst.setString(2, login);
			pst.setString(3,membre1);
			pst.setString(4,membre2);
			pst.setString(5,membre3);
			pst.setString(6,IMAGE);
			pst.setString(7,LIEN);
			pst.setString(8,CONTENU); 
			pst.setDate(9, now);
			pst.setString(10,"lu");
			
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
}
		
	}
	*/
}
