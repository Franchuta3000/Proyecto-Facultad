package Clases;

import java.util.Scanner;

public class Menu {
	private String respuesta;
	private int idMenu;
	
	//Recibe una id para saber que menu crear (switch).
	public static void armarMenu(int idMenu, Scanner sc) {
		String respuesta,nombre, apellido,fechaNacimiento,
		domicilio, email,telefono,contraseña;
		boolean aux = true;
		int dni= 0;
		//Bucle para que siempre haya un Menu en pantalla, a menos que se indique (aux = false;).
		do {
			System.out.printf("Módulo de Gestión Académica\n");
			System.out.printf("Facultad de Humanidades\n");
			System.out.printf("\nidMenu = "+idMenu);
			switch (idMenu) {
			case 0: {
				// Menu de Inicio.
				System.out.printf("\n###############################################\n");
				System.out.printf("\nA) Iniciar Sesión\nB) Registrarse\nC) Salir\n");
				System.out.printf("\nA continuaciÃ³n, elija una opciÃ³n (A,B,C): ");
				respuesta = sc.nextLine();
				System.out.printf("\n###############################################\n");
				idMenu = eleccion(respuesta, idMenu, sc);
				break;
			}
			case 1: {
				// MenÃº de Inicio de sesiÃ³n
				System.out.printf("\n###############################################\n");
				System.out.printf("\n-Iniciar Sesión-\n");
				System.out.printf("\n-E-mail: ");
				email = sc.nextLine();
				System.out.printf("\n-Contraseña: ");
				contraseña = sc.nextLine();
				System.out.printf("\n###############################################\n");
				
				boolean validacionInicio = 
						Usuario.iniciarSesionUsuario(email,contraseña);
				if(validacionInicio) {
					idMenu = 3;		
				}
				else {
					System.out.println("Kinonis trabajando...");
					idMenu=99;
				}
				break;
				
			}
			case 2: {
				// MenÃº de Registro
				System.out.printf("\n###############################################\n");
				System.out.printf("\n-Registrarse-\n");
				System.out.printf("\nIngresá tus datos: \n");
				System.out.printf("\n-Nombre: ");
				nombre = sc.nextLine();
				System.out.printf("\n-Apellido: ");
				apellido = sc.nextLine();
				System.out.printf("\n-Fecha de nacimiento: ");
				fechaNacimiento = sc.nextLine();
				System.out.printf("\n-DNI (Sin puntos ni comas: ");
				dni = Integer.parseInt(sc.nextLine());
				System.out.printf("\n-Domicilio: ");
				domicilio = sc.nextLine();
				System.out.printf("\n-Dirección de email: ");
				email = sc.nextLine();
				System.out.printf("\n-Número de teléfono: ");
				telefono = sc.nextLine();
				System.out.printf("\n-Contraseña: ");
				contraseña = sc.nextLine();
				System.out.printf("\n-Confirmar contraseÃ±a: ");
				String contraseña1 = sc.nextLine();
				// falta verificar las contraseñas
				System.out.printf("\nDatos Ingresados: "+nombre+apellido+fechaNacimiento+
						dni+domicilio+email+contraseña+telefono+"\n");
				
				String validacionRegistro;
				validacionRegistro = Usuario.registrarUsuario(nombre,apellido,fechaNacimiento,dni,domicilio,email,telefono,contraseña);
				
				if(validacionRegistro.equals("ok")) {
					System.out.printf("\nA) Continuar\nB) Modificar\n");
					System.out.printf("\nSu respuesta: ");
					System.out.printf("\n###############################################\n");
					respuesta = sc.nextLine();
					idMenu = eleccion(respuesta, idMenu, sc);
				}
				else {
					System.out.println("Pa, hiciste algo mal. Intenta nuevamente.");
					System.out.println(validacionRegistro);
					idMenu = 2;
				}
					
				break;
			}
			case 3:{
				//Menu de Estudiante
				System.out.printf("\n###############################################\n");
				System.out.println("\n-Menu de Estudiante-\n");
				System.out.println("A)Inscribirse a Examen.");
				System.out.println("B)Dar de baja Examen.");
				System.out.println("C)Historial Academico.");
				System.out.println("D)Certificado de Alumno Regular (sin firma xd).");
				System.out.println("E)Cerrar Sesion.");
				System.out.println("\nSu respuesta: ");
				respuesta = sc.nextLine();
				idMenu = eleccion(respuesta, idMenu, sc);
				System.out.printf("\n###############################################\n");
				break;
			}
			case 4:{
				//Menu de Administrador
				System.out.printf("\n###############################################\n");
				System.out.println("\n-Menu de Administrador-\n");
				System.out.println("A)Crear Carrera.");
				System.out.println("B)Crear Materia (-ver leyes de la termodinamica).");
				System.out.println("C)Crear Examen.");
				System.out.println("D)Generar Listado de Resultados de Examenes.");
				System.out.println("E)Cerrar Sesion.");
				System.out.println("\nSu respuesta: ");
				respuesta = sc.nextLine();
				idMenu = eleccion(respuesta, idMenu, sc);
				System.out.printf("\n###############################################\n");
				break;
			}
			case 99: {
				//Salir de la aplicacion
				System.out.printf("\nSaliendo... ojala se le enfrie el cafe.");
				aux = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idMenu);
			}
		}while(aux);
	}
	
	// Compara la repsuesta, verifica de quÃ© menÃº viene y realiza el siguiente paso.
	
	
/*  idMenu =
	0: Inicio
	1: Iniciar Sesion
	2: Registrarse
 	3: Menu de Estudiante
 	4: Menu de Administrador
*/
	static int eleccion(String respuesta, int idMenu, Scanner sc) {
		switch (respuesta.toUpperCase()) {
			case "A": {
				if(idMenu == 0) { // Proviene del Inicio
					idMenu = 1;
				}
				else if(idMenu == 2) { // Proviene del Registro
					System.out.printf("\nRegistro realizado con Ã©xito");
					System.out.printf("\nPresione cualquier tecla para continuar... ");
					idMenu = 0;
					System.out.println(idMenu);
				}
				else if(idMenu == 3) { // Proviene del Estudiante
					Estudiante.inscripcionCarrera();					
				}
				else if(idMenu == 4) { // Proviene del Administrador
					Administrador.crearCarrera();
				}
				break;
			}
			case "B":{
				if(idMenu == 0) {
					idMenu = 2;
				}
				else if(idMenu == 2) {
					idMenu = 2;
				}
				else if(idMenu == 3) {
					Estudiante.bajaExamen();					
				}
				else if(idMenu == 4) {
					Administrador.crearMateria();
				}
				break;
			}
			case "C":{
				if(idMenu == 0) {
					idMenu = 99;
				}
				else if(idMenu == 3) {
					Estudiante.verHistorialAcademico();					
				}
				else if(idMenu == 4) {
					Administrador.crearMesaExamen();
				}
				break;
				}
			
			case "D":{
				if(idMenu == 3) {
					Estudiante.generarCertificadoAR();					
				}
				else if(idMenu == 4) {
					Administrador.generarListadoResultadosExamen();
				}
				break;
			}
			case "E":{
				if(idMenu == 3 || idMenu == 4) {
					idMenu = 0;					
				}
				break;
			}
			default:
				System.out.printf("Opcion no valida: '" + respuesta + "'"
						+ "\nPresione cualquier tecla para continuar... ");
				sc.nextLine();
			}
			return idMenu;
	}
	
	
	//Getter, Setter y Constructor.
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public Menu(int idMenu) {
	this.idMenu = idMenu;
	}
}
