package repository;

import java.util.Optional;

import model.Vacina;

public interface VacinaRepository extends CrudDao<Vacina, Integer>{

	
	Optional<Vacina>findByName(String name);
	
	
}
