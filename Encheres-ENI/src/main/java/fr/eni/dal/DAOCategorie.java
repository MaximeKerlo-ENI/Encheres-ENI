package fr.eni.dal;


import java.util.List;


import fr.eni.bo.Categorie;

public interface DAOCategorie extends DAO<Categorie>{
	
	void insert(Categorie categorie) throws DalException;
	Categorie selectById(int id) throws DalException ;
	List<Categorie> selectAll() throws  DalException;
	void update(Categorie categorie ) throws DalException;
	void delete(Categorie categorie) throws DalException;

    
    
}