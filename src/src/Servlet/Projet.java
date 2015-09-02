package Servlet;

import java.io.FileWriter;
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
import Dao.ManipProjet;
import Dao.Notification;



/**
 * Servlet implementation class Projet
 */
@WebServlet("/Projet")
public class Projet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Projet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String idgroupe = (String) session.getAttribute("idgroupe");
	    String Login = (String) session.getAttribute("login");
	    String idprojet = (String) session.getAttribute("idprojet");
	    if(Login!=null){
		String nomfichier = request.getParameter("nvfichier");
		String bnomfichier = request.getParameter("nouveaufichier");
		if(bnomfichier != null){
			
			 ManipProjet.nouveau_Fichier( nomfichier,  idgroupe ,  idprojet);
			 
			 String nomfichiersansext = nomfichier.substring(0, nomfichier.lastIndexOf('.'));
				String langage = nomfichier.substring(nomfichier.lastIndexOf('.')+1);
			 if(nomfichiersansext.indexOf('.')!=-1){
					nomfichiersansext=nomfichiersansext.substring(0, nomfichiersansext.lastIndexOf('.') );
					nomfichier=nomfichiersansext+"."+langage;
				}

		String format = "dd/MM/yy"; 

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date DATEMODIF = new java.util.Date(); 
        String date = formater.format( DATEMODIF )+"";
			
			EspaceManip.ajouter_fichier(nomfichier, idprojet,Login, "only membre", date);
			request.setAttribute("fichiers", EspaceManip.listerfichier(idprojet));
			List<Entite.Notification> notifications = Notification.lister( idgroupe, Login);
			
			//List<Entite.Notification> suggestion = Notification.listerSuggestion(Login);
			//notifications.addAll(suggestion);
			
			request.setAttribute("notifications",notifications);
			RequestDispatcher dispatcher = getServletContext().
	                getRequestDispatcher("/projettest.jsp");
	dispatcher.forward(request,response);
			
		}}else{
			response.sendRedirect("http://localhost:8081/Pcd2test");	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	    String Login = (String) session.getAttribute("login");
	    String idgroupe = (String) session.getAttribute("idgroupe");
		request.setAttribute("projets", EspaceManip.listerprojet(Login));
        String idprojet = (String) session.getAttribute("idprojet");
		request.setAttribute("fichiers", EspaceManip.listerfichier(idprojet));
		List<Entite.Notification> notifications = Notification.lister( idgroupe, Login);
		//List<Entite.Notification> suggestion = Notification.listerSuggestion(Login);
	//  notifications.addAll(suggestion);
		request.setAttribute("notifications",notifications);
		RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher("/projettest.jsp");
dispatcher.forward(request,response);
		
	}

}
