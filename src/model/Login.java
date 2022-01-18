package model;

public class Login {

	
	
	private String nome;
	private String senha;
	
	
	public Login() {
		super();
		this.nome = "mvVacina";
		this.senha = "1234";
	}


	
	
	public boolean logar(String nome, String senha) {
		if(this.nome.equalsIgnoreCase(nome) && this.senha.equalsIgnoreCase(senha)) {
			return true;
		}
		return false;
	}
	
	
}
