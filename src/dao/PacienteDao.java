package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mapper.MapperPaciente;
import model.Atendimento;
import model.Paciente;
import model.exception.DbException;
import repository.PacienteRepository;
import utils.Conexao;

public class PacienteDao implements PacienteRepository {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;;

	public PacienteDao() {
		this.conn = Conexao.db();
	}

	@Override
	public List<Paciente> findAll() {
		List<Paciente> pacienteList = new ArrayList<>();
		String url = "select * from gleice_paciente";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.rs = this.stmt.executeQuery();
			while (this.rs.next()) {

				Paciente paciente = MapperPaciente.createPaciente(rs);
				pacienteList.add(paciente);

			}
			this.rs.close();
			return pacienteList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}

	}

	@Override
	public Optional<Paciente> findById(Integer id) {
		Optional<Paciente> paciente = null;
		String url = "select * from gleice_paciente where id_paciente = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setInt(1, id);
			this.rs = this.stmt.executeQuery();
			if (this.rs.next()) {
				paciente = Optional.ofNullable(MapperPaciente.createPaciente(rs));
				rs.close();
				return paciente;
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
		return null;

	}

	/**
	 * 
	 */
	@Override
	public void update(Paciente object) {
		String url = "update gleice_paciente set cpf_paciente = ?, nome_paciente = ?, "
				+ "endereco = ? where id_paciente = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setString(1, object.getCpf());
			this.stmt.setString(2, object.getNome_paciente());
			this.stmt.setString(3, object.getEndereco());
			this.stmt.setInt(4, object.getId_paciente());
			int value = this.stmt.executeUpdate();
			if (value == 0) {
				throw new SQLException("erro ao salvar paciente");
			}
			System.out.println("Atualizado com sucesso! ");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
	}

	@Override
	public void save(Paciente object) {
		String url = "insert into gleice_paciente (cpf_paciente, nome_paciente, endereco) values(?,?,?)";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setString(1, object.getCpf());
			this.stmt.setString(2, object.getNome_paciente());
			this.stmt.setString(3, object.getEndereco());
			int value = this.stmt.executeUpdate();
			if (value == 0) {
				throw new SQLException("erro ao salvar paciente");
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
	public boolean delete(Integer id) {
		String url = "delete from gleice_paciente where id_paciente = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setInt(1, id);
			boolean ok = this.stmt.executeUpdate() > 0;
			return ok;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}

	}

	@Override
	public Optional<Paciente> findByCpf(String CPF) {
		Optional<Paciente> paciente = null;
		String url = "select * from gleice_paciente where cpf_paciente = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setString(1, CPF);
			this.rs = this.stmt.executeQuery();
			if (this.rs.next()) {
				paciente = Optional.ofNullable(MapperPaciente.createPaciente(rs));
				rs.close();
				return paciente;
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
		return null;

	}

	private void close(Connection c, PreparedStatement s) {

		if (s != null) {
			Conexao.closePreparedStatement(s);
		}
		if (c != null) {
			Conexao.closeConection(c);
		}
	}

	public static void main(String[] args) {
		PacienteDao pacienteDao = new PacienteDao();

		/*
		 * List<Paciente> listaPaciente = paciente.findAll();
		 * listaPaciente.forEach(a->{System.out.println(a);});
		 */

		/* System.out.println(paciente.findById(2)); */

		/* System.out.println(paciente.findByCpf("08745090416")); */

		Paciente paciente = new Paciente();

		paciente.setCpf("08745090416");
		paciente.setNome_paciente("Mariah Carey");
		paciente.setEndereco("Rua vila pedrosa");
		// paciente.setId_paciente(2);

		pacienteDao.save(paciente);

	}


}
