package fr.eni.dal;

import java.util.HashMap;
import java.util.List;


import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

public interface DAOEnchere extends DAO<Enchere>  {
	void insert(Enchere enchere) throws DalException;
	List<Integer> getNoArticlesByUtilisateurAndEtat(Utilisateur utilisateur, String etat_vente) throws DalException;
	List<Integer> getNoArticlesWonByUtilisateur(Utilisateur utilisateur) throws DalException;
	HashMap<Integer, Integer> getAmountAndPseudoOfBestOffer(ArticleVendu articleVendu) throws DalException;
	Enchere selectById(int id) throws DalException;
	List<Enchere> selectAll() throws DalException;
	void update(Enchere enchere) throws  DalException;
	void delete(Enchere enchere) throws  DalException;
	
	
   
}