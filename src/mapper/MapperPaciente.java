package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Atendimento;
import model.Paciente;
import model.exception.DbException;

public class MapperPaciente {

	
	
	public static Paciente createPaciente(ResultSet rs) {
		Paciente paciente = new Paciente();
		try {
			if(rs != null) {
				paciente.setId_paciente(rs.getInt("id_paciente"));
				paciente.setCpf(rs.getString("cpf_paciente"));
				paciente.setNome_paciente(rs.getString("nome_paciente"));
				paciente.setEndereco(rs.getString("endereco"));
				return paciente;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}
	
	
}
