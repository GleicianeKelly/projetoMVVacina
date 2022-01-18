package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.PacienteDao;
import dao.VacinaDao;
import model.Atendimento;
import model.exception.DbException;

public class MapperAtendimento {

	
	
	
	public static Atendimento createAtendimento(ResultSet rs) throws ClassNotFoundException {
		Atendimento atendime = new Atendimento();
		PacienteDao beanPaciente = new PacienteDao();
		VacinaDao beanVacina = new VacinaDao();
		
		try {
			atendime.setId_atendime(rs.getInt("id_atendime"));
			atendime.setPaciente(beanPaciente.findById(rs.getInt("id_paciente")).get());
			atendime.setVacina(beanVacina.findById(rs.getInt("id_vacina")).get());
			atendime.setDt_atendimento(rs.getDate("dt_atendime"));
			return atendime;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}
	
	
	
	
	
}
