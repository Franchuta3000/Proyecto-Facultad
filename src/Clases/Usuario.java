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
	private String contrase�a;
	protected int idUsuario;
	
	static String registrarUsuario(String nombre, String apellido, 
			String fechaNacimiento, int dni, 
			String domicilio, String telefono, String email, String contrase�a) {
		
		
		return "";
	}
	static boolean iniciarSesionUsuario(String email, String contrase�a){
		return true;
	}
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Usuario(String nombre, String apellido, String fechaNacimiento, int dni, 
			String domicilio, String telefono, String email, String contrase�a) {
		super(nombre, apellido, fechaNacimiento, dni, domicilio, telefono);
		// TODO Auto-generated constructor stub
		this.email = email;
		this.contrase�a = contrase�a;
	}
	Conexion cnn = new Conexion("root","Ehdemian2010.$","base");
	public  void registrarUsuario(Connection conexion) 
	{
		Conexion cnn = new Conexion("root","Ehdemian2010.$","base");
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Registrarse-\n");
		System.out.printf("\nIngres� tus datos: \n");
		System.out.printf("\n-Nombre: ");
	String	nombre = sc.nextLine();
		System.out.printf("\n-Apellido: ");
	String	apellido = sc.nextLine();
		System.out.printf("\n-Fecha de nacimiento: ");
	String	fechaNacimiento = sc.nextLine();
		System.out.printf("\n-DNI (Sin puntos ni comas): ");
	int	dni = Integer.parseInt(sc.nextLine());
		System.out.printf("\n-Domicilio: ");
	String	domicilio = sc.nextLine();
		System.out.printf("\n-Direcci�n de email: ");
	String	email = sc.nextLine();
		System.out.printf("\n-N�mero de tel�fono: ");
	String	telefono = sc.nextLine();
		System.out.printf("\n-Contrase�a: ");
	String	contrase�a = sc.nextLine();
		System.out.printf("\n-Confirmar contraseña: ");
		
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
			while(rs.next()) 
			{
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
        	if(response>0) 
        	{
        		System.out.println("se inserto persona correctamente");
        	}
        	
        	sql = "SELECT idUsuario FROM usuario order by idUsuario DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			int idUsuario = 0;
			while(rs.next()) 
			{
				idUsuario = rs.getInt("idUsuario");
			}
        	
			stmt = conexion.prepareStatement("INSERT INTO usuario VALUES (?,?,?,?)");
        	stmt.setInt(1,idUsuario+1);
        	stmt.setInt(2,idpersona+1);
        	stmt.setString(3,email);
        	stmt.setString(4,contrase�a);
        	
        	response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto usuario correctamente");
        	}
		} catch (SQLException sqle){
            System.out.println("SQLState: "+ sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
	}}

