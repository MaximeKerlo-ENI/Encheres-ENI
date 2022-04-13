package fr.eni.dal;

import java.util.HashMap;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Utilisateur;

public interface DAOEnchere  {
    List<Integer> getNoArticlesByUtilisateurAndEtat(Utilisateur utilisateur, String state) throws BusinessException;
    List<Integer> getNoArticlesWonByUtilisateur(Utilisateur utilisateur) throws BusinessException;
    HashMap<Integer, Integer> getAmountAndPseudoOfBestOffer(ArticleVendu articleVendu) throws BusinessException;
}