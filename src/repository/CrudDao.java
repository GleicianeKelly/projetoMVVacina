package repository;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T,K> {

	//T representa o objeto que vai referenciar a paciente
	//K representa o id que vou passar que é Integer
	//Classe optional...
	//O pai é o CRUD pois ele que faz a chamada de criar, alterar
	//e deletar no DAO
	List<T> findAll() throws ClassNotFoundException;
	Optional<T>findById(K id) throws ClassNotFoundException;	
	void save(T object);
	boolean delete(K id);
	void update(T object);
	
	
}
