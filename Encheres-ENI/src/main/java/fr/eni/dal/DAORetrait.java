package fr.eni.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Retrait;

public interface DAORetrait {

	List<Retrait> selectAll() throws BusinessException;
	void delete(Retrait retrait) throws BusinessException, SQLException;
	void insert(Retrait retrait) throws BusinessException, SQLException;
	
}
