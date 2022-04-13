package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Utilisateur;

/**
 * Classe charger de gérer nos utilisateurs TODO : rajouter une couche DAO pour
 * stocker les utilisateurs dans une base de donnée
 */
public class UserManager {

	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	/**
	 * On initialise la liste des utilisateurs de l'application dans le constructeur
	 */
	public UserManager() {
		Utilisateur user1 = new Utilisateur("cyril", "Pa$$w0rd", false); // idéalement il faudrait crypter le mot de
																			// passe
		Utilisateur user2 = new Utilisateur("admin", "Pa$$w0rd", true); // idéalement il faudrait crypter le mot de
																		// passe

		utilisateurs.add(user1);
		utilisateurs.add(user2);

	}

	/**
	 * findByUsernameAndPassword() cherche si un utilisateur correspond au
	 * username/password donnée en paramètre si non trouvé, retourne null
	 */
	public Utilisateur findByUsernameAndPassword(String username, String password) {
		for (Utilisateur user : utilisateurs) {
			if (user.getPseudo().equals(username) && user.getMotDePasse().equals(password)) {
				return user;
			}
		}
		return null; // on retourne null si non trouvé
	}
}
