package repository;

import java.util.Optional;

import model.Paciente;

public interface PacienteRepository extends CrudDao<Paciente, Integer>{


	
	Optional<Paciente>findByCpf(String CPF);
	
	
	
	
}
