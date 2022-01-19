package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import dao.AtendimentoDao;
import dao.PacienteDao;
import dao.VacinaDao;
import model.Atendimento;
import model.AtendimentoRequest;
import model.Paciente;
import model.Vacina;
import model.exception.DbException;
import repository.AtendimentoRepository;
import repository.PacienteRepository;
import repository.VacinaRepository;

public class AtendimentoService {

	
	private AtendimentoRepository atendimento;
	private PacienteRepository paciente;
	private VacinaRepository vacina;

	public AtendimentoService() throws ClassNotFoundException {
		super();
		this.atendimento = new AtendimentoDao();
		this.paciente = new PacienteDao();
		this.vacina = new VacinaDao();
	}
	
	public void save(AtendimentoRequest object) {
		
		
		Paciente pacienteEncontrado = this.paciente.findByCpf(object.getCpf_paciente()).get();
		Vacina vacinaEncontrada = this.vacina.findByName(object.getNm_vacina()).get();
		Atendimento atendime = new Atendimento();
		atendime.setPaciente(pacienteEncontrado);
		atendime.setVacina(vacinaEncontrada);
		atendime.setDt_atendimento(new java.util.Date());
		this.atendimento.save(atendime);
		
	}
	
	public void update(Atendimento object) {
		atendimento.update(object);
	}
	
	public List<Atendimento> findAll() throws ClassNotFoundException{
		List<Atendimento> listaAtendimento = atendimento.findAll();
		if(listaAtendimento.isEmpty()) {
			throw new DbException("Lista vazia! ");
		}
		return listaAtendimento;
	}
	
	public Atendimento findById(Integer id) throws ClassNotFoundException {
		Optional<Atendimento> atendimentoEncontrado = atendimento.findById(id);
		if(!atendimentoEncontrado.isPresent()) {
			throw new DbException("Atendimento não encontrado! ");
			
		}
		return atendimentoEncontrado.get();
	}
	
	public Atendimento findByDate(Date date) throws ClassNotFoundException {
		Optional<Atendimento> dataEncontrada = atendimento.findByDate(date);
		if(!dataEncontrada.isPresent()) {
			throw new DbException("Data não encontrada! ");
			
		}
		return dataEncontrada.get();
	}
	
	
	public static void main(String[]args) throws ClassNotFoundException {
		AtendimentoService atendimentoService = new AtendimentoService();
		Atendimento atendime = new Atendimento();
		
		atendime.setPaciente(new Paciente(1));
		atendime.setVacina(new Vacina(2));
		atendime.setDt_atendimento(new java.util.Date());
		
		//atendimentoService.save(atendime);
		
	}
	
	
	
	
}
