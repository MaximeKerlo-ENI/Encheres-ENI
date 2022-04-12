package fr.eni.dal;

public interface DAOEnchere extends DAO<Enchere> {
    List<Integer> getNoArticlesByUtilisateurAndEtat(Utilisateur utilisateur, String state) throws DALException;
    List<Integer> getNoArticlesWonByUtilisateur(Utilisateur utilisateur) throws DALException;
    HashMap<Integer, Integer> getAmountAndPseudoOfBestOffer(ArticleVendu articleVendu) throws DALException;
}