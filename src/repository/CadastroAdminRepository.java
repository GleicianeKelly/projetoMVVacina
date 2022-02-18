package repository;

import java.util.Optional;

import model.CadastroAdmin;

public interface CadastroAdminRepository extends CrudDao<CadastroAdmin, Integer>{

	Optional<CadastroAdmin> findByName(String name);
		
}
