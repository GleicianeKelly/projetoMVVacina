package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Atendimento;
import model.exception.DbException;

public class MapperAtendimento {

	
	
	public static Atendimento createAtendimento(ResultSet rs) {
		Atendimento atendime = new Atendimento();
		try {
			atendime.setId_atendime(rs.getInt("id_atendime"));
			atendime.getPaciente().setId_paciente(rs.getInt("id_paciente"));
			atendime.getVacina().setId_vacina(rs.getInt("id_vacina"));
			atendime.setDt_atendimento(rs.getDate("dt_atendimento"));
			//System.out.println(atendime);
			return atendime;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}
	
	
	
	
	
}
