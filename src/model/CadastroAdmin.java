package model;

public class CadastroAdmin {

	private int cd_usuario;
	private String nome;
	private String senha;
	
	
	public CadastroAdmin(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}
	
	public CadastroAdmin() {
		
	}

	
	public int getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "CadastroAdmin [cd_usuario=" + cd_usuario + ", nome=" + nome + ", senha=" + senha + "]";
	}
	
	
	
	
}
