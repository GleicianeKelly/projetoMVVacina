package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import dao.AtendimentoDao;
import model.Atendimento;
import model.exception.DbException;
import repository.AtendimentoRepository;

public class AtendimentoService {

	
	private AtendimentoRepository atendimento;
	

	public AtendimentoService() throws ClassNotFoundException {
		super();
		this.atendimento = new AtendimentoDao();
	}
	
	public void save(Atendimento object) {
		atendimento.save(object);
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
			throw new DbException("Atendimento n�o encontrado! ");
			
		}
		return atendimentoEncontrado.get();
	}
	
	public Atendimento findByDate(Date date) throws ClassNotFoundException {
		Optional<Atendimento> dataEncontrada = atendimento.findByDate(date);
		if(!dataEncontrada.isPresent()) {
			throw new DbException("Data n�o encontrada! ");
			
		}
		return dataEncontrada.get();
	}
	
	
	public static void main(String[]args) throws ClassNotFoundException {
		AtendimentoService atendimentoService = new AtendimentoService();
		
		System.out.println(atendimentoService.findById(4));
		
	}
	
	
}
