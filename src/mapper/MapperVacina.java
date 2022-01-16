package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Paciente;
import model.Vacina;
import model.exception.DbException;

public class MapperVacina {

	

	public static Vacina createVacina(ResultSet rs) {
		Vacina vacina = new Vacina();
		try {
			vacina.setId_vacina(rs.getInt("id_vacina"));
			vacina.setNome_vacina(rs.getString("nome_vacina"));
			vacina.setMarca(rs.getString("marca"));
			return vacina;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}
	
	
	
	
	
	
	
}
