package fr.eni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.UserManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.DAOEnchere;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.DalException;
import fr.eni.messages.Message;

/**
 * Servlet implementation class ServletNewprofile
 */
@WebServlet("/ServletNewProfile")
public class ServletNewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager userManager = new UserManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNewProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/newProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("mail");
		String telephone = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String cpo = request.getParameter("cpo");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("pwd");
		String mdp_confirm = request.getParameter("confirm");
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cpo, ville, mdp, 100, false);
		
		try {
			if(mdp.equals(mdp_confirm)) {
				this.userManager.insert(user);
				request.setAttribute("messageConfirmation", "utilisateur ajouté : " + user);
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("utilisateurConnecte", user);
		request.getRequestDispatcher("./").forward(request, response);
	}
}
