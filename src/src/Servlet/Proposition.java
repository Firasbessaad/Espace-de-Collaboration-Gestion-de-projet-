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

import Dao.EspaceManip;
import Dao.ManipProposition;
import Dao.Notification;


/**
 * Servlet implementation class Proposition
 */
@WebServlet("/Proposition")
public class Proposition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proposition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html"); 
		
		HttpSession session = request.getSession(false);
		String login = (String) session.getAttribute("login");
		String idgroupe = EspaceManip.getidgroupe(login);
		List<Entite.Notification> notifications = Notification.lister( idgroupe, login);
		
		//List<Entite.Notification> suggestion = Notification.listerSuggestion(login);
		//notifications.addAll(suggestion);
		
		
		if(idgroupe!=null){
			int a = ManipProposition.lister(idgroupe).size();
		for(int i=1;i<=a;i++){
			if (request.getParameter("p"+i) != null) {
				//appeler la fonction qui envoi une demande
				
				
				
				ManipProposition.EnvoyerDemande("p"+i, idgroupe);
				//request.setAttribute("propositions", ManipProposition.lister(idgroupe));
				
					
			}
			}
		request.setAttribute("Message"," rien");
		request.setAttribute("propositions", ManipProposition.lister(idgroupe));
	}   
	
		RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher("/accueil.jsp");
dispatcher.forward(request,response);
		
	}

}
