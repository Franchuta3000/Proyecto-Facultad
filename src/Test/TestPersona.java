package Test;
import java.sql.PreparedStatement;

import javax.naming.CommunicationException;

import Clases.Persona;
import Utilidades.Conexion;
public class TestPersona{
{
	Conexion cnn = new Conexion("root","Ehdemian2010.$","base");

	try {
		System.out.println(cnn.conectar());
	} catch (CommunicationException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		PreparedStatement stmt = cnn.getConnection().prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?)");
		stmt.setInt(1,1);
		stmt.setString(2,"Fabricio");
		stmt.setString(3,"Uzumaki");
		stmt.setString(4,"13/09/1993");
		stmt.setInt(5,44444755);
		stmt.setString(6,"Avenida Siempre viva 123");
		stmt.setString(7,"1");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	cnn.desconectar();
}
}
