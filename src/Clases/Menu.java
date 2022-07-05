package Clases;

import java.util.Scanner;

public class Menu {
	private String respuesta;
	private int idMenu;
	
	//Recibe una id para saber qué Menú crear (switch).
	public static void armarMenu(int idMenu, Scanner sc) {
		String respuesta,nombre =null, apellido=null,fechaNacimiento=null,
		domicilio = null, email = null,telefono=null,contrase�a=null;
		boolean aux = true;
		int dni= 0; 
		Estudiante estudiante1 = new Estudiante(nombre,apellido,fechaNacimiento,
				dni,domicilio,email,telefono,contrase�a);
		//Bucle para que siempre haya un Menú en pantalla.
		do {
			System.out.printf("M�dulo de Gesti�n Acad�mica\n");
			System.out.printf("Facultad de Humanidades\n");
			System.out.printf("\nidMenu = "+idMenu);
			switch (idMenu) {
			case 0: {
				// Menú de Inicio.
				System.out.printf("\n###############################################\n");
				System.out.printf("\nA) Iniciar Sesi�n\nB) Registrarse\nC) Salir\n");
				System.out.printf("\nA continuación, elija una opción (A,B,C): ");
				respuesta = sc.nextLine();
				System.out.printf("\n###############################################\n");
				idMenu = eleccion(respuesta, idMenu, sc);
				break;
			}
			case 1: {
				// Menú de Inicio de sesión
				System.out.printf("\n###############################################\n");
				System.out.printf("\n-Iniciar Sesi�n-\n");
				System.out.printf("\n-E-mail: ");
				email = sc.nextLine();
				System.out.printf("\n-Contrase�a: ");
				contrase�a = sc.nextLine();
				System.out.printf("\n###############################################\n");
				
				idMenu = 0; // Momentáneo, para que el bucle no sea infinito.
				
				if(estudiante1 != null) {
					estudiante1.iniciarSesionUsuario();
				}
				else {
					
				}
				break;
			}
			case 2: {
				// Menú de Registro
				System.out.printf("\n###############################################\n");
				System.out.printf("\n-Registrarse-\n");
				System.out.printf("\nIngres� tus datos: \n");
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
				System.out.printf("\n-Direcci�n de email: ");
				email = sc.nextLine();
				System.out.printf("\n-N�mero de tel�fono: ");
				telefono = sc.nextLine();
				System.out.printf("\n-Contrase�a: ");
				contrase�a = sc.nextLine();
				System.out.printf("\n-Confirmar contraseña: ");
				String contrase�a1 = sc.nextLine();
				//Validar datos
				
				System.out.printf("\nDatos Ingresados: "+nombre+apellido+fechaNacimiento+
						dni+domicilio+email+contrase�a+"\n");
				System.out.printf("\nA) Continuar\nB) Modificar\n");
				System.out.printf("\nSu respuesta: ");
				respuesta = sc.nextLine();
				System.out.printf("\n###############################################\n");
				idMenu = eleccion(respuesta, idMenu, sc);	
				
				//Sujeto a errores, puede fallar.
				estudiante1 = new Estudiante(nombre,apellido,fechaNacimiento,
						dni,domicilio,email,telefono,contrase�a);
				
				estudiante1.registrarUsuario();
				break;
			}
			case 3:{
				//Men� de Estudiante
				break;
			}
			case 4:{
				//Men� de Administrador
				break;
			}
			case 99: {
				//Salir de la aplicación
				System.out.printf("\nSaliendo... ojalá se le enfríe el café.");
				aux = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idMenu);
			}
		}while(aux);
	}
	
	// Compara la repsuesta, verifica de qué menú viene y realiza el siguiente paso.
	static int eleccion(String respuesta, int idMenu, Scanner sc) {
			switch (respuesta) {
			case "A": {
				if(idMenu == 0) { // Proviene del Inicio
					idMenu = 1;
					break;
				}
				else if(idMenu == 2) { // Proviene del Registro
					System.out.printf("\nRegistro realizado con éxito");
					System.out.printf("\nPresione cualquier tecla para continuar... ");
					idMenu = 0;
					System.out.println(idMenu);
				}
				return idMenu;
			}
			case "B":{
				if(idMenu == 0) {
					idMenu = 2;
				}
				else if(idMenu == 2) {
					idMenu = 2;
				}
				break;
			}
			case "C":{
				if(idMenu == 0) {
					idMenu = 99;
				}
				break;
				}
			default:
				System.out.printf("Opción no válida: '" + respuesta + "'" + 
						"\nPresione cualquier tecla para continuar... ");
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
