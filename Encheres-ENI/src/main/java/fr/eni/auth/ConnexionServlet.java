package fr.eni.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.UserManager;
import fr.eni.bo.Utilisateur;


@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	// reference vers notre userManager
	private UserManager userManager = new UserManager();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/connexion.jsp").forward(request, response);
	}

	/**
	 * doPost() : 
	 * - on recupère le username et le password du formulaire
	 * - on va chercher dans notre base d'utilisateur si un utilisateur correspond
	 * - si on trouve, on ajoute l'utilisateur en session
	 */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1 - on recupère le username et le password du formulaire
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2 - on va chercher dans notre base d'utilisateur si un utilisateur correspond
		Utilisateur utilisateur = userManager.selectPseudoPwd(username, password);
		
		// si jamais utilisateur non trouvé
		if (utilisateur == null) {
			// j'affiche un message d'erreur et je redirige sur le formulaire
			request.setAttribute("erreur", "pseudo ou mot de pase non valide");
			this.doGet(request, response);
		}
		// sinon : on ajoute l'utilisateur en session et on redirige sur la page d'accueil
		else {
			// l'objet HttpSession est le même dans TOUS les servlets de l'application, mais différent pour chaque utilisateur
			HttpSession session = request.getSession();
			session.setAttribute("utilisateurConnecte", utilisateur);
			System.out.println(utilisateur.getPseudo());
			response.sendRedirect("./");
		}
	}
}
