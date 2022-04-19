package fr.eni.dal;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;
import fr.eni.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl implements DAOArticleVendu {
	
	
	public void insert(ArticleVendu articleVendu) throws DalException{

        try (Connection cnx = ConnectionProvider.getConnection()){
            String INSERT = "INSERT INTO ARTICLES_VENDUS " +
                    "(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = cnx.prepareStatement(INSERT);
            stmt.setString(1,articleVendu.getNomArticle() );
            stmt.setString(2,articleVendu.getDescription() );
            stmt.setDate(3,Date.valueOf(articleVendu.getDateDebutEncheres()));
            stmt.setDate(4,Date.valueOf(articleVendu.getDateFinEncheres()));
            stmt.setInt(5,articleVendu.getMiseAPrix() );
            stmt.setInt(6,articleVendu.getPrixVente());
            stmt.setString(7,articleVendu.getEtatVente());
            stmt.setInt(8,articleVendu.getUtilisateur().getNoUtilisateur());
            stmt.setInt(9,articleVendu.getCategorie().getNoCategorie());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                articleVendu.setNoArticle(rs.getInt(1));
            }
            
        } catch (SQLException e) {
        	e.printStackTrace();
        	 DalException dalException = new DalException();
             dalException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
             throw dalException;
        }
	}
	
	  public ArticleVendu selectById(int id) throws DalException {
	    
	        ArticleVendu articleVendu = null;
	        try (Connection cnx = ConnectionProvider.getConnection()){
	            String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
	            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
	            stmt.setInt(1, id);
	            stmt.execute();
	            ResultSet rs = stmt.getResultSet();
	            if (rs.next()) {
	                articleVendu = hydrateArticleVendu(rs);
	            }
	           
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        	 DalException dalException = new DalException();
	             dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
	             throw dalException;
	        }
	        return articleVendu;
	    }
	
	
	
	
	
        public List<ArticleVendu> parcategorie(Categorie categorie) throws DalException {
        	
            List<ArticleVendu> articlesVendus = new ArrayList<>();
            try (Connection cnx = ConnectionProvider.getConnection()){
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
               
            } catch (SQLException e) {
                e.printStackTrace();
           	 DalException dalException = new DalException();
             dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
             throw dalException;
            }
            return articlesVendus;
        }
        
        
        public List<Integer> filterByEtat(String etat_vente) throws DalException {
        	
            List<Integer> articlesVendus = new ArrayList<>();
            try (Connection cnx = ConnectionProvider.getConnection()){
                String SELECT_BY_ETAT = "SELECT AV.no_article FROM ARTICLES_VENDUS AV WHERE AV.etat_vente = ?";
                PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ETAT);
                stmt.setString(1, etat_vente);
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    articlesVendus.add(rs.getInt("no_article"));
                }
               
            } catch (SQLException e) {
                e.printStackTrace();
              	 DalException dalException = new DalException();
                dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
                throw dalException;
            }
            return articlesVendus;
        }
        
        public List<Integer> getArticlesFromASellerAndState(Utilisateur utilisateur, String state) throws DalException {
      
            List <Integer> articleVendus = new ArrayList<>();

            String SELECT_BY_SELLER_AND_STATE = "SELECT AV.no_article FROM UTILISATEURS U " +
                    "INNER JOIN ARTICLES_VENDUS AV on U.no_utilisateur = AV.no_utilisateur " +
                    "WHERE U.no_utilisateur = ? AND AV.etat_vente = ?";
            try 	(Connection cnx = ConnectionProvider.getConnection()){
                PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_SELLER_AND_STATE);
                stmt.setInt(1, utilisateur.getNoUtilisateur());
                stmt.setString(2, state);
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    articleVendus.add(rs.getInt("no_article"));
                }
               
            } catch (SQLException e) {
            	  e.printStackTrace();
               	 DalException dalException = new DalException();
                 dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
                 throw dalException;
            }
            return articleVendus;
        }
        
        public List<ArticleVendu> filterByString(String filter) throws DalException {
        	
            List<ArticleVendu> articlesVendus = new ArrayList<>();
            try (Connection cnx = ConnectionProvider.getConnection()){
                String SELECT_BY_NAME_SEARCH = "SELECT * " +
                        "FROM ARTICLES_VENDUS " +
                        "WHERE nom_article LIKE ?";
                PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_NAME_SEARCH);
                stmt.setString(1, "%" + filter + "%");
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while(rs.next()) {
                    articlesVendus.add(hydrateArticleVendu(rs));
                }
             
            } catch (SQLException e) {
            	  e.printStackTrace();
                	 DalException dalException = new DalException();
                  dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
                  throw dalException;
            }
            return articlesVendus;
        }
        
        public List<ArticleVendu> selectAll() throws DalException {
            List<ArticleVendu> articlesVendus = new ArrayList<>();
            try (Connection cnx = ConnectionProvider.getConnection()){
                String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
                PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    articlesVendus.add(hydrateArticleVendu(rs));
                }
            
            } catch (SQLException e) {
            	  e.printStackTrace();
             	 DalException dalException = new DalException();
               dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
               throw dalException; 
            }
            return articlesVendus;
        }

        
public void update(ArticleVendu articleVendu) throws DalException{
    
    try (Connection cnx = ConnectionProvider.getConnection()){
        String UPDATE = "UPDATE ARTICLES_VENDUS SET " +
                "nom_article = ?, " +
                "description = ?, " +
                "date_debut_encheres = ?, " +
                "date_fin_encheres = ?, " +
                "prix_initial = ?, " +
                "prix_vente = ?, " +
                "etat_vente = ?, " +
                "no_utilisateur = ?, " +
                "no_categorie = ? " +
                "WHERE no_article= ?;";
        PreparedStatement stmt = cnx.prepareStatement(UPDATE);
        fillPreparedStatement(articleVendu, stmt);
        stmt.setInt(10, articleVendu.getNoArticle());
        stmt.execute();
        
    } catch (SQLException e) {
    	  e.printStackTrace();
      	 DalException dalException = new DalException();
        dalException.addError(ErrorCodesDAL.ERROR_SQL_UPDATE);
        throw dalException;
    }
}
public void updateCurrentPrice(int noArticle, int newPrice) throws DalException {
    
    try (Connection cnx = ConnectionProvider.getConnection()){
        String UPDATE_CURRENT_PRICE = "UPDATE ARTICLES_VENDUS SET prix_vente = ? WHERE no_article = ?";
        PreparedStatement stmt = cnx.prepareStatement(UPDATE_CURRENT_PRICE);
        stmt.setInt(1, newPrice);
        stmt.setInt(2, noArticle);
        stmt.executeUpdate();
       
    } catch (SQLException e) {
    	  e.printStackTrace();
       	 DalException dalException = new DalException();
         dalException.addError(ErrorCodesDAL.ERROR_SQL_UPDATE);
         throw dalException;
    }
}


        
        public void delete(ArticleVendu articleVendu) throws DalException {
        	
            String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ? ";
            try (Connection cnx = ConnectionProvider.getConnection()){
                PreparedStatement stmt = cnx.prepareStatement(DELETE);
                stmt.setInt(1, articleVendu.getNoArticle());
                stmt.executeUpdate();
              
            } catch (SQLException e) {
                e.printStackTrace();
             	 DalException dalException = new DalException();
               dalException.addError(ErrorCodesDAL.ERROR_SQL_DELETE);
               throw dalException;
            }
        }  
        
        public void fillPreparedStatement(ArticleVendu articleVendu, PreparedStatement stmt) throws DalException {
        	try (Connection cnx = ConnectionProvider.getConnection()){
        	
        	stmt.setString(1, articleVendu.getNomArticle());
            stmt.setString(2, articleVendu.getDescription());
           stmt.setDate(3,Date.valueOf(articleVendu.getDateDebutEncheres()));
            stmt.setDate(4,Date.valueOf(articleVendu.getDateFinEncheres()));
            stmt.setInt(5,articleVendu.getMiseAPrix() );
            stmt.setInt(6, articleVendu.getPrixVente());
            stmt.setString(7, articleVendu.getEtatVente());
            stmt.setInt(8,articleVendu.getUtilisateur().getNoUtilisateur());
            stmt.setInt(9,articleVendu.getCategorie().getNoCategorie());
            
            } catch (SQLException e) {
                e.printStackTrace();
             	 DalException dalException = new DalException();
               dalException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
               throw dalException;
            }
        }  
        	
               	
        private ArticleVendu hydrateArticleVendu(ResultSet rs) throws SQLException {
            return new ArticleVendu(
            );
        
    }

      
        public List<ArticleVendu> filtrerparnom(String filter) throws DalException{
        	 
            List<ArticleVendu> articlesVendus = new ArrayList<>();
            try (Connection cnx = ConnectionProvider.getConnection()){
                String SELECT_BY_NAME_SEARCH = "SELECT * " +
                        "FROM ARTICLES_VENDUS " +
                        "WHERE nom_article LIKE ?";
                PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_NAME_SEARCH);
                stmt.setString(1, "%" + filter + "%");
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while(rs.next()) {
                    articlesVendus.add(hydrateArticleVendu(rs));
                }
               
            } 
                catch (SQLException e) {
            	   e.printStackTrace();
               	 DalException dalException = new DalException();
                 dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
                 throw dalException;
            }
            return articlesVendus;
        }
	
		
		
		
		
	
	
	
	
	
	
}
