package fr.eni.jee.dal;

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
	    public static DAOEnchere getDAOEnchere() {
	        return new EnchereDAOJdbcImpl();
	    }
	    public static DAO<Retrait> getDAORetrait() {
	        return new RetraitDAOJdbcImpl();
	    }
	}