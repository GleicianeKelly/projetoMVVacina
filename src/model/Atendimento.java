package model;

import java.util.Date;

public class Atendimento {

	
	private Integer id_atendime;
	private Paciente paciente;
	private Vacina vacina;
	private Date dt_atendimento;
	
	
	
	
	
	public Atendimento(Integer id_atendime, Paciente paciente, Date dt_atendimento) {
		super();
		this.id_atendime = id_atendime;
		this.paciente = paciente;
		this.dt_atendimento = dt_atendimento;
	}
	
	
	
	public Atendimento() {
		super();
	}


	public Vacina getVacina() {
		return vacina;
	}



	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}



	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Integer getId_atendime() {
		return id_atendime;
	}
	public void setId_atendime(Integer id_atendime) {
		this.id_atendime = id_atendime;
	}
	
	public Date getDt_atendimento() {
		return dt_atendimento;
	}
	public void setDt_atendimento(Date dt_atendimento) {
		this.dt_atendimento = dt_atendimento;
	}



	@Override
	public String toString() {
		return "\nAtendimento " +
				"\nId atendimento: " + this.getId_atendime()
			   +"\nDados paciente: " 
			   +"\nId paciente: " + this.getPaciente().getId_paciente() 
			   +"\nCpf: " +  this.getPaciente().getCpf() 
			   +"\nNome: " + this.getPaciente().getNome_paciente() 
			   +"\nEndereço: " + this.getPaciente().getEndereco()
			   +"\nDados vacina: " 
			   +"\nId vacina: " + this.getVacina().getId_vacina() 
			   +"\nNome vacina: " + this.getVacina().getNome_vacina()
			   +"\nMarca: " + this.getVacina().getMarca()
			   +"\nData de atendimento: " + this.getDt_atendimento();
			   
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
