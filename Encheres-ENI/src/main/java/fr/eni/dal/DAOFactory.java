package fr.eni.dal;

import fr.eni.bo.Retrait;

public class DAOFactory {
	
	    public static DAOUtilisateur getDAOUtilisateur() {
	        return new UtilisateurDAOJdbcImpl();
	    }
	    
	    
	    public static DAOArticleVendu getDAOArticleVendu() {
	        return new ArticleVenduDAOJdbcImpl();
	    }
	    public static DAOCategorie getDAOCategorie() {
	        return new CategorieDAOJdbcImpl();
	    }
	   
	    public static DAO<Retrait> getDAORetrait() {
	        return new RetraitDAOJdbcImpl();
	    }


		public static DAOEnchere getEnchereDAO() {
			// TODO Auto-generated method stub
			return null;
		}
	}