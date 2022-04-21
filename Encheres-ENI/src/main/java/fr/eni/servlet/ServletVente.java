package fr.eni.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.CategorieManager;
import fr.eni.bo.Categorie;
import fr.eni.dal.DalException;

/**
 * Servlet implementation class ServletProfil
 */
@WebServlet("/ServletVente")
public class ServletVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private CategorieManager categorieManager = new CategorieManager();	
	private List<Categorie> listeCategorie = new ArrayList<Categorie>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listeCategorie = this.categorieManager.selectAll();
			request.setAttribute("listeCategorie", listeCategorie);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/newVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
