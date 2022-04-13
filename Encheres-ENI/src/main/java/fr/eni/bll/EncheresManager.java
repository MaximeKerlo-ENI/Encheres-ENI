package fr.eni.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.bo.Enchere;
import fr.eni.bll.BusinessException;
import fr.eni.dal.DAOEnchere;
import fr.eni.dal.DAOFactory;

/**
 * La couche BLL (ou Metier) sert à : - faire les validations des données
 * (minimum) - si besoin (pas dans notre cas), effectuer les traitements
 * "metiers" lié au fonctionnel
 */

public class EncheresManager {
	// attribut qui contient la référence vers notre couche DAL (ajout base de
	// donnée)
	private DAOEnchere enchereDAO = DAOFactory.getEnchereDAO();

	/**
	 * add(Enchere encheres)
	 * 
	 * @throws BusinessException : ca veut dire que quand on appelle cette méthode,
	 *                           on doit - soit faire un try/catch autour - soit
	 *                           dire que notre méthode peut balancer une exception
	 *                           (ajouter throws BusinessException)
	 */
	public void add(Enchere encheres) throws BusinessException {

		// 1 - je valide les données
		validation(encheres);

		// 2 - j'appelle la couche DAO (EnchereDAO) pour effectuer la création des
		// enchères
		try {
			this.enchereDAO.add(encheres);
		} catch (SQLException e) {
			e.printStackTrace(); // e.printStackTrace(); : ca va afficher en console la pile d'erreur (utile pour
									// debbugage)
			throw new BusinessException("erreur SQL lors de l'insertion en base de donnée");
		}
	}

	/**
	 * Bonne pratique pour valider les informations : on lance une exception
	 * personnalisée si validation non Ok L'exception sera "catchée" dans notre
	 * Servlet pour pouvoir afficher les erreurs associées
	 */
	private void validation(Enchere encheres) throws BusinessException {
		// 1 - on valide que la date est postérieure à la date du jour
		if (encheres.getDateEnchère().isBefore(LocalDate.now())) {
			throw new BusinessException("la date de l'encher doit être égale ou supérieure à la date du jour");
		}

		// 2 - on valide que le repas à au moins 2 aliments
		if (repas.getAliments().size() < 2) {
			throw new BusinessException("le repas doit au moins avoir 2 aliments");
		}

		// etc...
	}

	/**
	 * getAll() : retourne la liste des enchères depuis la couche DAL
	 */
	public List<Enchere> getAll() {
		// TODO Auto-generated method stub
		try {
			return this.enchereDAO.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // si jamais y'a une exception onretournera null
	}

//	public List<String> getIngredients(int idRepas) {
//		// TODO Auto-generated method stub
//		try {
//			return this.enchereDAO.getIngredients(idRepas);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null; // si jamais y'a une exception on retournera null
//	}

}
