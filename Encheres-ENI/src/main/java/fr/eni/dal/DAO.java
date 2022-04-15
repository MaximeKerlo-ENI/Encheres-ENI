package fr.eni.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.ArticleVendu;

public interface DAO<T> {
	
	void insert(T var) throws BusinessException, SQLException;
    T selectById(int id) throws BusinessException, SQLException;
    List<T> selectAll() throws BusinessException, SQLException;
    void update(T var) throws BusinessException, SQLException;
    void delete(T var) throws BusinessException, SQLException;
	
}
	
	
	


