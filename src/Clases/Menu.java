package Clases;

import java.util.Scanner;

public class Menu {
	private String respuesta;
	private int idMenu;
	
	//Recibe una id para saber quÃ© MenÃº crear (switch).
	public static void armarMenu(int idMenu, Scanner sc) {
		String respuesta,nombre =null, apellido=null,fechaNacimiento=null,
		domicilio = null, email = null,telefono=null,contraseña=null;
		boolean aux = true;
		int dni= 0; 
		Estudiante estudiante1 = new Estudiante(nombre,apellido,fechaNacimiento,
				dni,domicilio,email,telefono,contraseña);
		//Bucle para que siempre haya un MenÃº en pantalla.
		do {
			System.out.printf("Módulo de Gestión Académica\n");
			System.out.printf("Facultad de Humanidades\n");
			System.out.printf("\nidMenu = "+idMenu);
			switch (idMenu) {
			case 0: {
				// MenÃº de Inicio.
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
				
				idMenu = 0; // MomentÃ¡neo, para que el bucle no sea infinito.
				
				if(estudiante1 != null) {
					estudiante1.iniciarSesionUsuario();
				}
				else {
					
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
				//Validar datos
				
				System.out.printf("\nDatos Ingresados: "+nombre+apellido+fechaNacimiento+
						dni+domicilio+email+contraseña+"\n");
				System.out.printf("\nA) Continuar\nB) Modificar\n");
				System.out.printf("\nSu respuesta: ");
				respuesta = sc.nextLine();
				System.out.printf("\n###############################################\n");
				idMenu = eleccion(respuesta, idMenu, sc);	
				
				//Sujeto a errores, puede fallar.
				estudiante1 = new Estudiante(nombre,apellido,fechaNacimiento,
						dni,domicilio,email,telefono,contraseña);
				
				estudiante1.registrarUsuario();
				break;
			}
			case 3:{
				//Menú de Estudiante
				break;
			}
			case 4:{
				//Menú de Administrador
				break;
			}
			case 99: {
				//Salir de la aplicaciÃ³n
				System.out.printf("\nSaliendo... ojalÃ¡ se le enfrÃ­e el cafÃ©.");
				aux = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idMenu);
			}
		}while(aux);
	}
	
	// Compara la repsuesta, verifica de quÃ© menÃº viene y realiza el siguiente paso.
	static int eleccion(String respuesta, int idMenu, Scanner sc) {
			switch (respuesta) {
			case "A": {
				if(idMenu == 0) { // Proviene del Inicio
					idMenu = 1;
					break;
				}
				else if(idMenu == 2) { // Proviene del Registro
					System.out.printf("\nRegistro realizado con Ã©xito");
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
				System.out.printf("OpciÃ³n no vÃ¡lida: '" + respuesta + "'" + 
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
