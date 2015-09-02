package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Authentification;
import Dao.EspaceManip;
import Dao.Notification;
import Entite.Groupe;

/**
 * Servlet implementation class Espace
 */
@WebServlet("/Espace")
public class Espace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Espace() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String login = (String) session.getAttribute("login");
		String idgroupe = (String) session.getAttribute("idgroupe");
		request.setAttribute("projets", EspaceManip.listerprojet(login));
		request.setAttribute("groupes", EspaceManip.listergroupe(login));
		List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
		request.setAttribute("notifications",notifications);
		RequestDispatcher rd=request.getRequestDispatcher("/Espace_de_travail.jsp");  
		rd.forward(request,response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String nom = (String) session.getAttribute("nom");
		String login = (String) session.getAttribute("login");
		String member0 = request.getParameter("member0");
		String member1 = request.getParameter("member1");
		String member2 = request.getParameter("member2");
		String member3 = request.getParameter("member3");
		String nvprojet = request.getParameter("nvprojet");
		String nvgroupe = request.getParameter("nvgroupe");
		List<Groupe> groupes = EspaceManip.listersugestgroupe(login);
		//String groupe = request.getParameter("groupe");
		
		
		request.setAttribute("Message",  EspaceManip.appartient_groupe(login));
		
		if(EspaceManip.appartient_groupe(login)){
			request.setAttribute("Message", "Vous etes deja engagé");	
		}else{
			request.setAttribute("Message",  groupes.size()+" Demandes d'ajouts");
		}
		if (nvgroupe != null){
		EspaceManip.nvgroupe(member0,member1,member2,member3);
		String idgroupe = EspaceManip.getidgroupe(login);
		request.setAttribute("idgroupe",idgroupe );
		
		List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
		//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
		//notifications.addAll(suggestion);
		request.setAttribute("notifications",notifications);
		}
		
		 
		for(int i=0;i<=100;i++){
			
			if (request.getParameter("a"+i)!= null) {
				//accepter appartenance
				
				EspaceManip.validerappartenance(login, groupes.get(0).getId());
				request.setAttribute("idgroupe", groupes.get(0).getId());
				
				groupes.clear();
				request.setAttribute("sugesGroupes", groupes);
				
				
				
			}
			}
				
		
		if (nvprojet != null){
			String g = EspaceManip.getidgroupe(login);
			if(g!=null){
				
				
			EspaceManip.nvprojet(g);
			String idprojet = EspaceManip.infoproposition(g).getId()+EspaceManip.getidgroupe(login);
			
			session.setAttribute("idprojet", idprojet);
			System.out.print(g+"ajouté projet");
			}
			}
		
		
		request.setAttribute("projets", EspaceManip.listerprojet(login));
		request.setAttribute("groupes", EspaceManip.listergroupe(login));
		
		RequestDispatcher rd=request.getRequestDispatcher("/Espace_de_travail.jsp");  
		rd.forward(request,response); 
	}

}
