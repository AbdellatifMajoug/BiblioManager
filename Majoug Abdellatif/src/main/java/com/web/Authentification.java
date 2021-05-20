package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.Etudiant;
import com.util.GestionEtudiant;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cp = 0;
	GestionEtudiant ge;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	  ge = new GestionEtudiant();
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lg=request.getParameter("log");
		String ps=request.getParameter("pass");
		Etudiant et = ge.authentification(lg,ps);
		if(et!=null)
		{
		HttpSession ses = request.getSession(true);
		ses.setAttribute("etudiant",et);
		response.sendRedirect("AffLivre.jsp");
		}
		else
		{
			cp++;
			response.sendRedirect("authentification.jsp?res=err&cpt="+cp);
		}
	}
}
