package Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.CommunicationException;

import Clases.Usuario;
import Utilidades.Conexion;


public class TestPersona{
	public static void main(String[] args) {
{	
	Conexion cnn = new Conexion("root","Ehdemian2010.$","base");
	Scanner sc = new Scanner(System.in);
	System.out.printf("\n###############################################\n");
	System.out.printf("\n-Registrarse-\n");
	System.out.printf("\nIngres� tus datos: \n");
	System.out.printf("\n-Nombre: ");
	
String	nombre = sc.nextLine();
	System.out.printf("\n-Apellido: ");
String	apellido = sc.nextLine();
	System.out.printf("\n-Fecha de nacimiento: ");
String	fechaNacimiento = sc.nextLine();
	System.out.printf("\n-DNI (Sin puntos ni comas: ");
int	dni = Integer.parseInt(sc.nextLine());
	System.out.printf("\n-Domicilio: ");
String	domicilio = sc.nextLine();
	System.out.printf("\n-Direcci�n de email: ");
String	email = sc.nextLine();
	System.out.printf("\n-N�mero de tel�fono: ");
String	telefono = sc.nextLine();
	System.out.printf("\n-Contrase�a: ");
String	contrase�a = sc.nextLine();
	System.out.printf("\n-Confirmar contraseña: ");
	String contrase�a1 = sc.nextLine();
	Usuario usuario = new Usuario(nombre, apellido, fechaNacimiento, dni, domicilio, telefono, email, contrase�a);
		
	try {
		System.out.println(cnn.conectar());
	} catch (CommunicationException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		PreparedStatement stmt = cnn.getConnection().prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?)");
		stmt.setInt(1,1);
		stmt.setString(2,nombre);
		stmt.setString(3,apellido);
		stmt.setString(4,fechaNacimiento);
		stmt.setInt(5,dni);
		stmt.setString(6,domicilio);
		stmt.setString(7,telefono);
		int response = stmt.executeUpdate();
    	if(response>0) 
    	{
    		System.out.println("se inserto correctamente");
    	}
	 }catch (SQLException sqle){
        System.out.println("SQLState: "+ sqle.getSQLState());
        System.out.println("SQLErrorCode: " + sqle.getErrorCode());
        sqle.printStackTrace();
    }catch (Exception e){
	}
	cnn.desconectar();
}
}
}
