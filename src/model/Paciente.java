package model;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

	
	private Integer id_paciente;
	private String cpf;
	private String nome_paciente;
	private String endereco;
	
	
	
	
	public Paciente() {
		super();
	}
	
	public Paciente(Integer id) {
		this.id_paciente = id;
	}
	
	
	public Paciente(Integer id_paciente, String cpf, String nome_paciente, String endereco) {
		super();
		this.id_paciente = id_paciente;
		this.cpf = cpf;
		this.nome_paciente = nome_paciente;
		this.endereco = endereco;
		
	}




	public Integer getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome_paciente() {
		return nome_paciente;
	}
	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	@Override
	public String toString() {
		return "\nPaciente " +
	           "\nId: " + this.getId_paciente() +
	           "\nCPF: " + this.getCpf() +
	           "\nNome: " + this.getNome_paciente() +
	           "\nEndereço: " + this.getEndereco();


	}
	
	
}
