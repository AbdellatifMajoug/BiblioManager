package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.GestionLivre;

/**
 * Servlet implementation class AddLivre
 */
@WebServlet("/AddLivre")
public class AddLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GestionLivre gl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		gl = new GestionLivre();
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
		String nm = request.getParameter("name");
		String au = request.getParameter("auteur");
		int ca = Integer.parseInt(request.getParameter("categorie"));
		gl.AddLivre(nm, ca, au);
		response.sendRedirect("AffLivre.jsp");
	}

}
