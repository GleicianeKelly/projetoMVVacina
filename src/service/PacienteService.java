package service;

import java.util.List;
import java.util.Optional;

import dao.PacienteDao;
import model.Paciente;
import model.exception.DbException;
import repository.PacienteRepository;

public class PacienteService {

	
	
	private PacienteRepository paciente;

	public PacienteService() {
		super();
		this.paciente = new PacienteDao();
	}
	
	public void save(Paciente object) {
		paciente.save(object);
	}
	
	public void update(Paciente object) {
		paciente.update(object);
	}
	
	public List<Paciente> list(){
		List<Paciente> p = paciente.findAll();
		if(p.isEmpty()) {
			throw new DbException("Lista vazia!");	
		}
		return p;
	}
	
	public Paciente findById(int id) {
		Optional<Paciente> pacienteEncontrado = paciente.findById(id);
		if(!pacienteEncontrado.isPresent()) {
			throw new DbException("Paciente não encontrado");	
		}
		return pacienteEncontrado.get();
	}
	
	public Paciente findByCpf(String cpf) {
		Optional<Paciente> pacienteEncontrado = paciente.findByCpf(cpf);
		if(!pacienteEncontrado.isPresent()) {
			throw new DbException("Paciente não encontrado");				
		}
		return pacienteEncontrado.get();
	}
	
	public boolean delete(int id) {
		boolean ok = paciente.delete(id);
		if(!ok) {
			throw new DbException("Paciente não pode ser deletado! ");	
		}
		return ok;
	}
	
}
