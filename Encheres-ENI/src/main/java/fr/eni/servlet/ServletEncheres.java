package fr.eni.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.ArticleManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.dal.DalException;

/**
 * Servlet implementation class ServletNewprofile
 */
@WebServlet("/ServletEncheres")
public class ServletEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleManager articleManager = new ArticleManager();
	private List<ArticleVendu> listeArticle = new ArrayList<ArticleVendu>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEncheres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listeArticle = this.articleManager.selectAll();
			request.setAttribute("listeArticle", listeArticle);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
