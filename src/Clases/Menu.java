package Clases;

import java.util.Scanner;

public class Menu {
	private String respuesta;
	private int idMenu;
	
	//Recibe una id para saber qu√© Men√∫ crear (switch).
	public static void armarMenu(int idMenu, Scanner sc) {
		String respuesta;
		boolean aux = true;
		//Bucle para que siempre haya un Men√∫ en pantalla.
		do {
			System.out.printf("MÛdulo de GestiÛn AcadÈmica\n");
			System.out.printf("Facultad de Humanidades\n");
			System.out.printf("\nidMenu = "+idMenu);
			switch (idMenu) {
			case 0: {
				// Men√∫ de Inicio.
				System.out.printf("\n###############################################\n");
				System.out.printf("\nA) Iniciar SesiÛn\nB) Registrarse\nC) Salir\n");
				System.out.printf("\nA continuaci√≥n, elija una opci√≥n (A,B,C): ");
				respuesta = sc.nextLine();
				System.out.printf("\n###############################################\n");
				idMenu = eleccion(respuesta, idMenu, sc);
				break;
			}
			case 1: {
				// Men√∫ de Inicio de sesi√≥n
				System.out.printf("\n###############################################\n");
				System.out.printf("\n-Iniciar SesiÛn-\n");
				System.out.printf("\n###############################################\n");
				idMenu = 0; // Moment√°neo, para que el bucle no sea infinito.
				break;
				
			}
			case 2: {
				// Men√∫ de Registro
				System.out.printf("\n###############################################\n");
				System.out.printf("\n-Registrarse-\n");
				System.out.printf("\nIngres· tus datos: \n");
				System.out.printf("\n-Nombre: ");
				String nombre = sc.nextLine();
				System.out.printf("\n-Apellido: ");
				String apellido = sc.nextLine();
				System.out.printf("\n-Fecha de nacimiento: ");
				String fechaNacimiento = sc.nextLine();
				System.out.printf("\nD)DNI: ");
				int dni = Integer.parseInt(sc.nextLine());
				System.out.printf("\n-Domicilio: ");
				String domicilio = sc.nextLine();
				System.out.printf("\n-DirecciÛn de email: ");
				String email = sc.nextLine();
				System.out.printf("\n-N˙mero de telÈfono: ");
				String numero = sc.nextLine();
				System.out.printf("\n-ContraseÒa: ");
				String contraseÒa = sc.nextLine();
				System.out.printf("\n-Confirmar contrase√±a: ");
				String contraseÒa1 = sc.nextLine();
				//Validar datos
				
				System.out.printf("\nDatos Ingresados: "+nombre+apellido+fechaNacimiento+
						dni+domicilio+email+contraseÒa+"\n");
				System.out.printf("\nA) Continuar\nB) Modificar\n");
				System.out.printf("\nSu respuesta: ");
				respuesta = sc.nextLine();
				System.out.printf("\n###############################################\n");
				idMenu = eleccion(respuesta, idMenu, sc);
				
				Estudiante estudiante1 = new Estudiante(nombre,apellido,fechaNacimiento,
						dni,domicilio,email,numero,contraseÒa);
				break;
			}	
			case 99: {
				//Salir de la aplicaci√≥n
				System.out.printf("\nSaliendo... ojal√° se le enfr√≠e el caf√©.");
				aux = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + idMenu);
			}
		}while(aux);
	}
	
	// Compara la repsuesta, verifica de qu√© men√∫ viene y realiza el siguiente paso.
	static int eleccion(String respuesta, int idMenu, Scanner sc) {
			switch (respuesta) {
			case "A": {
				if(idMenu == 0) { // Proviene del Inicio
					idMenu = 1;
					break;
				}
				else if(idMenu == 2) { // Proviene del Registro
					System.out.printf("\nRegistro realizado con √©xito");
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
				System.out.printf("Opci√≥n no v√°lida: '" + respuesta + "'" + 
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
	this.respuesta = respuesta;
	}
}
