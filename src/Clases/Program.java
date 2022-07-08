package Clases;
import java.util.Scanner;

import javax.naming.CommunicationException;

import Clases.Menu;
import Clases.Persona;

public class Program {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		int idMenu = 0; // "0"= inicio - "1"= iniciar sesión.  - "2"= registrarse
		
		Menu.armarMenu(idMenu, sc);
		
		System.out.println("\n"+"\nHasta aca llego qlio :c");
	}
}