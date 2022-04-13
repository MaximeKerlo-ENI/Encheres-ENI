package fr.eni.dal;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;


public abstract class EnchereDAOJdbcImpl implements DAOEnchere {
    public void insert(Enchere enchere) throws BusinessException {
    	 Connection cnx = ConnectionProvider.getConnection();
        try {
            String INSERT = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = cnx.prepareStatement(INSERT);
            stmt.setInt(1, enchere.getNo_utilisateur());
            stmt.setInt(2, enchere.getNo_article());
            stmt.setObject(3, new Timestamp(enchere.getDateEnchère().getTime()));
            stmt.setFloat(4, enchere.getMontant_enchere());
            stmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
            throw dalException;
        }
    }

    /**
     * Return an ArrayList filled by no_articles that matched
     * both a state and a user. i.e. All articles with current auctions for a particular user
     * @param utilisateur Utilisateur The user
     * @param state String The State ("EC", "AN" or "VE")
     * @return ArrayList<Integer> all the id of the articles that matched
     * @throws DALException If there is any issue with the SQL query
     */
    @Override
    public List<Integer> getNoArticlesByUtilisateurAndEtat(Utilisateur utilisateur, String state) throws DALException {
    	Connection cnx = ConnectionProvider.getConnection();
        List <Integer> noArticlesMatched = new ArrayList<>();

        String SELECT_BY_UTILISATEUR_AND_ETAT = "SELECT E.no_article " +
                "FROM ENCHERES E " +
                "INNER JOIN ARTICLES_VENDUS AV on E.no_article = AV.no_article " +
                "WHERE AV.etat_vente = ? AND E.no_utilisateur = ?";
        try {
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_UTILISATEUR_AND_ETAT);
            stmt.setString(1, state);
            stmt.setInt(2, utilisateur.getNoUtilisateur());
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                noArticlesMatched.add(rs.getInt("no_article"));
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new BusinessException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw dalException;
        }

        return noArticlesMatched;
    }

    /**
     * Return an ArrayList filled by no_articles that matched
     * the articles won by an user. SQL is looking for the latest auction made before the end date
     * @param utilisateur Utilisateur The user
     * @return ArrayList<Integer> all the id of the articles that matched
     * @throws DALException If there is any issue with the SQL query
     */
    @Override
    public List<Integer> getNoArticlesWonByUtilisateur(Utilisateur utilisateur) throws BusinessException {
    	Connection cnx = ConnectionProvider.getConnection();
        List<Integer> articlesWonByUtilisateur = new ArrayList<>();
        String SELECT_ARTICLES_WON_BY_USER =
                "SELECT t.no_article FROM ( " +
                "SELECT AV.no_article, E.date_enchere, E.no_utilisateur, " +
                        "row_number() OVER (" +
                        "PARTITION BY AV.no_article " +
                        "ORDER BY datediff(MI, date_enchere, date_fin_encheres)) Ranking " +
                "FROM ENCHERES E " +
                "         INNER JOIN ARTICLES_VENDUS AV on E.no_article = AV.no_article " +
                "WHERE AV.etat_vente = 'VE' AND E.no_utilisateur = ?) t " +
                "WHERE Ranking = 1";
        try {
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ARTICLES_WON_BY_USER);
            stmt.setInt(1, utilisateur.getNoUtilisateur());
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                articlesWonByUtilisateur.add(rs.getInt("no_article"));
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new BusinessException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw dalException;
        }
        return articlesWonByUtilisateur;
    }

    /**
     * Return a couple of values about the current best auction on a particular sale.
     * First value is the amount of the offert
     * Second value is the id of the user that had made the current best auction
     * @param articleVendu The auction that we want to get the best offer
     * @return HashMap<Integer, Integer> <amount, user_id>
     * @throws DALException If there is an issue with the SQL query
     */
    public HashMap<Integer, Integer> getAmountAndPseudoOfBestOffer(ArticleVendu articleVendu) throws BusinessException {
    	Connection cnx = ConnectionProvider.getConnection();
        HashMap<Integer, Integer> result = new HashMap<>();
        try {
            String GET_UTILISATEUR_AND_BEST_AUCTIONS = "SELECT no_utilisateur, " +
                    "       montant_enchere " +
                    "       FROM ( " +
                    "    SELECT AV.no_article, E.date_enchere, E.no_utilisateur, E.montant_enchere, " +
                    "            row_number() OVER ( " +
                    "            PARTITION BY AV.no_utilisateur " +
                    "            ORDER BY datediff(MI, date_enchere, date_fin_encheres)) Ranking " +
                    "    FROM ENCHERES E " +
                    "    INNER JOIN ARTICLES_VENDUS AV on E.no_article = AV.no_article" +
                    "    WHERE AV.no_article = ?) t " +
                    "    WHERE Ranking = 1;";
            PreparedStatement stmt = cnx.prepareStatement(GET_UTILISATEUR_AND_BEST_AUCTIONS);
            stmt.setInt(1, articleVendu.getNoArticle());
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                result.put(rs.getInt("montant_enchere"), rs.getInt("no_utilisateur"));
            } else {
                result = null;
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Connection cnx = ConnectionProvider.getConnection(); 
            BusinessException = new Connection cnx = ConnectionProvider.getConnection();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw BusinessException;
        }
        return result;
    }

    public Enchere selectById(int id) throws BusinessException {
        return null;
    }

    @Override
    public List<Enchere> selectAll() throws BusinessException {
        return null;
    }

    @Override
    public void update(Enchere enchere) throws BusinessException {

    }

    @Override
    public void delete(Enchere enchere) throws DALException {

    }

}