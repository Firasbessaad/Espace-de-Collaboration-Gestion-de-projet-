package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Authentification;
import Dao.ManipProposition;
import Dao.Notification;
import Entite.Demande;
import Entite.Enseignant;
import Entite.Etudiant;


/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static void Connect_enseignant(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
HttpSession session = request.getSession();
		
		session.setAttribute("user", "enseignant");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		String Login = request.getParameter("login");
		String Password = request.getParameter("password");
		Enseignant e = Authentification.authentifications(Login, Password, "enseignant");
		if(e.isConnecté()){
			session.setAttribute("connecté", e.isConnecté());
			session.setAttribute("login",Login);
			session.setAttribute("nom",e.getNOM());
			session.setAttribute("prenom",e.getPRENOM());
	        session.setAttribute("photo", e.getPHOTO());
	        session.setAttribute("mail",e.getMAIL());
	        request.setAttribute("propositions", ManipProposition.lister(""));
	      
	        RequestDispatcher rd=request.getRequestDispatcher("accueil.jsp");  
			rd.forward(request,response);
		}else{  
			out.print("<p style=\"color:red\">Sorry username or password incorrect</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
			rd.include(request,response);  }
		
    }
    public static void Connect_etudiant (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
HttpSession session = request.getSession();
session.setAttribute("user", "etudiant");
		if(session.getAttribute("connecté")== null)
		{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		String Login = request.getParameter("login");
		String Password = request.getParameter("password");
		Etudiant e = Authentification.authentifications(Login, Password);
		String nom = e.getNom();
		String prenom = e.getPrenom();
		String mail = e.getMail();
		String photo = e.getPhoto();
		String encadreur = e.getEncadreur();
		String id_groupe = e.getId_group();
		String id_projet = e.getId_projet();
		String couleur = e.getCouleur();
		
		if(e.getConnecté()){  
			
			
			session.setAttribute("connecté", e.getConnecté());
			session.setAttribute("login",Login);
			session.setAttribute("nom",nom);
			session.setAttribute("prenom",prenom);
	        session.setAttribute("photo", photo);
	        session.setAttribute("mail",mail);
	        
	        session.setAttribute("encadreur",encadreur);
	        
	        if(id_groupe!=null){
	        	 //request.setAttribute("idgroupe",id_groupe);
	        	request.setAttribute("Message","k");
	        	System.out.print("session");
	        session.setAttribute("idgroupe",id_groupe);
	        }else{
	        	request.setAttribute("Message","Construir un groupe d abord");
	        	System.out.print("ssdjjdjdjdjdjd");
	        }
	        if(id_projet!=null){
	        	 session.setAttribute("idprojet",id_projet);
	        }
	        if(couleur!=null){
	        	 session.setAttribute("couleur",couleur);
	        }
	        request.setAttribute("propositions", ManipProposition.lister(id_groupe));
	        List<Entite.Notification> sug = Notification.lister( Login, Login);
	        List<Entite.Notification> notifications = Notification.lister( id_groupe, Login);
	        
	        notifications.addAll(sug);
	        
	        //List<Entite.Notification> suggestion = Notification.listerSuggestion(Login);
			//notifications.addAll(suggestion);
			request.setAttribute("notifications",notifications);
			
	        RequestDispatcher rd=request.getRequestDispatcher("accueil.jsp");  
			rd.forward(request,response);  
		}else{  
			out.print("<p style=\"color:red\">Sorry username or password incorrect</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
			rd.include(request,response);  
			
		}
		}
	else{
			// request.setAttribute("propositions", ManipProposition.lister((String) session.getAttribute("idgroupe")));
			RequestDispatcher rd=request.getRequestDispatcher("/accueil.jsp");  
			rd.include(request,response);  
			//response.sendRedirect("http://localhost:8081/Pcd2test/Home");
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("connecté")== null)
		{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		String Login = request.getParameter("login");
		String Password = request.getParameter("password");
		Etudiant e = Authentification.authentifications(Login, Password);
		String nom = e.getNom();
		String prenom = e.getPrenom();
		String mail = e.getMail();
		String photo = e.getPhoto();
		String encadreur = e.getEncadreur();
		String id_groupe = e.getId_group();
		String id_projet = e.getId_projet();
		 
		if(e.getConnecté()){  
			
			
			session.setAttribute("connecté", e.getConnecté());
			session.setAttribute("login",Login);
			session.setAttribute("nom",nom);
			session.setAttribute("prenom",prenom);
	        session.setAttribute("photo", photo);
	        session.setAttribute("mail",mail);
	        request.setAttribute("encadreur",encadreur);
	        request.setAttribute("idgroupe",id_groupe);
	        request.setAttribute("idprojet",id_projet);
	        request.setAttribute("propositions", ManipProposition.lister(id_groupe));
	        List<Entite.Notification> notifications = Notification.lister( id_groupe, Login);
	        List<Entite.Notification> sug = Notification.lister( Login, Login);
	        notifications.addAll(sug);
	        System.out.print("\n\n firas   \n\n");
	        System.out.print(sug.get(0));
	        System.out.print("\n\n firas   \n\n");
			request.setAttribute("notifications",notifications);
			
	        
	        RequestDispatcher rd=request.getRequestDispatcher("accueil.jsp");  
			rd.forward(request,response);  
		}else{  
			out.print("<p style=\"color:red\">Sorry username or password incorrect</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
			rd.include(request,response);  
			
		}
		}else{ request.setAttribute("propositions", ManipProposition.lister((String) session.getAttribute("idgroupe")));
			RequestDispatcher rd=request.getRequestDispatcher("/accueil.jsp");  
			rd.include(request,response);  
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		if(user!=null){
		Connect_etudiant ( request,  response);
				}else
				{
					Connect_enseignant( request,  response);
				}
		
	}

}
