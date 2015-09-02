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
import Dao.Notification;


/**
 * Servlet implementation class Fichier
 */
@WebServlet("/Fichier")
public class Fichier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fichier() {
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
	    String idgroupe = (String) session.getAttribute("idgroupe");
	    String nomfichiersansext="";
        String idprojet = (String) session.getAttribute("idprojet");
       
	    
	    if(Login!=null){
		
		for(int i=0;i<=100;i++){
		if(request.getParameter("f"+i) != null) {
			 nomfichiersansext = request.getParameter("f"+i).substring(0, request.getParameter("f"+i).lastIndexOf('.'));
			 System.out.print(idgroupe);
			 List<Entite.Notification> notifications = Notification.lister( idgroupe, Login);
				//List<Entite.Notification> suggestion = Notification.listerSuggestion(Login);
				//notifications.addAll(suggestion);
				request.setAttribute("notifications",notifications);
				RequestDispatcher dispatcher = getServletContext().
		                getRequestDispatcher("/Groupes/"+idgroupe+"/"+nomfichiersansext+".jsp");
		dispatcher.forward(request,response);
		}
		if (request.getParameter("Sf"+i) != null) {
			EspaceManip.supprimer_fichier(""+i); 
			request.setAttribute("fichiers", EspaceManip.listerfichier(idprojet));
			List<Entite.Notification> notifications = Notification.lister( idgroupe, Login);
			
			//List<Entite.Notification> suggestion = Notification.listerSuggestion(Login);
			//notifications.addAll(suggestion);
			
			request.setAttribute("notifications",notifications);
			RequestDispatcher dispatcher = getServletContext().
	                getRequestDispatcher("/projettest.jsp");
	dispatcher.forward(request,response);
		}
		
		}
		
		}	
		
	else{
	response.sendRedirect("http://localhost:8081/Pcd2test");	
}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
