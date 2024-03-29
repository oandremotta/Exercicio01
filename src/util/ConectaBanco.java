package util;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConectaBanco {

	private static String banco ="jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "postgres";
	private static Connection connection = null;
	
	static{
		conectar();
	}
	
	public ConectaBanco() {
		conectar();
	}
	
	private static void conectar(){
		try{
			if(connection ==null){
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false);
			}
			
		}catch(Exception e){
			throw new RuntimeException("erro ao conectar ao banco de dados");
		}
	}
	public static Connection getConnection(){
		return connection;
	}
}
