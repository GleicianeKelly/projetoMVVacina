package model;

public class Vacina {

	
	private Integer id_vacina;
	private String nome_vacina;
	private String marca;
	
	
	
	public Integer getId_vacina() {
		return id_vacina;
	}
	public void setId_vacina(Integer id_vacina) {
		this.id_vacina = id_vacina;
	}
	public String getNome_vacina() {
		return nome_vacina;
	}
	public void setNome_vacina(String nome_vacina) {
		this.nome_vacina = nome_vacina;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "\nVacina " +
			   "\nId " + this.getId_vacina() +
			   "\nNome: " + this.getNome_vacina() + 
			   "\nMarca: " + this.getMarca();
	}
	
	
	
	
}
