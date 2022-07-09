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
			System.out.println(cnn.conectar());
			
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
				System.out.println(idCarrera+"esto es id de la carrera , "+idEstudiante+"esto es la id del est");
							
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
/*	static void inscripcionMateria() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Materias-\n");
		Materia.verMateria();
		System.out.printf("");
		System.out.printf("\nIngrese la Materia a inscribirse (el numero): ");
		String respuesta = sc.nextLine();
		System.out.printf("\nDesea inscribirse en la materia"+respuesta+"?/n"+
				"A) SI // B) NO");
		respuesta = sc.nextLine();
	}
*/
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
			System.out.println(cnn.conectar());
			
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
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		Conexion cnn;
		
		cnn = new Conexion("root","Ehdemian2010.$","base");
		System.out.println(cnn.conectar());
		
		Connection conexion=cnn.getConnection();
			
			try {
				statement = conexion.createStatement();
				sql = "SELECT idcliente,Nombre,Apellido,Documento "
						+ "FROM cliente AS c INNER JOIN persona AS per ON c.idpersona = per.idpersona "
						+ "order by idcliente;";
				rs = statement.executeQuery(sql);
				System.out.println("Seleccione el examen a darse de baja");
				while(rs.next()) 
				{
					int idcliente = rs.getInt("idcliente");
					String apellido = rs.getString("Apellido");
					String nombre = rs.getString("Nombre");
					String documento = rs.getString("Documento");
					System.out.println(idcliente + " - " + apellido + " " + nombre + " " + documento);
				}
				System.out.println("Cancelar seleccione 0");
				int cliente  = sc.nextInt();
				
				if(cliente!=0) {
					statement = conexion.createStatement();
					sql = "SELECT idpersona FROM cliente WHERE idcliente = "+cliente+";";
					rs = statement.executeQuery(sql);
					int idpersona = 0;
					while(rs.next()) 
					{
						idpersona = rs.getInt("idpersona");
					}
					
					stmt = conexion.prepareStatement("DELETE FROM cliente WHERE idcliente = ?;");
		        	stmt.setInt(1, cliente);
		        	
		        	int response = stmt.executeUpdate();
		        	if(response>0) 
		        	{
		        		System.out.println("se elimino cliente correctamente");
		        	}
					stmt = conexion.prepareStatement("DELETE FROM persona WHERE idPersona = ?");
		        	stmt.setInt(1, idpersona);
		        	
		        	response = stmt.executeUpdate();
		        	if(response>0) 
		        	{
		        		System.out.println("se elimino persona correctamente");
		        	}
				 }
			}catch (SQLException sqle){
	            System.out.println("SQLState: "+ sqle.getSQLState());
	            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
	            sqle.printStackTrace();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
		}
		
	
	static void verHistorialAcademico(){
		
	}
	static void generarCertificadoAR(){
		
	}
}


