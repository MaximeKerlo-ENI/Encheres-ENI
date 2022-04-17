package fr.eni.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.ArticleVendu;

public interface DAO<T> {
	
	void insert(T var) throws  DalException;
    T selectById(int id) throws  DalException;
    List<T> selectAll() throws DalException;
    void update(T var) throws DalException;
    void delete(T var) throws  DalException;
	
}
	
	
	


