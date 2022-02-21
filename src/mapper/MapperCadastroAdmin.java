package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.CadastroAdmin;
import model.exception.DbException;

public class MapperCadastroAdmin {

	
	
	public static CadastroAdmin MapperCadastroAd(ResultSet rs){
		CadastroAdmin cadastroAdministrador = new CadastroAdmin();
		try {
			if(rs != null) {
				cadastroAdministrador.setCd_usuario(rs.getInt("cd_usuario"));
				cadastroAdministrador.setNome(rs.getString("nome_usuario"));
				cadastroAdministrador.setSenha(rs.getString("senha"));
				return cadastroAdministrador;
			}
			return null;
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
	}
	
	
	
	
	
}
