package service;

import dao.AtendimentoDao;
import repository.AtendimentoRepository;

public class AtendimentoService {

	
	private AtendimentoRepository atendimento;
	

	public AtendimentoService() {
		super();
		this.atendimento = new AtendimentoDao();
	}
	
	
}
