package fr.eni.dal;

public interface DAOArticleVendu extends DAO<ArticleVendu> {
    List<ArticleVendu> filterByCategory(Categorie categorie) throws DALException;
    List<ArticleVendu> filterByString(String filter) throws DALException;
    List<Integer> filterByEtat(String etat) throws DALException;
    List<Integer> getArticlesFromASellerAndState (Utilisateur utilisateur, String state) throws DALException;
    void updateCurrentPrice(int noArticle, int newPrice) throws DALException;
}