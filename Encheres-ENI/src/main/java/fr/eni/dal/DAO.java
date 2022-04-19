package fr.eni.dal;


import java.util.List;



public interface DAO<T> {
	
	void insert(T var) throws  DalException;
    T selectById(int id) throws  DalException;
    List<T> selectAll() throws DalException;
    void update(T var) throws DalException;
    void delete(T var) throws  DalException;
	
}
	
	
	


