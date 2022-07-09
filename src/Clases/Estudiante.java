package Clases;

import java.util.Scanner;

import javax.naming.CommunicationException;

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
			String email, String contraseña) {
		super(nombre, apellido, fechaNacimiento, dni, 
				domicilio, numero, email, contraseña);
	}
	static void inscripcionCarrera() throws CommunicationException{
		Scanner sc = new Scanner(System.in);
		String nombreCarrera = "MWAH?";
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
		
		System.out.printf("\nDesea inscribirse en la carrera"+nombreCarrera+"?/n"+
				"A) SI // B) NO");
		respuesta = sc.nextLine();
		respuesta.toUpperCase();
		if(respuesta.equals("A")){			
			// Aca se debe asociar la idCarrera con Estudiante --------->
		}
		else if(respuesta.equals("B")) {
			
		}
		else {
			System.out.printf("\nRespuesta no válida. Lo sentimos.");
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
	static void inscripcionExamen(){
		
	}
	static void bajaExamen(){
		
	}	
	static void verHistorialAcademico(){
		
	}
	static void generarCertificadoAR(){
		
	}
}


