package fr.eni.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.bll.BusinessException;

public interface DAO<T> {
	
	void insert(T var) throws BusinessException, SQLException;
    T selectById(int id) throws BusinessException;
    List<T> selectAll() throws BusinessException;
    void update(T var) throws BusinessException, SQLException;
    void delete(T var) throws BusinessException, SQLException;
}
	
	
	


