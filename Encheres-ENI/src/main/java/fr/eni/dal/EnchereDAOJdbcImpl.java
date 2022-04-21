package fr.eni.dal;


import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;


import fr.eni.bo.ArticleVendu;

import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;


public class EnchereDAOJdbcImpl implements DAOEnchere {
	/*insert(Enchere enchere) : requete qui permet d'inserer des encheres
	 * List<Integer> getNoArticlesByUtilisateurAndEtat(Utilisateur utilisateur, String etat_vente): liste des articles par utilisateur et par etat de vente
	 * List<Integer> getNoArticlesWonByUtilisateur(Utilisateur utilisateur): liste des articles gagnes par utilisateurs
	 * HashMap<Integer, Integer> getAmountAndPseudoOfBestOffer(ArticleVendu articleVendu): hashmap en java permet de retrouver rapidement un element existant
	 * 
	 */
	
	
	
	
	
    public void insert(Enchere enchere) throws DalException {
    	
        try (Connection cnx = ConnectionProvider.getConnection()){
            String INSERT = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = cnx.prepareStatement(INSERT);
            stmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
            stmt.setInt(2, enchere.getArticle().getNoArticle());
            stmt.setDate(3,Date.valueOf(enchere.getDateEnchere()));
            stmt.setFloat(4, enchere.getMontant_enchere());
            stmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
            throw dalException;
        }
    }

   
    
    public List<Integer> getNoArticlesByUtilisateurAndEtat(Utilisateur utilisateur, String etat_vente) throws DalException {
    
        List <Integer> noArticlesMatched = new ArrayList<>();

        String SELECT_BY_UTILISATEUR_AND_ETAT = "SELECT E.no_article " +
                "FROM ENCHERES E " +
                "INNER JOIN ARTICLES_VENDUS AV on E.no_article = AV.no_article " +
                "WHERE AV.etat_vente = ? AND E.no_utilisateur = ?";
        try (Connection cnx = ConnectionProvider.getConnection()){
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_UTILISATEUR_AND_ETAT);
            stmt.setString(1, etat_vente);
            stmt.setInt(2, utilisateur.getNoUtilisateur());
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                noArticlesMatched.add(rs.getInt("no_article"));
            }
           
        } catch (SQLException e) {
        	 e.printStackTrace();
             DalException dalException = new DalException();
             dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
             throw dalException;
        }

        return noArticlesMatched;
    }




    public List<Integer> getNoArticlesWonByUtilisateur(Utilisateur utilisateur) throws DalException{
    	
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
        try (Connection cnx = ConnectionProvider.getConnection()){
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ARTICLES_WON_BY_USER);
            stmt.setInt(1, utilisateur.getNoUtilisateur());
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                articlesWonByUtilisateur.add(rs.getInt("no_article"));
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw dalException;
        }
        return articlesWonByUtilisateur;
    }


    public HashMap<Integer, Integer> getAmountAndPseudoOfBestOffer(ArticleVendu articleVendu) throws DalException  {
    	
        HashMap<Integer, Integer> result = new HashMap<>();
        
        try (Connection cnx = ConnectionProvider.getConnection()){
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
            
        } catch (SQLException e) {
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw dalException;
        }
        return result;
    }

    public Enchere selectById(int id) throws DalException  {
    	
        return null;
    }

   
	public List<Enchere> selectAll() throws DalException {
		List<Enchere> result = new ArrayList<Enchere>();
	
		try (Connection cnx = ConnectionProvider.getConnection()) {
			ArrayList<Enchere> listEnchere = new ArrayList<Enchere>();
			String LISTER = "select * from ENCHERES";
		
			 PreparedStatement stmt = cnx.prepareStatement(LISTER);
			
					 stmt.execute();
	            ResultSet rs = stmt.getResultSet();
					
					}
					
		 catch (SQLException e) {
			DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw dalException;
		}
		return result;
	}


	@Override
	public void update(Enchere enchere) throws DalException {
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			String UPDATE = "UPDATE ENCHERES SET no_utilisateur =?,no_article=?,date_enchere=?, montant_enchere=? WHERE no_article=?";
			PreparedStatement stmt = cnx.prepareStatement(UPDATE);
			stmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			stmt.setInt(2, enchere.getArticle().getNoArticle());
			stmt.setDate(3,Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(4, enchere.getMontant_enchere());
			stmt.setInt(5, enchere.getArticle().getNoArticle());
			stmt.executeUpdate();

		} catch (SQLException e) {
			DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_UPDATE);
            throw dalException;
		}

	}


	@Override
	public void delete(Enchere enchere) throws DalException {
		try (Connection con = ConnectionProvider.getConnection()) {
			String DELETE = "DELETE FROM ENCHERES WHERE no_utilisateur =? and no_article =?";
		
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			stmt.setInt(2, enchere.getArticle().getNoArticle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_DELETE);
            throw dalException;
		}
	}
	
		public List<Enchere> selectByUser(Enchere enchere, Utilisateur utilisateur) throws DalException{
			
			List<Enchere> listEnchere = new ArrayList<Enchere>();
			
			try(Connection cnx = ConnectionProvider.getConnection()) {
				String SELECTBYUSER = "select * from ENCHERES where no_utilisateur=?";
				PreparedStatement stmt = cnx.prepareStatement(SELECTBYUSER);
				stmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
					
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
					listEnchere.add( rs.getInt("no_utilisateur"), enchere);
					
				}				
			}        
				
			catch(Exception e) {
				DalException dalException = new DalException();
	            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
	            throw dalException;
			}
			return listEnchere;
		}
		
		
		
		
		
	
	}


