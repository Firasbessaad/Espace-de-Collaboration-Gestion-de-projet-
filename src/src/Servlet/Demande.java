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
import javax.websocket.Session;

import Dao.ManipProposition;

/**
 * Servlet implementation class Demande
 */
@WebServlet("/Demande")
public class Demande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demande() {
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
		String nom = request.getParameter("typeProposition");
		String corps = request.getParameter("proposition");
		int nbgroupe = Integer.parseInt(request.getParameter("nbg"));
		if(request.getParameter("soumettre")!=null){
			System.out.print("kkkkkkkkkkkkkkkkkkk");
		ManipProposition.Soumettre_Proposition( nom ,  login, corps, nbgroupe);
		}
List<Entite.Demande> demandes = ManipProposition.listerDemande(login);
		
		
		request.setAttribute("demandes", demandes);
		RequestDispatcher rd=request.getRequestDispatcher("/demande.jsp");  
		rd.include(request,response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		for(int i =1;i<=100;i++){
			if(request.getParameter(""+i)!=null){
			if(request.getParameter(""+i).equals("Accepter")){
				ManipProposition.accepter_Demande(""+i);
				
			}
			if(request.getParameter(""+i).equals("Refuser")){
				ManipProposition.refuser_Demande(""+i);
			}}
		}
		List<Entite.Demande> demandes = ManipProposition.listerDemande(login);
		
		
		request.setAttribute("demandes", demandes);
		RequestDispatcher rd=request.getRequestDispatcher("/demande.jsp");  
		rd.include(request,response); 
	}

}
