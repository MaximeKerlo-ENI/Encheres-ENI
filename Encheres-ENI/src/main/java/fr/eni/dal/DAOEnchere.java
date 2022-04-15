package fr.eni.dal;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

public interface DAOEnchere extends DAO<Enchere>  {
	void insert(Enchere enchere) throws BusinessException, SQLException;
	List<Integer> getNoArticlesByUtilisateurAndEtat(Utilisateur utilisateur, String etat_vente) throws BusinessException, SQLException;
	List<Integer> getNoArticlesWonByUtilisateur(Utilisateur utilisateur) throws BusinessException, SQLException;
	HashMap<Integer, Integer> getAmountAndPseudoOfBestOffer(ArticleVendu articleVendu) throws BusinessException, SQLException;
	Enchere selectById(int id) throws BusinessException;
	List<Enchere> selectAll() throws BusinessException;
	void update(Enchere enchere) throws BusinessException;
	void delete(Enchere enchere) throws BusinessException;
	
	
   
}