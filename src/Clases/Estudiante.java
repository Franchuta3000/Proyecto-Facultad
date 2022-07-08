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
			String email, String contrase�a) {
		super(nombre, apellido, fechaNacimiento, dni, 
				domicilio, numero, email, contrase�a);
	}
	static void inscripcionCarrera() throws CommunicationException{
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Carreras-\n");
		Carrera.verCarreras();
		System.out.printf("");
		System.out.printf("\nIngrese el nombre de la carrera a Inscribirse: ");
		String respuesta = sc.nextLine();
		System.out.printf("\nDesea inscribirse en la carrera"+respuesta+"?/n"+
				"A) SI // B) NO");
		respuesta = sc.nextLine();
	}
	static void inscripcionMateria() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Materias-\n");
		Materia.verMateria();
		System.out.printf("");
		System.out.printf("\nIngrese el nombre de la materia a Inscribirse: ");
		String respuesta = sc.nextLine();
		System.out.printf("\nDesea inscribirse en la materia"+respuesta+"?/n"+
				"A) SI // B) NO");
		respuesta = sc.nextLine();
	}
	static void inscripcionExamen(){
		
	}
	static void bajaExamen(){
		
	}	
	static void verHistorialAcademico(){
		
	}
	static void generarCertificadoAR(){
		
	}
}


