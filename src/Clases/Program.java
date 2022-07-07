package Clases;
import java.util.Scanner;
import Clases.Menu;
import Clases.Persona;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idMenu = 0; // "0"= inicio - "1"= iniciar sesión.  - "2"= registrarse
		
		Menu.armarMenu(idMenu, sc);
		
		System.out.println("\n"+"\nHasta aca llego qlio :c");
	}
}