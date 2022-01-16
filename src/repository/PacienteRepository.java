package repository;

import java.util.Optional;

import model.Paciente;

public interface PacienteRepository extends CrudDao<Paciente, Integer>{

									//Vacina representa T
									/*
									 * Integer o K (O que eu passar dentro de <> � o que vai ser recebido
									 * no par�metro do CrudDao
									 */
	
	
	Optional<Paciente>findByCpf(String CPF);
	
	
	
	
}
