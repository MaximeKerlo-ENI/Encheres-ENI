package fr.eni.dal;

import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;
import fr.eni.bo.Utilisateur;

public interface DAOArticleVendu  {
    List<ArticleVendu> filterByCategory(Categorie categorie) throws BusinessException;
    List<ArticleVendu> filterByString(String filter) throws BusinessException;
    List<Integer> filterByEtat(String etat) throws BusinessException;
    List<Integer> getArticlesFromASellerAndState (Utilisateur utilisateur, String state) throws BusinessException;
    void updateCurrentPrice(int noArticle, int newPrice) throws BusinessException;
}