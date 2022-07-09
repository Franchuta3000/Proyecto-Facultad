package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.naming.CommunicationException;

import Utilidades.Conexion;

/*
Inscripcion a carrera
Inscripcion a examen
Generar un certificado de Alumno Regular ¼
Baja de una mesa de examen ¼
Ver  Historial académico ¼
 */
public class Estudiante extends Usuario{

	
	
	public Estudiante(String nombre, String apellido, String fechaNacimiento, 
			int dni, String domicilio, String numero,
			String email, String contrasena) {
		super(nombre, apellido, fechaNacimiento, dni, 
				domicilio, numero, email, contrasena);
	}

	
	public static void inscripcionCarrera(int idEstudiante) throws CommunicationException{
		Scanner sc = new Scanner(System.in);
		String nombreCarrera = "";
		String respuesta;
		int idCarrera; 
		
		
		
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Carreras-\n");
		Carrera.verCarreras();
		System.out.printf("");
		System.out.printf("\nIngrese la Carrera a inscribirse (el numero): ");
		idCarrera = sc.nextInt();		
		//Con la id acceder a la tabla de carreras. Luego, guardar el nombre de la Carrera. 
		// ------------------------------>				
		System.out.printf("\nDesea inscribirse en la carrera"+nombreCarrera+"?\n"+
				"A) SI // B) NO");
		respuesta = sc.next();
		respuesta.toUpperCase();
		if(respuesta.equals("A")){			
			// Aca se debe asociar la idCarrera con Estudiante --------->
			Statement statement = null;
			String sql;
			ResultSet rs;
			PreparedStatement stmt;
			Conexion cnn;
			
			cnn = new Conexion("root","Ehdemian2010.$","base");			
			Connection conexion=cnn.getConnection();
			
			try {
				//ULTIMO ID REGISTRADO EN LA TABLA
				statement = conexion.createStatement();
				sql = "SELECT control FROM inscripcionestudiante order by control DESC LIMIT 1;";
				rs = statement.executeQuery(sql);
				int control=0;
				while(rs.next()) {
					 control = rs.getInt("control");
					}		
	
							
				stmt = conexion.prepareStatement("INSERT INTO inscripcionestudiante VALUES (?,?,?)");
				stmt.setInt(1,control+1);
	        	stmt.setInt(2,idCarrera);
	        	stmt.setInt(3,idEstudiante);
	        	
	        	int response = stmt.executeUpdate();
	        	if(response>0) {
	        		System.out.println("se inscribio correctamente");
	        	}
			} catch (SQLException sqle){
	            System.out.println("SQLState: "+ sqle.getSQLState());
	            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
	            sqle.printStackTrace();
	            
	        } catch (Exception e){
	            e.printStackTrace();
	        }
		}
	}

	static void inscripcionExamen(int idEstudiante) throws CommunicationException{
		Scanner sc = new Scanner(System.in);
		String nombreCarrera = "";
		String respuesta;
		int idCarrera; 
		
		
		
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Carreras-\n");
		Examen.verExamen();
		System.out.printf("");
		System.out.printf("\nIngrese el examen a inscribirse (el numero): ");
		idCarrera = sc.nextInt();		
		//Con la id acceder a la tabla de carreras. Luego, guardar el nombre de la Carrera. 
		// ------------------------------>				
		System.out.printf("\nDesea inscribirse en el examen"+nombreCarrera+"?\n"+
				"A) SI // B) NO");
		respuesta = sc.next();
		respuesta.toUpperCase();
		if(respuesta.equals("A")){			
			// Aca se debe asociar la idCarrera con Estudiante --------->
			Statement statement = null;
			String sql;
			ResultSet rs;
			PreparedStatement stmt;
			Conexion cnn;
			
			cnn = new Conexion("root","Ehdemian2010.$","base");		
			Connection conexion=cnn.getConnection();
			
			try {
				//ULTIMO ID REGISTRADO EN LA TABLA
				statement = conexion.createStatement();
				sql = "SELECT control FROM estudiante_examen order by control DESC LIMIT 1;";
				rs = statement.executeQuery(sql);
				int control=0;
				while(rs.next()) {
					 control = rs.getInt("control");
					}			
				stmt = conexion.prepareStatement("INSERT INTO estudiante_examen VALUES (?,?,?)");
				stmt.setInt(1,control+1);
	        	stmt.setInt(2,idCarrera);
	        	stmt.setInt(3,idEstudiante);
	        	
	        	int response = stmt.executeUpdate();
	        	if(response>0) {
	        		System.out.println("se inscribio al examen correctamente");
	        	}
			} catch (SQLException sqle){
	            System.out.println("SQLState: "+ sqle.getSQLState());
	            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
	            sqle.printStackTrace();
	            
	        } catch (Exception e){
	            e.printStackTrace();
	        }
		}
	}
		
	
	static void bajaExamen(int idEstudiante) throws CommunicationException{
		Scanner sc = new Scanner(System.in);
		String respuesta;
		int idExamen;
		int control = 0;
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		Conexion cnn;
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Examenes-\n");
		Examen.verExamen();
		System.out.printf("");
		System.out.printf("\nIngrese el examen a darse de baja (el numero): ");
		idExamen = sc.nextInt();		
		//Con la id acceder a la tabla de carreras. Luego, guardar el nombre de la Carrera. 
		// ------------------------------>				
		System.out.printf("\nDesea darse de baja en el examen"+"?\n"+
				"A) SI // B) NO\n ");
		respuesta = sc.next();
		respuesta.toUpperCase();
		if(respuesta.equals("A")){		
		
		cnn = new Conexion("root","Ehdemian2010.$","base");
		System.out.println(cnn.conectar());
		
		Connection conexion=cnn.getConnection();
			
			try {			
					statement = conexion.createStatement();
					sql = "SELECT * FROM estudiante_examen;";
					rs = statement.executeQuery(sql);					
					while(rs.next()) 
					{
						control = rs.getInt("control");
						int  estudianteSQL= rs.getInt("Estudiante_idEstudiante");
						int  examenSQL= rs.getInt("mesa_idMesa");
						if(idExamen==examenSQL&&idEstudiante==estudianteSQL) {
							stmt = conexion.prepareStatement("DELETE FROM estudiante_examen WHERE control = ?;");
				        	stmt.setInt(1, control);
				        	
				        	int response = stmt.executeUpdate();
				        	if(response>0) 
				        	{
				        		System.out.println("se dio de baja correctamente");
				        	}
				        	break;
						}					
					}															
				 }
			catch (SQLException sqle){
	            System.out.println("SQLState: "+ sqle.getSQLState());
	            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
	            sqle.printStackTrace();
	        }catch (Exception e){
	            e.printStackTrace();}}
	}
	        
		
		
	
		
	
	static void verHistorialAcademico(){
		
	}
	static void generarCertificadoAR(){
		
	}
}


