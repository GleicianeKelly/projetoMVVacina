package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import dao.PacienteDao;
import model.Paciente;
import model.exception.DbException;
import repository.PacienteRepository;
import utils.Metodos;

public class PacienteService {

	private PacienteRepository paciente;

	public PacienteService() throws ClassNotFoundException, SQLException {
		super();
		this.paciente = new PacienteDao();
	}

	public void save(Paciente object) {
		this.paciente.save(object);
	}

	public void update(Paciente object) {
		this.paciente.update(object);
	}

	public List<Paciente> list() throws ClassNotFoundException {
		List<Paciente> p = paciente.findAll();
		if (p.isEmpty()) {
			throw new DbException("Lista vazia!");
		}
		return p;
	}

	public Paciente findById(int id) throws ClassNotFoundException {
		Optional<Paciente> pacienteEncontrado = paciente.findById(id);
		if (!pacienteEncontrado.isPresent()) {
			throw new DbException("Paciente não encontrado");
		}
		return pacienteEncontrado.get();
	}

	public Paciente findByCpf(String cpf) {
		try {
			Metodos encontrarCpf = new Metodos();
		if(encontrarCpf.validarCpf(cpf)) {
			Optional<Paciente> pacienteEncontrado = paciente.findByCpf(cpf);
			if (!pacienteEncontrado.isPresent()) {
				throw new DbException("Paciente não encontrado");
			}
			return pacienteEncontrado.get();
		}
		return null;
		}catch(RuntimeException e) {
			return null;
		}
		
	}

	public boolean delete(int id) {
		boolean ok = paciente.delete(id);
		if (!ok) {
			throw new DbException("Paciente não pode ser deletado! ");
		}
		return ok;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Paciente paciente = new Paciente();
		PacienteService pacienteService = new PacienteService();

		paciente.setCpf("55939260420");
		paciente.setNome_paciente("Marcos");
		paciente.setEndereco("Rua Lauro de Freitas");

		System.out.println(pacienteService.findByCpf("86565936099"));

		// PacienteService pacienteService = new PacienteService();

		// pacienteService.save(paciente);
		
		
		

	}

}
