package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mapper.MapperVacina;
import model.Vacina;
import model.exception.DbException;
import repository.VacinaRepository;
import utils.Conexao;

public class VacinaDao implements VacinaRepository{

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;;
	


	public VacinaDao() {
		this.conn = Conexao.db();
	}
	
	
	@Override
	public List<Vacina> findAll() {
		List<Vacina> vacinaList = new ArrayList<>();
		String url = "select * from gleice_vacina";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.rs = this.stmt.executeQuery();
			while (this.rs.next()) {
				
				Vacina vacina = MapperVacina.createVacina(rs);
				vacinaList.add(vacina);
				
			
			} 
			this.rs.close();
			return vacinaList;
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
	}

	@Override
	public Optional<Vacina> findById(Integer id) {
		Optional<Vacina> vacina = null;
		String url = "select * from gleice_vacina where id_vacina = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setInt(1, id);
			this.rs = this.stmt.executeQuery();
			if(this.rs.next()) {
				vacina = Optional.ofNullable(MapperVacina.createVacina(rs));
				this.rs.close();
				return vacina;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
		return null;
	}
	
	@Override
	public void update(Vacina object) {
		String url = "update gleice_vacina set nome_vacina = ?, marca = ? where id_vacina = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setString(1, object.getNome_vacina());
			this.stmt.setString(2, object.getMarca());
			this.stmt.setInt(3, object.getId_vacina());
			int value = this.stmt.executeUpdate();
			if(value == 0) {
				throw new SQLException("erro ao salvar paciente");
			
			
			}
			System.out.println("Atualizado com sucesso! ");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
		
	}
	

	@Override
	public void save(Vacina object) {
		String url = "insert into gleice_vacina (nome_vacina, marca) values (?, ?)";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setString(1, object.getNome_vacina());
			this.stmt.setString(2, object.getMarca());
			int values = this.stmt.executeUpdate();
			if(values == 0) {
				throw new SQLException("erro ao salvar paciente");
				
				
			}
			System.out.println("Atualizado com sucesso! ");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
		
	}
			
		

	@Override
	public boolean delete(Integer id) {
		String url = "delete from gleice_vacina where id_vacina = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setInt(1, id);
			boolean ok = this.stmt.executeUpdate() > 0;
			return ok;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
		
	}

	
	@Override
	public Optional<Vacina> findByName(String name) {
		Optional<Vacina> vacina = null;
		String url = "select * from gleice_vacina where nome_vacina = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setString(1, name);
			this.rs = this.stmt.executeQuery();
			if(this.rs.next()) {
				vacina = Optional.ofNullable(MapperVacina.createVacina(rs));
				this.rs.close();
				return vacina;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
		return null;
		
	}

	
	
	

	private void close(Connection c,PreparedStatement s) {

		if (s != null) {
			Conexao.closePreparedStatement(s);
		}
		if (c != null) {
			Conexao.closeConection(c);
		}
	}
	
	public static void main(String[] args) {
		VacinaDao vacinaDao = new VacinaDao();
		
		/*List<Vacina> listaVacina = vacina.findAll();
		listaVacina.forEach(a->{System.out.println(a);});*/
		
		//System.out.println(vacina.findByName("Covid pfizer"));
		//System.out.println(vacina.findById(1));
		
		//System.out.println(vacina.delete(1));
		
		Vacina vacina = new Vacina();
		vacina.setNome_vacina("Antitetânica");;
		vacina.setMarca("kkk");
		//vacina.setId_vacina(1);
		

		vacinaDao.save(vacina);
		
	}


	
	
}
