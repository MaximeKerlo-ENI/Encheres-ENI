package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Utilisateur;
import fr.eni.jee.bo.User;

/**
 * Classe charger de gérer nos utilisateurs
 * TODO : rajouter une couche DAO pour stocker les utilisateurs dans une base de donnée
 */
public class UserManager {
	
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	/**
	 * On initialise la liste des utilisateurs de l'application dans le constructeur
	 */
	
	Utilisateur user1 = new Utilisateur("utilisateurBDD", "Pa$$w0rd"); // idéalement il faudrait crypter le mot de passe
		
		
		utilisateurs.add(user1);
		
		
	

	/**
	 * findByUsernameAndPassword()
	 * cherche si un utilisateur correspond au username/password donnée en paramètre
	 * si non trouvé, retourne null
	 */
	public Utilisateur findByUsernameAndPassword(String username, String password) {
		for (Utilisateur user : Utilisateur) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return utilisateurs;
			}
		}
		return null; // on retourne null si non trouvé
	}
}
