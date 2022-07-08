package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.naming.CommunicationException;

import Test.ConexionTest;
import Utilidades.Conexion;


public class Usuario extends Persona{
	private String email;
	private String contraseña;
	protected int idUsuario;
	Conexion cnn; 
	
	static boolean iniciarSesionUsuario(String email, String contraseña){
		return true;
	}
	
	// Getter, setter y Constructor.
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Usuario(String nombre, String apellido, String fechaNacimiento, int dni, 
			String domicilio, String telefono, String email, String contraseña) {
		super(nombre, apellido, fechaNacimiento, dni, domicilio, telefono);
		// TODO Auto-generated constructor stub
		this.email = email;
		this.contraseña = contraseña;
	}	
	
	public String registrarUsuario() 
	{
		String validacion = "error";
		cnn = new Conexion("root","Ehdemian2010.$","base");
		Connection conexion = cnn.getConnection();
		
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		
		try {
			//ULTIMO ID REGISTRADO EN LA TABLA
			statement = conexion.createStatement();
			sql = "SELECT idpersona FROM persona order by idpersona DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			int idpersona = 0;
			while(rs.next()) {
				idpersona = rs.getInt("idpersona");
				}			
			stmt = conexion.prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?)");
        	stmt.setInt(1,idpersona+1);
        	stmt.setString(2,nombre);
        	stmt.setString(3,apellido);
        	stmt.setString(4,fechaNacimiento);
        	stmt.setInt(5,dni);
        	stmt.setString(6,domicilio);
        	stmt.setString(7, telefono);
        	
        	int response = stmt.executeUpdate();
        	if(response>0) {
        		System.out.println("se inserto persona correctamente");
        	}
        	
        	sql = "SELECT idUsuario FROM usuario order by idUsuario DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			int idUsuario = 0;
			while(rs.next()){
				idUsuario = rs.getInt("idUsuario");
			}
        	
			stmt = conexion.prepareStatement("INSERT INTO usuario VALUES (?,?,?,?)");
        	stmt.setInt(1,idUsuario+1);
        	stmt.setInt(2,idpersona+1);
        	stmt.setString(3,email);
        	stmt.setString(4,contraseña);
        	
        	response = stmt.executeUpdate();
        	if(response>0){
        		System.out.println("se inserto usuario correctamente");
        		validacion = "ok";
        	}
		} catch (SQLException sqle){
            System.out.println("SQLState: "+ sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
            
        } catch (Exception e){
            e.printStackTrace();
            validacion = "error1";
        }
		return validacion;
	}
}

