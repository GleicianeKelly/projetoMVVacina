package model;

import java.util.Date;

public class AtendimentoRequest {

	
	
	
	private String cpf_paciente;
	private String nm_vacina;
	private Date dt_atendime;
	
	
	public AtendimentoRequest() {
		super();
	}


	public AtendimentoRequest(String cpf_paciente, String nm_vacina, Date dt_atendime) {
		super();
		this.cpf_paciente = cpf_paciente;
		this.nm_vacina = nm_vacina;
		this.dt_atendime = dt_atendime;
	}
	
	
	public String getCpf_paciente() {
		return cpf_paciente;
	}
	public void setCpf_paciente(String cpf_paciente) {
		this.cpf_paciente = cpf_paciente;
	}
	public String getNm_vacina() {
		return nm_vacina;
	}
	public void setNm_vacina(String nm_vacina) {
		this.nm_vacina = nm_vacina;
	}
	public Date getDt_atendime() {
		return dt_atendime;
	}
	public void setDt_atendime(Date dt_atendime) {
		this.dt_atendime = dt_atendime;
	}


	@Override
	public String toString() {
		return "AtendimentoRequest [cpf_paciente=" + cpf_paciente + ", nm_vacina=" + nm_vacina + ", dt_atendime="
				+ dt_atendime + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
