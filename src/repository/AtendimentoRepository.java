package repository;

import java.util.Date;
import java.util.Optional;


import model.Atendimento;

public interface AtendimentoRepository extends CrudDao<Atendimento, Integer>{

	
	
	Optional<Atendimento>findByDate(Date date);
	
	
	
	
}
