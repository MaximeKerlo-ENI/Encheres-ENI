package fr.eni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.UserManager;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.DalException;

/**
 * Servlet implementation class ServletProfile
 */
@WebServlet("/ServletProfile")
public class ServletProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserManager userManager = new UserManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/viewProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur userSession = (Utilisateur) session.getAttribute("utilisateurConnecte");
		String delete = request.getParameter("delete");
		try {
			if (delete != null) {
				this.userManager.delete(userSession);
				session.invalidate();
				response.sendRedirect("./");
				return;
			}
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String mdp = "";
		String mdpRecup = request.getParameter("newPwd");
		String mdpConfirm = request.getParameter("confirm-mod");
		if ((mdpRecup != "") && mdpRecup.equals(mdpConfirm)) {
			mdp = mdpRecup;
		} else {
			mdp = request.getParameter("mdp-mod");
		}
		Utilisateur userModif = new Utilisateur(userSession.getNoUtilisateur(), request.getParameter("pseudo-mod"),
				request.getParameter("nom-mod"), request.getParameter("prenom-mod"), request.getParameter("mail-mod"),
				request.getParameter("tel-mod"), request.getParameter("rue-mod"), request.getParameter("cpo-mod"),
				request.getParameter("ville-mod"), mdp, userSession.getCredit(), userSession.getAdministrateur());

		try {
			this.userManager.update(userModif);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("utilisateurConnecte", userModif);
		request.getRequestDispatcher("/").forward(request, response);
	}

}
