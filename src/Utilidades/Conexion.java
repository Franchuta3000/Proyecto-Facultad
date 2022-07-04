package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import javax.naming.CommunicationException;


public class Conexion {
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private String DB_URL;
	private String USER;
	private String PASS;
	private String baseDato;
	Connection connection;
	
	public Conexion(String USER, String PASS, String baseDato) {
		this.USER = USER;
		this.PASS = PASS;
		this.baseDato = baseDato;
		this.DB_URL = "jdbc:mysql://localhost:3306/base";
	}
	
	public String conectar() throws CommunicationException 
	{
		String respuesta="";
		
		try {
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(this.DB_URL,this.USER,this.PASS);
            if(this.connection != null) 
            {
            	respuesta = "Conectado";
            }
            else 
            {
            	respuesta = "No conectado";
            }
        }catch (ClassNotFoundException e) {
			respuesta="ocurre una ClassNotFoundException : "+e.getMessage();
		}
		catch (SQLSyntaxErrorException e) {
			respuesta="ocurre una SQLSyntaxErrorException: "+e.getMessage()+"\n";
			respuesta+="Verifique que se este usando la base de datos y tablas correctas...";
		}
		catch (SQLException e) {
			respuesta="ocurre una SQLException: "+e.getMessage()+"\n";
			respuesta+="Este es un problema general de SQL, verifique con el administrador";
		}
		
		return respuesta;
	}
	
	public Connection getConnection(){
		return this.connection;
	}
	
	public void desconectar(){
		this.connection = null;
	}
}