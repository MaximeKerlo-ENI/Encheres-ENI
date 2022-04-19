package fr.eni.dal;


import java.util.ArrayList;
import java.util.List;

public class DalException extends Exception {
    private static final long serialVersionUID = 1L;
    private List<Integer> listErrorCodes;
    
    public DalException() {
        super();
        this.listErrorCodes=new ArrayList<>();
    }

  
    public void addError(int code)
    {
        if(!this.listErrorCodes.contains(code))
        {
            this.listErrorCodes.add(code);
        }
    }

    /**
     * Returns true if the instance contains error codes and false if not
     * @return boolean
     */
    public boolean hasErrors()
    {
        return this.listErrorCodes.size()>0;
    }

    /**
     * Returns the list of the error codes stored in the instance
     * @return List
     */
    public List<Integer> getListErrorCodes()
    {
        return this.listErrorCodes;
    }

}
