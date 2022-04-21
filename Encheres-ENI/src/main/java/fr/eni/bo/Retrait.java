package fr.eni.bo;

public class Retrait {
	private String rue;
	private String code_postal;
	private String ville;
	private int no_retrait;

	public Retrait(String rue, String code_postal, String ville, int no_retrait) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.no_retrait = no_retrait;
	}

	public Retrait(String rue, String code_postal, String ville) {
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public Retrait() {

	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNo_retrait() {
		return no_retrait;
	}

	public void setNo_retrait(int no_retrait) {
		this.no_retrait = no_retrait;
	}

	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + "]";
	}

}
