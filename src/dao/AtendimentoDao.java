package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import mapper.MapperAtendimento;
import model.Atendimento;
import model.Paciente;
import model.Vacina;
import model.exception.DbException;
import repository.AtendimentoRepository;
import utils.Conexao;

public class AtendimentoDao implements AtendimentoRepository{
	
	//O Dao faz toda conex?o com o banco
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;;
	

	//Construtor que faz conn ficar aberta
	public AtendimentoDao() throws ClassNotFoundException, SQLException {
		this.conn = Conexao.db();
	}
	
	
	//M?todo para encontrar todos os registros do banco
	@Override
	public List<Atendimento> findAll() throws ClassNotFoundException {
		List<Atendimento> atendimentoList = new ArrayList<>();
		String url = "select * from atendimento";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.rs = this.stmt.executeQuery();
			while (this.rs.next()) {
				/*
				 * Vou colocar dentro do mapper o resultado da query
				 * e vou pegar l? no mapper as informa??es registradas
				 * no banco que v?o me retonar um objeto que ser? inserido
				 * na lista para ser retornada para meu servlet e  
				 * consequentemente para o servidor.
				 */
				Atendimento atendimento = MapperAtendimento.createAtendimento(rs);
				atendimentoList.add(atendimento);
				
			
			} 
			this.rs.close();
			return atendimentoList;
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} //finally {
			//this.close(this.conn,this.stmt);
		//}
		
	}

	
	/*
	 * M?todo utilizado no mapper pra pegar todos os pacientes por id
	 * e retornar para o findAll
	 */
	@Override
	public Optional<Atendimento> findById(Integer id) throws ClassNotFoundException {
		Optional<Atendimento> atendimentoEncontrado = null;
		String url = "select * from atendimento where id_atendime = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setInt(1, id);
			this.rs = this.stmt.executeQuery();
			if(this.rs.next()) {
				atendimentoEncontrado = Optional.ofNullable(MapperAtendimento.createAtendimento(rs));
				return atendimentoEncontrado;
			}
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
		return null;
	}
	
	//M?todo que altera o atendimento
	@Override
	public void update(Atendimento object) {
		String url = "update atendimento set id_paciente = ?, id_vacina = ?,"
				+ "dt_atendime = ? where id_atendime = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setInt(1, object.getPaciente().getId_paciente());
			this.stmt.setInt(2, object.getVacina().getId_vacina());
			this.stmt.setDate(3, new java.sql.Date(object.getDt_atendimento().getTime()));
			this.stmt.setInt(4, object.getId_atendime());
			int value = this.stmt.executeUpdate();
			if(value == 0) {
				throw new SQLException("erro ao atualizar atendimento");
			}
			System.out.println("Atualizado com sucesso! ");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
			
		}
		
	
	//M?todo para salvar no banco
	@Override
	public void save(Atendimento object) {
		
		String url = "insert into atendimento (id_paciente, id_vacina, dt_atendime)"
				+ "values(?,?,?)";
		try{
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setInt(1, object.getPaciente().getId_paciente());
			this.stmt.setInt(2, object.getVacina().getId_vacina());
			this.stmt.setDate(3, new java.sql.Date(object.getDt_atendimento().getTime()));
			int value = this.stmt.executeUpdate();
			if(value == 0) {
				throw new SQLException("erro ao inserir atendimento");
			}
			System.out.println("Inserido com sucesso! ");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
			}
		
		
		
		
	
	//M?todo pra deletar
	@Override
	public boolean delete(Integer id) {
		String url = "delete from atendimento where id_atendime = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setInt(1, id);
			boolean ok = this.stmt.executeUpdate() > 0;
			if(!ok) {
				throw new SQLException("erro ao deletar atendimento");				
			}
			
			System.out.println("Deletado com sucesso! ");
			return ok;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
		}
	
			}
			
		
		
	

	@Override
	public Optional<Atendimento> findByDate(Date date) throws ClassNotFoundException {
		Optional<Atendimento> dataEncontrada = null;
		String url = "select * from atendimento where dt_atendime = ?";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.stmt.setDate(1, new java.sql.Date(date.getTime()));
			this.rs = this.stmt.executeQuery();
			if(rs.next()) {
				dataEncontrada = Optional.ofNullable(MapperAtendimento.createAtendimento(rs));
				System.out.println("Ok");
				return dataEncontrada;
				
			}
					
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn, this.stmt);
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
	
	
	//testes
	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		AtendimentoDao atendimentoDao = new AtendimentoDao();
		Atendimento atendimento = new Atendimento();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		/*List<Atendimento> listaAtendimento = atendimento.findAll();
		
		listaAtendimento.forEach(a->{System.out.println(a);});*/
		
		/*String data = "2022-01-14";
		Date dataFormatada =  formato.parse(data);
		//System.out.println(atendimento.findById(1));
		System.out.println(atendimento.findByDate(dataFormatada));*/
		
		//atendimento.setId_atendime(1);
		atendimento.setPaciente(new Paciente(1));
		atendimento.setVacina(new Vacina(2));
		atendimento.setDt_atendimento(new java.util.Date());
		
		//atendimentoDao.update(atendimento);
		
		atendimentoDao.save(atendimento);
		
	}

}
