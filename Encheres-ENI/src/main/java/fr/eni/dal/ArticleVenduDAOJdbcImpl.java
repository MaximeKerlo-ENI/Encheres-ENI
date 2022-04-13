package fr.eni.dal;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;

public abstract class ArticleVenduDAOJdbcImpl implements DAOArticleVendu {
	
	
	public void insert(ArticleVendu articleVendu) throws BusinessException {
		Connection cnx = ConnectionProvider.getConnection();
        try {
            String INSERT = "INSERT INTO ARTICLES_VENDUS " +
                    "(nom_article, description, date_debut_encheres, date_fin_encheres, MiseAPrix, prix_vente, etat_vente, no_utilisateur, no_categorie) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = cnx.prepareStatement(INSERT);
            stmt.setString(1,articleVendu.getNomArticle() );
            stmt.setString(1,articleVendu.getDescription() );
            stmt.setDate(1,articleVendu.getDateDebutEncheres());
            stmt.setDate(1,articleVendu.getDateFinEncheres());
            stmt.setInt(1,articleVendu.getMiseAPrix() );
            stmt.setInt(1,articleVendu.getPrixVente());
            stmt.setBoolean(1,articleVendu.isEtatVente());
            stmt.setUtilisateur(1,articleVendu.getNo_utilisateur());
            stmt.setCategorie(1,articleVendu.getNo_categorie());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                articleVendu.setNoArticle(rs.getInt(1));
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException dalException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
            throw e;
        }
        List<ArticleVendu> parcategorie(Categorie categorie) throws BusinessException {
        	Connection cnx = ConnectionProvider.getConnection();
            List<ArticleVendu> articlesVendus = new ArrayList<>();
            try {
                String SELECT_BY_CATEGORY = "SELECT * " +
                        "FROM ARTICLES_VENDUS " +
                        "INNER JOIN CATEGORIES C on ARTICLES_VENDUS.no_categorie = C.no_categorie " +
                        "WHERE C.no_categorie = ?";
                PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_CATEGORY);
                stmt.setInt(1, categorie.getNoCategorie());
                stmt.execute();
                ResultSet rs =  stmt.getResultSet();
                while (rs.next()) {
                    articlesVendus.add(hydrateArticleVendu(rs));
                }
                cnx.close();
            } catch (SQLException e) {
                e.printStackTrace();
                BusinessException BusinessException = new BusinessException();
                BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
                throw BusinessException;
            }
            return articlesVendus;
        }
        
        public List<Integer> filterByEtat(String etat) throws DALException {
        	Connection cnx = ConnectionProvider.getConnection();
            List<Integer> articlesVendus = new ArrayList<>();
            try {
                String SELECT_BY_ETAT = "SELECT AV.no_article FROM ARTICLES_VENDUS AV WHERE AV.etat_vente = ?";
                PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ETAT);
                stmt.setString(1, etat);
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    articlesVendus.add(rs.getInt("no_article"));
                }
                cnx.close();
            } catch (SQLException e) {
                e.printStackTrace();
                BusinessException BusinessException = new BusinessException();
                BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
                throw BusinessException;
            }
            return articlesVendus;
        }
        
        public List<ArticleVendu> select vendus throws BusinessException {
        	Connection cnx = ConnectionProvider.getConnection();
            List<ArticleVendu> articlesVendus = new ArrayList<>();
            try {
                String SELECT_VENDUS = "SELECT * FROM ARTICLES_VENDUS";
                PreparedStatement stmt = cnx.prepareStatement(SELECT_VENDUS);
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    articlesVendus.add(hydrateArticleVendu(rs));
                }
                cnx.close();
            } catch (SQLException e) {
                e.printStackTrace();
                BusinessException BusinessException = new BusinessException();
                BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
                throw BusinessException;        }
            return articlesVendus;
        }
        
        public void delete(ArticleVendu articleVendu) throws DALException {
        	Connection cnx = ConnectionProvider.getConnection();
            String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ? ";
            try {
                PreparedStatement stmt = cnx.prepareStatement(DELETE);
                stmt.setInt(1, articleVendu.getNoArticle());
                stmt.executeUpdate();
                cnx.close();
            } catch (SQLException e) {
                e.printStackTrace();
                BusinessException BusinessException = new BusinessException();
                BusinessException.addError(ErrorCodesDAL.ERROR_SQL_DELETE);
                throw BusinessException;
            }
        }  
        
        private void fillPreparedStatement(ArticleVendu articleVendu, PreparedStatement stmt) throws SQLException {
            stmt.setString(1, articleVendu.getNomArticle());
            stmt.setString(2, articleVendu.getDescription());
           
            stmt.setObject(3, new Timestamp(articleVendu.getDateDebutEncheres().getTime()));
            stmt.setObject(4, new Timestamp(articleVendu.getDateFinEncheres().getTime()));
            stmt.setInt(5, articleVendu.setMiseAPrix(0));
            stmt.setInt(6, articleVendu.getPrixVente());
            stmt.setBoolean(7, articleVendu.isEtatVente());
            stmt.setInt(8, articleVendu.getNo_utilisateur());
            stmt.setInt(9, articleVendu.getNo_categorie());
        }
        private ArticleVendu hydrateArticleVendu(ResultSet rs) throws SQLException {
            return new ArticleVendu(
            );
        
    }

	
	
	
	
	
}
