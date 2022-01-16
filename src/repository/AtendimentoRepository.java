package repository;

import java.sql.Date;
import java.util.Optional;

import model.Atendimento;

public interface AtendimentoRepository extends CrudDao<Atendimento, Integer>{

	
	
	Optional<Atendimento>findByDate(Date date);
	
	
	
	
}
