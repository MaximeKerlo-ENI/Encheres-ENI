package fr.eni.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.CategorieManager;
import fr.eni.bll.RetraitManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;
import fr.eni.bo.Retrait;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.DalException;

/**
 * Servlet implementation class ServletProfil
 */
@WebServlet("/ServletVente")
public class ServletVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private CategorieManager categorieManager = new CategorieManager();	
	private RetraitManager retraitManager = new RetraitManager();
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
		HttpSession session = request.getSession();
		
		Categorie categorie = null;
		try {
			categorie = this.categorieManager.selectById(Integer.valueOf(request.getParameter("categorie")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String etat = "";
		LocalDate dateDebut = Date.valueOf(request.getParameter("start")).toLocalDate();
		if(dateDebut.getDayOfYear() > LocalDate.now().getDayOfYear()) {
			etat = "ND";
		}else{
			etat = "EC";
		}
		
		Utilisateur userSession = (Utilisateur) session.getAttribute("utilisateurConnecte");
		
		Retrait retraitInsert = new Retrait(
				request.getParameter("rue"),
				request.getParameter("cpo"),
				request.getParameter("ville")
				);
		
		try {
			this.retraitManager.insert(retraitInsert);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Retrait retraitArticle = null;
		//retraitArticle = this.retraitManager.selectbyId();
		
		ArticleVendu article = new ArticleVendu(
				request.getParameter("nom"),
				request.getParameter("description"),			
				dateDebut,
				Date.valueOf(request.getParameter("end")).toLocalDate(),
				Integer.valueOf(request.getParameter("price")),
				Integer.valueOf(request.getParameter("price")),
				etat,
				userSession,
				categorie,
				retraitInsert
				);
	}

}
