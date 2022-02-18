package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mapper.MapperCadastroAdmin;
import model.CadastroAdmin;
import model.exception.DbException;
import repository.CadastroAdminRepository;
import utils.Conexao;

public class CadastroAdminDao implements CadastroAdminRepository{
	
	
	private Connection conn = null;
	private PreparedStatement stmt =null;
	private ResultSet rs = null;
	
	public CadastroAdminDao() throws ClassNotFoundException, SQLException {
		this.conn = Conexao.db();
	}

	

	@Override
	public List<CadastroAdmin> findAll() {
		List<CadastroAdmin> cadastroAdmin = new ArrayList<>();
		String sql = "select * from usuario";
		try {
			this.stmt = conn.prepareStatement(sql);
			this.rs = this.stmt.executeQuery();
			while(this.rs.next()) {
				CadastroAdmin CadastroAdministrador = MapperCadastroAdmin.MapperCadastroAd(rs);
				cadastroAdmin.add(CadastroAdministrador);
				
			}
			this.rs.close();
			return cadastroAdmin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
			
		}		
		
		
	

	@Override
	public Optional<CadastroAdmin> findById(Integer id) throws ClassNotFoundException {
		Optional<CadastroAdmin> cadastro = null;
		String sql = "select * from usuario where id = ?";
		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.setInt(1, id);
			this.rs = this.stmt.executeQuery();
			while(this.rs.next());
				 cadastro = Optional.ofNullable(MapperCadastroAdmin.MapperCadastroAd(rs));
				 rs.close();
				 return cadastro;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}

	}

	@Override
	public void save(CadastroAdmin object) {
		String sql = "insert into usuario (nome_usuario,senha) values (?,?)";
		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.setString(1, object.getNome());
			this.stmt.setString(2, object.getSenha());
			int value = this.stmt.executeUpdate();
			if (value == 0) {
				throw new SQLException("erro ao salvar usuário");
			}
			System.out.println("Cadastrado com sucesso! ");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
		
	}
	
	@Override
	public Optional<CadastroAdmin> findByName(String name) {
		Optional<CadastroAdmin> cadastro = null;
		String sql = "select * from usuario where nome_usuario = ?";
		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.setString(1, name);
			this.rs = this.stmt.executeQuery();
			while(this.rs.next()) {
				cadastro = Optional.ofNullable(MapperCadastroAdmin.MapperCadastroAd(rs));
				this.rs.close();
				return cadastro;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
		return null;
		
	}
	
		
	

	@Override
	public boolean delete(Integer id) {
		String sql = "delete * from usuario where id = ?";
		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.setInt(1, id);
			boolean ok = this.stmt.executeUpdate() > 0;
			return ok;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} //finally {
			//this.close(this.conn, this.stmt);
		//}
	}

	@Override
	public void update(CadastroAdmin object) {
		String sql = "update usuario set nome_usuario = ?, senha = ? where cd_usuario = ?";
		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.setString(1, object.getNome());
			this.stmt.setString(2, object.getSenha());
			this.stmt.setInt(3, object.getCd_usuario());
			int value = this.stmt.executeUpdate();
			if(value == 0) {
				throw new SQLException("erro ao editar paciente");
			}
			System.out.println("Atualizado com sucesso! ");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} //finally {
			//this.close(this.conn, this.stmt);
		//}
		
	}

	
	
	private void close(java.sql.Connection conn2, PreparedStatement s) {

		if (s != null) {
			Conexao.closePreparedStatement(s);
		}
		if (conn2 != null) {
			Conexao.closeConection(conn2);
		}
	}
	
	public static void main (String args[]) throws ClassNotFoundException, SQLException{
	
		CadastroAdminDao cadastro = new CadastroAdminDao();
		CadastroAdmin admin = new CadastroAdmin();
		
		admin.setNome("Gleice");
		admin.setSenha("1234");
		
		cadastro.save(admin);
		
	}



	
}
