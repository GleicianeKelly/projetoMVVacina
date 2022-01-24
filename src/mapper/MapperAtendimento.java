package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.PacienteDao;
import dao.VacinaDao;
import model.Atendimento;
import model.exception.DbException;

public class MapperAtendimento {

	
	
	/*
	 * Para paciente e vacina, chama o método que busca o id, passa
	 * o id da query pra dentro do método que retorna o objeto pra
	 * dentro do atributo
	 */
	
	public static Atendimento createAtendimento(ResultSet rs) throws ClassNotFoundException, SQLException {
		Atendimento atendime = new Atendimento();
		PacienteDao pacienteDao = new PacienteDao();
		VacinaDao vacinaDao = new VacinaDao();
		
		try {
			atendime.setId_atendime(rs.getInt("id_atendime"));
			atendime.setPaciente(pacienteDao.findById(rs.getInt("id_paciente")).get());
			atendime.setVacina(vacinaDao.findById(rs.getInt("id_vacina")).get());
			atendime.setDt_atendimento(rs.getDate("dt_atendime"));
			return atendime;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}
	
	
	
	
}
