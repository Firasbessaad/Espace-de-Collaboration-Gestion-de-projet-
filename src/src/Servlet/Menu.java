package Servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CalendrierManip;
import Dao.EspaceManip;
import Dao.ManipProposition;
import Dao.Notification;
import Entite.DataObject;
import Entite.Demande;
import Entite.Groupe;
import Entite.Soustache;
import Entite.Tache;


/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String Login = (String) session.getAttribute("login");
	    
	    if(Login!=null){
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
	    StringBuffer emps = new StringBuffer("");
	    emps.append("{title: 'Hangout with friends',start: new Date(y, m, 1),end: new Date(y, m, 5)},{title: 'Meeting with client',start: new Date(y, m, 10),allDay: true},");
	    request.setAttribute("string", emps);
	    out.println(emps);
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
		 String idprojet = (String) session.getAttribute("idprojet");
		 String idgroupe = (String) session.getAttribute("idgroupe");
		String espace = request.getParameter("espace");
		String accueil = request.getParameter("accueil");
		String calendrier = request.getParameter("calendrier");
		String forum = request.getParameter("forum");
		String profil = request.getParameter("profil");
		String demande = request.getParameter("demande");
		System.out.print(demande);
		String user = (String)session.getAttribute("user");
		System.out.print(user+"lllllllll");
		if(user.equals("etudiant"))
		{
		if(login!=null){
		List<Groupe> groupes = EspaceManip.listersugestgroupe(login);
		request.setAttribute("Message",  EspaceManip.appartient_groupe(login));
		
		if (calendrier != null) {
			Calendar rightNow = Calendar.getInstance();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
			        DateFormat.SHORT,
			        DateFormat.SHORT);
			Date dtache = null;
			int jour = rightNow.get(Calendar.DAY_OF_MONTH);
			int mois =rightNow.get(Calendar.MONTH)+1;
			int annee = rightNow.get(Calendar.YEAR);
			session.setAttribute("jour",jour);
			session.setAttribute("mois",mois);
			session.setAttribute("annee",annee);
			String color = "rgba(75, 93, 221, 1)";
			session.setAttribute("color", color);
			List<Tache> taches = CalendrierManip.listermytache(idprojet, login);
			
			List<Tache> othertaches =CalendrierManip.listerothertache(idprojet, login);
			taches.addAll(othertaches);
			int nbtache = CalendrierManip.nbtache(idprojet);
			int nbtachfinie = CalendrierManip.nbtachefini(idprojet);
			
			List<Tache> Avancement= CalendrierManip.Avancement(nbtache,nbtachfinie,login);
			
			taches.addAll(Avancement);
			request.setAttribute("taches",taches);
			request.setAttribute("taches", taches);
			
			long diff=0;
		    if(!taches.isEmpty())
		    {
			for(int i= 0; i<taches.size();i++ ){
				System.out.print(taches.get(i).getTitre());	
					
				
			}}
		    List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
		   // List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
			//notifications.addAll(suggestion);
			request.setAttribute("notifications",notifications);
			RequestDispatcher dispatcher = getServletContext().
	                getRequestDispatcher("/Calendrier.jsp");
			
	dispatcher.forward(request,response);
	
		}
		if (espace != null) {
			
			request.setAttribute("groupes", EspaceManip.listergroupe(login));
			request.setAttribute("projets", EspaceManip.listerprojet(login));
			request.setAttribute("sugesGroupes", EspaceManip.listersugestgroupe(login));
			if(EspaceManip.appartient_groupe(login)){
				request.setAttribute("Message", "Vous etes deja engagé");
				List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
				//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
				//notifications.addAll(suggestion);
				request.setAttribute("notifications",notifications);
			}else{
				request.setAttribute("Message",  groupes.size()+" Demandes d'ajouts");
				List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
				//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
				//notifications.addAll(suggestion);
				request.setAttribute("notifications",notifications);
			}
			
			if(!EspaceManip.listergroupe(login).isEmpty()){
				request.setAttribute("idgroupe", EspaceManip.getidgroupe(login));
				List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
				//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
				//notifications.addAll(suggestion);
				request.setAttribute("notifications",notifications);
			}
			
			RequestDispatcher dispatcher = getServletContext().
	                getRequestDispatcher("/Espace_de_travail.jsp");
			
	dispatcher.forward(request,response);
	
		}
		if (accueil != null) {
			if(!EspaceManip.listergroupe(login).isEmpty()){
				request.setAttribute("idgroupe", EspaceManip.getidgroupe(login));
				List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
				//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
				//notifications.addAll(suggestion);
				request.setAttribute("notifications",notifications);
				if(EspaceManip.getidgroupe(login)!=""){
					request.setAttribute("Message","");
				}else{
					request.setAttribute("Message","Construir un groupe d abord");
				}
				
			}
			request.setAttribute("propositions", ManipProposition.lister(EspaceManip.getidgroupe(login)));
			List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
			//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
			//notifications.addAll(suggestion);
			request.setAttribute("notifications",notifications);
			RequestDispatcher dispatcher = getServletContext().
	                getRequestDispatcher("/accueil.jsp");
	dispatcher.forward(request,response);
		}
		if (forum != null) {
			List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
			//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
			//notifications.addAll(suggestion);
			request.setAttribute("notifications",notifications);
			//request.setAttribute("propositions", ManipProposition.lister(EspaceManip.getidgroupe(login)));
			RequestDispatcher dispatcher = getServletContext().
	                getRequestDispatcher("/Forum.jsp");
	dispatcher.forward(request,response);
		}
		if (profil != null) {
			List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
			//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
			//notifications.addAll(suggestion);
			request.setAttribute("notifications",notifications);
			//request.setAttribute("propositions", ManipProposition.lister(EspaceManip.getidgroupe(login)));
			RequestDispatcher dispatcher = getServletContext().
	                getRequestDispatcher("/Profil.jsp");
	dispatcher.forward(request,response);
		}
		}
		
			
		
		
	else{
		System.out.print(login+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		response.sendRedirect("http://localhost:8081/Pcd2test");	
	}
		
			
		
}else{
	if (demande != null) {
	List<Demande> demandes = ManipProposition.listerDemande(login);
	
	System.out.print("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	request.setAttribute("demandes", demandes);
	RequestDispatcher dispatcher = getServletContext().
            getRequestDispatcher("/demande.jsp");
dispatcher.forward(request,response);}
if (profil != null) {
	//List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
	//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
	//notifications.addAll(suggestion);
	//request.setAttribute("notifications",notifications);
	//request.setAttribute("propositions", ManipProposition.lister(EspaceManip.getidgroupe(login)));
	RequestDispatcher dispatcher = getServletContext().
            getRequestDispatcher("/Profil.jsp");
dispatcher.forward(request,response);
}
if (espace != null) {
	
	List<Demande> projets = EspaceManip.listerprojets(login);
	
	request.setAttribute("projets", projets);
	RequestDispatcher dispatcher = getServletContext().
            getRequestDispatcher("/Espace_de_travail.jsp");
	
dispatcher.forward(request,response);

}
if (accueil != null) {
	System.out.print("kkkskskskskkksskskksksks");
		
		
	
	request.setAttribute("propositions", ManipProposition.lister(""));
	//List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
	//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
	//notifications.addAll(suggestion);
	//request.setAttribute("notifications",notifications);
	RequestDispatcher dispatcher = getServletContext().
            getRequestDispatcher("/accueil.jsp");
dispatcher.forward(request,response);
}
}
		}}
