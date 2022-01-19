package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.exception.DbException;


public class Conexao {


		
		
	private final static String url = "jdbc:postgresql://ec2-3-91-128-147.compute-1.amazonaws.com/";
	private final static String banco = "d20vactcjspfj8";
	private final static String usuario = "uldpnmraulscaa";
	private final static String senha = "3ccce9ce53bbc9a86bbd3ab2465b8686538b3f387fb45de1f7a17111878a06d3";
		
		private static Connection conn;

	
		public static Connection db() throws ClassNotFoundException, SQLException {
			conn = null;
			if (conn == null || conn.isClosed()) {
			
				try {
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection(url + banco, usuario, senha);
				} catch (SQLException e) {
					throw new DbException(e.getMessage());
				}
			}
			
			return conn;
		}

		
		public static void closeConection(Connection c) {
	       
			try {
				 if(c == null) {
						c.close();
						conn = null;
				 }
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}


		
		public static void closePreparedStatement(PreparedStatement stmt) {
			try {
				 if(stmt == null) {
						stmt.close();
						conn = null;
				 }
				
				
			} catch (SQLException e) {

				throw new DbException(e.getMessage());
			}
		}
	
		
		public static void main(String...args) throws ClassNotFoundException, SQLException {
			System.out.println(Conexao.db());
		}
	
}
