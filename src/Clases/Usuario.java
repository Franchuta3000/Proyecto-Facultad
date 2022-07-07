package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import Test.ConexionTest;
import Utilidades.Conexion;


public class Usuario extends Persona{
	private String email;
	private String contraseña;
	protected int idUsuario;
	
	static String registrarUsuario(String nombre, String apellido, 
			String fechaNacimiento, int dni, 
			String domicilio, String telefono, String email, String contraseña) {
		
		
		return "";
	}
	static boolean iniciarSesionUsuario(String email, String contraseña){
		return true;
	}
	
	
	
	
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
	Conexion cnn = new Conexion("root","Ehdemian2010.$","base");
	public  void registrarUsuario(Connection conexion) 
	{				
		
		Scanner sc = new Scanner(System.in);
		System.out.println("#######################");
		System.out.println("Datos del usuario");
		System.out.println("#######################");
		System.out.println("Correo Electronico : ");
		String email = sc.nextLine();
		System.out.println("contraseña");
		String contraseña= sc.nextLine();	
		

		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
	
	
		try {
			
			statement = conexion.createStatement();
			sql = "SELECT idpersona FROM persona order by idpersona DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			int idpersona = 0;
			System.out.println(rs);
			while(rs.next()) 
			{
				idpersona = rs.getInt("idpersona");
			}
			
			stmt = conexion.prepareStatement("INSERT INTO usuario VALUES (?,?,?,?)");
        	stmt.setInt(1,idpersona);
        	stmt.setInt(2,1);
        	stmt.setString(3,email);
        	stmt.setString(4,contraseña);
        	int response = stmt.executeUpdate();
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
	}
}

