package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;

import mapper.MapperAtendimento;
import model.Atendimento;
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
		
		
		
		
		return null;
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
		// TODO Auto-generated method stub
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
		AtendimentoDao atendimento = new AtendimentoDao();
		
		List<Atendimento> listaAtendimento = atendimento.findAll();
		System.out.println(listaAtendimento);
		listaAtendimento.forEach(a->{System.out.println(a);});
		
	}



	@Override
	public void update(Atendimento object) {
		// TODO Auto-generated method stub
		
	}

}
