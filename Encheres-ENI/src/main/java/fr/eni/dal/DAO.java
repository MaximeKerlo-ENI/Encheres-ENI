package fr.eni.dal;

import java.util.List;

import fr.eni.bll.BusinessException;

public interface DAO<T> {
	
	void insert(T var) throws BusinessException;
    T selectById(int id) throws BusinessException;
    List<T> selectAll() throws BusinessException;
    void update(T var) throws BusinessException;
    void delete(T var) throws BusinessException;
}
	
	
	


