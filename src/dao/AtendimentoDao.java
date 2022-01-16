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
	
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;;
	

	
	public AtendimentoDao() {
		this.conn = Conexao.db();
	}
	
	
	
	@Override
	public List<Atendimento> findAll() {
		List<Atendimento> atendimentoList = new ArrayList<>();
		String url = "select * from atendimento";
		try {
			this.stmt = this.conn.prepareStatement(url);
			this.rs = this.stmt.executeQuery();
			while (this.rs.next()) {
				
				Atendimento atendimento = MapperAtendimento.createAtendimento(rs);
				atendimentoList.add(atendimento);
				
			
			} 
			this.rs.close();
			return atendimentoList;
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
		
	}

	@Override
	public Optional<Atendimento> findById(Integer id) {
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
	public void save(Atendimento object) {
		
		
		
		
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Atendimento> findByDate(Date date) {
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
	
	public static void main(String[] args) throws ParseException {
		AtendimentoDao atendimentoDao = new AtendimentoDao();
		Atendimento atendimento = new Atendimento();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		/*List<Atendimento> listaAtendimento = atendimento.findAll();
		
		listaAtendimento.forEach(a->{System.out.println(a);});*/
		
		/*String data = "2022-01-14";
		Date dataFormatada =  formato.parse(data);
		//System.out.println(atendimento.findById(1));
		System.out.println(atendimento.findByDate(dataFormatada));*/
		
		atendimento.setId_atendime(1);
		atendimento.setPaciente(new Paciente(2));
		atendimento.setVacina(new Vacina(2));
		atendimento.setDt_atendimento(new java.util.Date());
		
		atendimentoDao.update(atendimento);
		
	}

}
