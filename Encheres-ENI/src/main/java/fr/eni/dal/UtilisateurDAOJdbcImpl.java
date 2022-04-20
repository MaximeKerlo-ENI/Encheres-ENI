package fr.eni.dal;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements DAOUtilisateur {

   /*insert(Utilisateur utilisateur) : requete qui permet d'inserer un utilisateur
    * Utilisateur selectPseudoPwd(String pseudo, String password): requete qui selectionne par pseudo avec leur mot de passe
    * HashMap<Integer, String> selectUtilisateursWithCurrentAuction() : requete qui permet de selectionner un utilisateur en action
    * List<Utilisateur> selectAll(): requete qui selectionne tous les utilisateurs
    * updateCredit(int noUtilisateur, int newCredit): requete qui permet de mettre a jour le credit d'un utilisateur
    * delete(Utilisateur utilisateur) : requete qui permet de supprimer un utilisateur
    * checkForUniquePseudoAndMail(String pseudo, String mail): requete qui permet de verifier si le pseudo et le mail est unique
    */
    public void insert(Utilisateur utilisateur) throws DalException{
        
        try (Connection cnx = ConnectionProvider.getConnection()){
            String INSERT = "INSERT INTO UTILISATEURS " +
                    "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pStmt = cnx.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, utilisateur.getPseudo());
            pStmt.setString(2,utilisateur.getNom());
            pStmt.setString(3, utilisateur.getPrenom());
            pStmt.setString(4,utilisateur.getEmail());
            pStmt.setString(5, utilisateur.getTelephone());
            pStmt.setString(6, utilisateur.getRue());
            pStmt.setString(7, utilisateur.getCodePostal());
            pStmt.setString(8,utilisateur.getVille());
            pStmt.setString(9,utilisateur.getMotDePasse());
            pStmt.setInt(10,utilisateur.getCredit());
            pStmt.setBoolean(11,utilisateur.getAdministrateur());
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                utilisateur.setNoUtilisateur(rs.getInt(1));
                
               
            }
           
        } catch (SQLException e) {
        	  e.printStackTrace();
              DalException dalException = new DalException();
              dalException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
              throw dalException;
        }
    }

  
    
    
	public Utilisateur selectPseudoPwd(String pseudo, String password) throws DalException {
    	
        Utilisateur utilisateur = null;
        try (Connection cnx = ConnectionProvider.getConnection()){
            String SELECTPseudoPwd = "SELECT * FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?";
            		
            	
            PreparedStatement stmt = cnx.prepareStatement(SELECTPseudoPwd);
            stmt.setString(1, pseudo);
            
          stmt.setString(2, password);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
           
            if (rs.next()) {
                utilisateur = hydrateUtilisateur(rs);
            }
            
        	} catch (SQLException e) {
        		 e.printStackTrace();
                 DalException dalException = new DalException();
                 dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
                 throw dalException;
        }
        return utilisateur;
    }

    /**
     * Extract all users that have currently an auction and returns only their names
     * Purpose of this query is to display the names of the sellers on homepage
     * @return An ArrayList, index are for no_article and values are Strings with pseudo
     * @throws SQLException 
     * @throws DALException if the SQL SELECT request is wrong
     */
    public HashMap<Integer, String> selectUtilisateursWithCurrentAuction() throws DalException {
    
        HashMap<Integer, String> pseudos = new HashMap<> ();
        try (Connection cnx = ConnectionProvider.getConnection()){
            String SELECT_USERS_WITH_CURRENT_AUCTIONS =
                    "SELECT AV.no_article, pseudo " +
                    "FROM UTILISATEURS " +
                    "INNER JOIN ARTICLES_VENDUS AV on UTILISATEURS.no_utilisateur = AV.no_utilisateur ";
            Statement stmt = cnx.createStatement();
            stmt.execute(SELECT_USERS_WITH_CURRENT_AUCTIONS);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                pseudos.put(rs.getInt("no_article"), rs.getString("pseudo"));
            }
            
        } catch (SQLException e) {
        	 e.printStackTrace();
             DalException dalException = new DalException();
             dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
             throw dalException;
        }
        return pseudos;
    }

    /**
     * Select all the utilisateurs from the DB
     * @return An ArrayList filled with instances of Utilisateur
     * @throws BusinessException 
     * @throws SQLException 
     */
    
   // @Override
    public List<Utilisateur> selectAll() throws DalException   {
    	
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection()){
            Statement stmt = cnx.createStatement();
            String SELECT_ALL = "SELECT * FROM UTILISATEURS";
            stmt.execute(SELECT_ALL);
            ResultSet rs = stmt.getResultSet();
            
        } catch (SQLException e) {
        	e.printStackTrace();
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw dalException;
        }
        return utilisateurs;
    }
    /**
     * Update to the db from an instance of Utilisateur
     * @param utilisateur Utilisateur the instance filled with informations to update
     */
 

   
    public void updateCredit(int noUtilisateur, int newCredit) throws DalException {
    	
        try (Connection cnx = ConnectionProvider.getConnection()){
            String UPDATE_CREDIT = "UPDATE UTILISATEURS SET credit = ? WHERE no_utilisateur = ?";
            PreparedStatement stmt = cnx.prepareStatement(UPDATE_CREDIT);
            stmt.setInt(1, newCredit);
            stmt.setInt(2, noUtilisateur);
            stmt.executeUpdate();
           
        } catch (SQLException e) {
        	e.printStackTrace();
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_UPDATE);
            throw dalException;
        }
    }

    /**
     * Delete from the db from an instance of Utilisateur
     * @param utilisateur Utilisateur the instance filled with the noUtilisateur to delete
     * @throws SQLException 
     */
    public void delete(Utilisateur utilisateur) throws DalException{
    	
        try (Connection cnx = ConnectionProvider.getConnection()){
            String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?;" ;
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, utilisateur.getNoUtilisateur());
            stmt.setString(2, utilisateur.getPseudo());
            stmt.executeUpdate();
          
        } catch (SQLException e) {
        	e.printStackTrace();
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_DELETE);
            throw dalException;
        }
    }

    

    public Utilisateur hydrateUtilisateur(ResultSet rs) throws DalException{
        try {
			return new Utilisateur(
			        rs.getInt("no_utilisateur"),
			        rs.getString("pseudo"),
			        rs.getString("nom"),
			        rs.getString("prenom"),
			        rs.getString("email"),
			        rs.getString("telephone"),
			        rs.getString("rue"),
			        rs.getString("code_postal"),
			        rs.getString("ville"),
			        rs.getString("mot_de_passe"),
			        rs.getInt("credit"),
			        rs.getBoolean("administrateur")
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw dalException;
		}
    }

  

  
    public boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws DalException {
    	
        boolean isUnique = true;
        try (Connection cnx = ConnectionProvider.getConnection()){
            String CHECK_IF_PSEUDO_AND_MAIL_ALREADY_EXIST =
                    "SELECT * FROM UTILISATEURS " +
                    "WHERE pseudo LIKE ? OR email LIKE ?;";
            PreparedStatement stmt = cnx.prepareStatement(CHECK_IF_PSEUDO_AND_MAIL_ALREADY_EXIST);
            stmt.setString(1, pseudo);
            stmt.setString(2, pseudo);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                isUnique = false;
            }
           
        } catch (SQLException e) {
        	e.printStackTrace();
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw dalException;
        }
        return isUnique;
    }

    /**
     * Check in the Database is a pseudo and a mail adress all already takeen
     * @param pseudo String The mail
     * @return boolean true if the pseudo and the mail are free and false if not
     * @throws SQLException 
     * @throws DALException If the SQL request is wrong
     */
    public boolean checkForUniquePseudo(String pseudo) throws DalException {
    	
        boolean isUnique = true;
        try(Connection cnx = ConnectionProvider.getConnection()) {
            String CHECK_IF_PSEUDO_ALREADY_EXIST =
                    "SELECT * FROM UTILISATEURS " +
                            "WHERE pseudo LIKE ?;";
            PreparedStatement stmt = cnx.prepareStatement(CHECK_IF_PSEUDO_ALREADY_EXIST);
            stmt.setString(1, pseudo);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                isUnique = false;
            }
            
        } catch (SQLException e) {
        	e.printStackTrace();
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw dalException;
        }
        return isUnique;
    }

    /**
     * Check in the Database is a pseudo and a mail adress all already takeen
     * @param mail String The mail
     * @return boolean true if the pseudo and the mail are free and false if not
     * @throws SQLException 
     * @throws DALException If the SQL request is wrong
     */
  

    @Override
    public void update(Utilisateur utilisateur) throws DalException{
    	
        try (Connection cnx = ConnectionProvider.getConnection()){
            String UPDATE = "UPDATE UTILISATEURS SET " +
                    "                        pseudo = ?, " +
                    "                        nom = ?, " +
                    "                        prenom = ?, " +
                    "                        email = ?, " +
                    "                        telephone = ?, " +
                    "                        rue = ?, " +
                    "                        code_postal = ?, " +
                    "                        ville = ?,"+
                    "						mot_de_passe=?"+
                    "						WHERE no_utilisateur = ?";
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);
              fillPreparedStatement(utilisateur, stmt);
            stmt.setInt(10, utilisateur.getNoUtilisateur());
            stmt.executeUpdate();
           
        } catch (SQLException e) {
        	e.printStackTrace();
            DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_UPDATE);
            throw dalException;
        }
    }




		  public void fillPreparedStatement(Utilisateur utilisateur, PreparedStatement stmt) throws SQLException {
		        stmt.setString(1, utilisateur.getPseudo());
		        stmt.setString(2, utilisateur.getNom());
		        stmt.setString(3, utilisateur.getPrenom());
		        stmt.setString(4, utilisateur.getEmail());
		        stmt.setString(5, utilisateur.getTelephone());
		        stmt.setString(6, utilisateur.getRue());
		        stmt.setString(7, utilisateur.getCodePostal());
		        stmt.setString(8, utilisateur.getVille());
		        stmt.setString(8, utilisateur.getMotDePasse());
		      
		    }



		  public Utilisateur selectlesId(int no_utilisateur) throws DalException {
			  
		        Utilisateur utilisateur = null;
		        try (Connection cnx = ConnectionProvider.getConnection()){
		            String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
		            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
		            stmt.setInt(1, no_utilisateur);
		            stmt.execute();
		            ResultSet rs = stmt.getResultSet();
		            if (rs.next()) {
		                utilisateur = hydrateUtilisateur(rs);
		            }
		           
		        } catch (SQLException e) {
		        	e.printStackTrace();
		            DalException dalException = new DalException();
		            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
		            throw dalException;
		        }
		        return utilisateur;
		    }



		public Utilisateur selectById(int id) throws DalException {
			 
		        Utilisateur utilisateur = null;
		        try (Connection cnx = ConnectionProvider.getConnection()){
		            String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
		            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
		            stmt.setInt(1, id);
		            stmt.execute();
		            ResultSet rs = stmt.getResultSet();
		            if (rs.next()) {
		                utilisateur = hydrateUtilisateur(rs);
		            }
		           
		        } catch (SQLException e) {
		        	e.printStackTrace();
		            DalException dalException = new DalException();
		            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
		            throw dalException;
		        }
		        return utilisateur;
		    }
		
	}
	

		
	


