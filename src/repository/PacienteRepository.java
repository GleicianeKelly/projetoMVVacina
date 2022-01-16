package repository;

import java.util.Optional;

import model.Paciente;

public interface PacienteRepository extends CrudDao<Paciente, Integer>{

									//Vacina representa T
									/*
									 * Integer o K (O que eu passar dentro de <> é o que vai ser recebido
									 * no parâmetro do CrudDao
									 */
	
	
	Optional<Paciente>findByCpf(String CPF);
	
	
	
	
}
