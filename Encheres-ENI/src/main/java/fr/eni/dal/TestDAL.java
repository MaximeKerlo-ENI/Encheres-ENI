package fr.eni.dal;

import fr.eni.bo.ArticleVendu;

public class TestDAL {

	public static void main(String[] args) {
		
		ArticleVenduDAOJdbcImpl dao = new ArticleVenduDAOJdbcImpl();
		
	
try {
			dao.selectAll().forEach(article -> {
				System.out.println(article);
				
			});
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
