package fr.eni.bll;

/**
 * Exception personnalisée qu'on enverra si erreurs de validation
 * L'avantage d'utiliser nos propres exceptions : on sait que le message à l'interieur est compréhensible par l'utilisateur 
 * (et donc on peut l'afficher sans soucis dans nos jsps)
 */
public class BusinessException extends Exception {

	public BusinessException() {
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
