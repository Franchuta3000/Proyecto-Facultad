package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
			String telefono, String email, String contraseña) {
		super(nombre, apellido, fechaNacimiento, dni, domicilio, telefono, email, contraseña);
		// TODO Auto-generated constructor stub
	}

	
	
	public void crearCarrera() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Creaci�n de Carrera-");
		System.out.printf("\nIngresa los datos de la carrera: \n");
		System.out.printf("\n-Nombre de la carrera: ");
		String nombreCarrera = sc.nextLine();
		System.out.printf("\n-Duraci�n de la carrera (use n�meros y letras. "
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
		Connection conexion = cnn.getConnection();
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
	static void crearMateria() {}
	static void crearMesaExamen() {}
	static void generarListadoResultadosExamen() {}
	
}
