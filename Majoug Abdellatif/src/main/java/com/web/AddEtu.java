package com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.GestionEtudiant;

/**
 * Servlet implementation class AddEtu
 */
@WebServlet("/Addetu")
public class AddEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cpt =0;
	GestionEtudiant et;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEtu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		et = new GestionEtudiant();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lg = request.getParameter("log"); 
		String ps = request.getParameter("pass"); 
		String nm = request.getParameter("nom"); 
		String pm = request.getParameter("prenom"); 

		int nb = et.AddEtudiant(lg,ps,nm,pm);
		
		if(nb == 1)
		{
			HttpSession ses = request.getSession(true);
			ses.setAttribute("Etudiant",et);
			response.sendRedirect("authentification.jsp");
		}
	}
}
