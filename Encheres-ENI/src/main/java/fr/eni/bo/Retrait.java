package fr.eni.bo;

public class Retrait {
	private int noRetrait;
	private String rue;
	private String code_postal;
	private String ville;

	public Retrait(int noRetrait, String rue, String code_postal, String ville) {
		this.noRetrait = noRetrait;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public Retrait(String rue, String code_postal, String ville) {
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public Retrait() {

	}

	public int getNoRetrait() {
		return noRetrait;
	}

	public void setNo_retrait(int noRetrait) {
		this.noRetrait = noRetrait;
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

	@Override
	public String toString() {
		return "Retrait [noRetrait=" + noRetrait + ", rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville
				+ "]";
	}
}
