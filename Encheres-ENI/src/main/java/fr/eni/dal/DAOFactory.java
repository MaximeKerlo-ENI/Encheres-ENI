package fr.eni.dal;

public abstract class DAOFactory {
	
	public static DAOArticleVendu getDAOArticleVendu() {
		return new ArticleVenduDAOJdbcImpl();}

	public static DAOUtilisateur getDAOUtilisateur() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static DAOCategorie getDAOCategorie() {
		return new CategorieDAOJdbcImpl();
	}
	
	public static DAOEnchere getDAOEnchere() {
		return new EnchereDAOJdbcImpl();
	}
	
	public static DAORetrait getDAORetrait() {
		return new RetraitDAOJdbcImpl();
	
	}	
}

	


