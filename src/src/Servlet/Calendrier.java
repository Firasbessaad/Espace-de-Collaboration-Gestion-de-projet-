package Servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CalendrierManip;
import Dao.Notification;
import Entite.Datetache;
import Entite.Soustache;
import Entite.Tache;

/**
 * Servlet implementation class Calendrier
 */
@WebServlet("/Calendrier")
public class Calendrier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calendrier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session = request.getSession();
String login = (String) session.getAttribute("login");

	    String idprojet = (String) session.getAttribute("idprojet");
	    String idgroupe = (String) session.getAttribute("idgroupe");
		String modif = request.getParameter("info");
		System.out.print("\n"+modif);
		System.out.print("\nhfhhfhfhhfhfhhfhfh");
		if(login!=null){	
		if(modif!=null ){
		String tache = modif.substring(modif.lastIndexOf(':')+1,modif.lastIndexOf(','));
		int date =Integer.parseInt(modif.substring(modif.lastIndexOf('[')+1,modif.lastIndexOf(']')));
        Tache Tach = CalendrierManip.selecttitretachesui(tache, idprojet);
        System.out.print("/"+Tach.getTitre()+"/");
       
        
       List<Tache> ntches = CalendrierManip.deplacer(date, Tach, idprojet);
     try {
		CalendrierManip.updateTache(ntches, idprojet);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
     List<Tache> taches = CalendrierManip.listermytache(idprojet, login);
		
		List<Tache> othertaches =CalendrierManip.listerothertache(idprojet, login);
		taches.addAll(othertaches);
		int a=Integer.parseInt(taches.get(taches.size()-1).getId());
		for(int i = 1; i<=100;i++ ){
			String id = request.getParameter(""+i);
			if (id != null) {
				System.out.print(i);
				System.out.print("\n");	
			CalendrierManip.finirtache(""+i);
			int nbtache = CalendrierManip.nbtache(idprojet);
			int nbtachfinie = CalendrierManip.nbtachefini(idprojet);
			List<Tache> Avancement= CalendrierManip.Avancement(nbtache,nbtachfinie,login);
			 taches = CalendrierManip.listermytache(idprojet, login);
			 
			 othertaches =CalendrierManip.listerothertache(idprojet, login);
			taches.addAll(othertaches);
			taches.addAll(Avancement);
			}
		}
			
		List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
		//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
		//notifications.addAll(suggestion);
		request.setAttribute("notifications",notifications);
		request.setAttribute("taches",taches);
		RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher("/Calendrier.jsp");
dispatcher.forward(request,response);
		}else{
			response.sendRedirect("http://localhost:8081/Pcd2test");	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	    String login = (String) session.getAttribute("login");
	    String name = (String) session.getAttribute("nom");
	    String idprojet = (String) session.getAttribute("idprojet");
	    String idgroupe = (String) session.getAttribute("idgroupe");
		String tache1 = request.getParameter("tache1");
		
		String date_debuttache1 = request.getParameter("datedebut_tache1");
		
		String date_fintache1 = request.getParameter("datefin_tache1");
	
		String tachedepend = request.getParameter("tachedepend");
		
		
		
		Tache tache = new Tache();
		System.out.print(date_debuttache1+"\n");
		Datetache debut = new Datetache();
		Datetache fin = new Datetache();
		if((!date_debuttache1.equals("") )& (!date_fintache1.equals(""))){
			System.out.print(date_debuttache1+"\n");
		debut.setAnnee((CalendrierManip.convertAnnee(date_debuttache1)));
		debut.setMois((CalendrierManip.convertmois(date_debuttache1))-1);
		debut.setJour((CalendrierManip.convertJour(date_debuttache1)));
		fin.setAnnee((CalendrierManip.convertAnnee(date_fintache1)));
		fin.setMois((CalendrierManip.convertmois(date_fintache1))-1);
		fin.setJour((CalendrierManip.convertJour(date_fintache1)));
		tache.setTitre(tache1);
		tache.setTACHE_SUIVANTE(tachedepend);
		tache.setCouleur((String)session.getAttribute("couleur"));
		tache.setID_member(login);
		tache.setID_PROJETS(idprojet);
		tache.setDebut(debut);
		tache.setFin(fin);
		CalendrierManip.insertTache(tache);
		Notification.notifgroupe(login, idgroupe, "icon128.png", "http://localhost:8081/Pcd2test/Calendrier", "votre collègue "+ name +" 1 a ajouté une tache nomée  "+tache.getTitre());
		List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
		//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
		//notifications.addAll(suggestion);
		request.setAttribute("notifications",notifications);
		}
		int nbtache = CalendrierManip.nbtache(idprojet);
		int nbtachfinie = CalendrierManip.nbtachefini(idprojet);
		List<Tache> taches = CalendrierManip.listermytache(idprojet, login);
		List<Tache> Avancement= CalendrierManip.Avancement(nbtache,nbtachfinie,login);
		List<Tache> othertaches =CalendrierManip.listerothertache(idprojet, login);
		taches.addAll(othertaches);
		taches.addAll(Avancement);
		List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
		//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
		//notifications.addAll(suggestion);
		request.setAttribute("notifications",notifications);
		
		request.setAttribute("taches",taches);
		
		
		
		RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher("/Calendrier.jsp");
dispatcher.forward(request,response);
	}

}
