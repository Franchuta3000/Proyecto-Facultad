package Test;
import java.sql.*;

import javax.naming.CommunicationException;

import Clases.Usuario;
import Utilidades.Conexion;
public class TestUsuario {

	public static void main(String[] args) throws CommunicationException {
		// TODO Auto-generated method stub
Conexion cnn = new Conexion("root","Ehdemian2010.$","base");
System.out.println(cnn.conectar());
Usuario usuario = new Usuario(null, null, null, 0, null, null, null, null);
	

usuario.registrarUsuario(cnn.getConnection());
	}

}
