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
/*
Crear una carrera
Crear una materia asociada a la carrera 
Crear mesas de examen 
Generar listado de resultados de exmenes 
*/
public class Administrador extends Usuario{
	public Administrador(String nombre, String apellido, String fechaNacimiento, int dni, String domicilio,
			String telefono, String email, String contrasena) {
		super(nombre, apellido, fechaNacimiento, dni, domicilio, telefono, email, contrasena);
		
	}

	
	
	public static void crearCarrera() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Creacion de Carrera-");
		System.out.printf("\nIngresa los datos de la carrera: \n");
		System.out.printf("\n-Nombre de la carrera: ");
		String nombreCarrera = sc.nextLine();
		System.out.printf("\n-Duracion de la carrera (use n�meros y letras. "
				+ "Por ejemplo: 5 a�os y medio): ");
		String	duracion = sc.nextLine();
		System.out.printf("\n-Titulo otorgado: ");
		String	tituloOtorgado = sc.nextLine();
		
		
		// Parametros.
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		Conexion cnn;
		
		cnn = new Conexion("root","Ehdemian2010.$","base");
		System.out.println(cnn.conectar());
		
		Connection conexion=cnn.getConnection();
		try {
			//ULTIMO ID REGISTRADO EN LA TABLA
			statement = conexion.createStatement();
			sql = "SELECT idCarrera FROM carrera order by idCarrera DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			int idCarrera = 0;
			while(rs.next()) 
			{
				idCarrera = rs.getInt("idCarrera");
			}
			
			stmt = conexion.prepareStatement("INSERT INTO carrera VALUES (?,?,?,?)");
        	stmt.setInt(1,idCarrera+1);
        	stmt.setString(2,nombreCarrera);
        	stmt.setString(3,duracion);
        	stmt.setString(4,tituloOtorgado);
        	
        	
        	int response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto la carrera correctamente");
        	}
	
		} catch (SQLException sqle){
        System.out.println("SQLState: "+ sqle.getSQLState());
        System.out.println("SQLErrorCode: " + sqle.getErrorCode());
        sqle.printStackTrace();
		}catch (Exception e){
        e.printStackTrace();
		}
	}
	static void crearMateria() throws Exception {
		int idCarrera = Materia.asociarConCarrera();
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Creacion de Materia-");
		System.out.printf("\nIngresa los datos de la materia: \n");
		System.out.printf("\n-Nombre de la Materia: ");
		String nombreMateria = sc.nextLine();
		System.out.printf("\n-Horas catedra:");
		String	horasCatedra = sc.nextLine();
		System.out.printf("\n-Profesor a cargo: ");
		String	nombreProfesor = sc.nextLine();
		
		
		// Parametros.
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		Conexion cnn;
		int idMateria = 0;
		
		cnn = new Conexion("root","Ehdemian2010.$","base");
		System.out.println(cnn.conectar());
		
		Connection conexion=cnn.getConnection();
		try {
			//ULTIMO ID REGISTRADO EN LA TABLA
			statement = conexion.createStatement();
			sql = "SELECT idMateria FROM materias order by idMateria DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			
			while(rs.next()) 
			{
				idMateria = rs.getInt("idMateria");
			}
			
			stmt = conexion.prepareStatement("INSERT INTO materias VALUES (?,?,?,?,?)");
        	stmt.setInt(1,idMateria+1);
        	stmt.setString(2,nombreMateria);
        	stmt.setString(3,horasCatedra);
        	stmt.setString(4,nombreProfesor);
        	stmt.setInt(5,idCarrera);
        	
        	System.out.println(idCarrera+"este numero es el de la carrera");
        	int response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto la materia correctamente");
        	}
	
		} catch (SQLException sqle){
        System.out.println("SQLState: "+ sqle.getSQLState());
        System.out.println("SQLErrorCode: " + sqle.getErrorCode());
        sqle.printStackTrace();
		}catch (Exception e){
        e.printStackTrace();
		}

	}
	public static void crearExamen() throws Exception {
		
		int idMateria = Examen.asociarConMateria();
		
		Scanner	sc= new Scanner(System.in);
		
		System.out.println("Ingrese nombre del examen: ");
		String examen= sc.nextLine();
		System.out.println("Ingrese fecha del examen: ");
		String fecha= sc.nextLine();
		System.out.println("Ingrese inicio del examen: ");
		String inicio= sc.nextLine();
		System.out.println("Ingrese final del examen: ");
		String finalExamen= sc.nextLine();
			Statement statement = null;
			String sql;
			ResultSet rs;
			PreparedStatement stmt;
			Conexion cnn;
			int idExamen = 0;
			
			cnn = new Conexion("root","Ehdemian2010.$","base");
			System.out.println(cnn.conectar());
			
			Connection conexion=cnn.getConnection();
			
			try {
				//ULTIMO ID REGISTRADO EN LA TABLA
				statement = conexion.createStatement();
				sql = "SELECT idMesa_De_Examens FROM mesa_de_examens order by idMesa_De_Examens DESC LIMIT 1;"
						;
				rs = statement.executeQuery(sql);

				while(rs.next()) {
					idExamen = rs.getInt("idMesa_De_Examens");
					
					}			
				stmt = conexion.prepareStatement("INSERT INTO mesa_de_examens VALUES (?,?,?,?,?,?)");
	        	stmt.setInt(1,idExamen+1);
	        	stmt.setInt(2,idMateria);
	        	stmt.setString(3,examen);
	        	stmt.setString(4,fecha);
	        	stmt.setString(5,inicio);
	        	stmt.setString(6,finalExamen);
	        	
	        	
	        	int response = stmt.executeUpdate();
	        	if(response>0) {
	        		System.out.println("se inserto Examen correctamente");
	        	}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	static void generarListadoResultadosExamen() {}
	
}
