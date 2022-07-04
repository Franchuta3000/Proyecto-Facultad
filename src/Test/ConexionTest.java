package Test;


import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.CommunicationException;

import Utilidades.Conexion;
import Clases.Persona;

public class ConexionTest {
	public static void main(String[] args)  {
		Conexion cnn = new Conexion("root","Ehdemian2010.$","base");
		Persona persona = new Persona("Fabricio", "Uzumaki","13/09/1993",44444755,"Avenida Siempre viva 123", "1");
		try {
			System.out.println(cnn.conectar());
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement stmt = cnn.getConnection().prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?)");
			stmt.setInt(1,1);
			stmt.setString(2,"Fabricios");
			stmt.setString(3,"Uzumakia");
			stmt.setString(4,"13/09/1993");
			stmt.setInt(5,44444756);
			stmt.setString(6,"Avenida Siempre viva 123");
			stmt.setString(7,"1");
		
			int response = stmt.executeUpdate();
			if(response>0) {
				System.out.println("Se insertó pa");
				
			}
			else {
				System.out.println("No se insertó pa");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		cnn.desconectar();
	}
		
		
}
}
