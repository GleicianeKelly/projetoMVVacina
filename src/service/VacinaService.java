package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import dao.VacinaDao;
import model.Vacina;
import model.exception.DbException;
import repository.VacinaRepository;

public class VacinaService{

	
	private VacinaRepository vacina;

	public VacinaService() throws ClassNotFoundException, SQLException {
		super();
		this.vacina = new VacinaDao();
	}
	
	
	public void save(Vacina object) {
		vacina.save(object);
	}
	
	public void update(Vacina object) {
		vacina.update(object);
	}
	
	public Vacina findByName(String name) {
		Optional<Vacina> vacinaEncontrada = vacina.findByName(name);
		if(!vacinaEncontrada.isPresent()) {
			throw new DbException("Paciente não encontrada");				
		}
		return vacinaEncontrada.get();
		
	}
	
	public List<Vacina> list() throws ClassNotFoundException{
		List<Vacina> v = vacina.findAll();
		if(v.isEmpty()) {
			throw new DbException("Vacina não encontrado");	
		}
		return v;
	}
	
	public Vacina findById(int id) throws ClassNotFoundException {
		Optional<Vacina> vacinaEncontrada = vacina.findById(id);
		if(!vacinaEncontrada.isPresent()) {
			throw new DbException("Vacina não encontrada");	
		}
		return vacinaEncontrada.get();
		}
	
	
	public boolean delete(int id) {
		boolean ok = vacina.delete(id);
		if(!ok) {
			throw new DbException("Vacina não pode ser deletada! ");
		}
		return ok;
	}
	
	
	}
	
	
