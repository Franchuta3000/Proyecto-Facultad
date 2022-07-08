package Test;
import java.sql.*;

import javax.naming.CommunicationException;

import Clases.Usuario;
import Clases.Persona;
import Utilidades.Conexion;
import Clases.Carrera;
import Clases.Administrador;
public class TestUsuario {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//Conexion cnn = new Conexion("root","Ehdemian2010.$","base");
//System.out.println(cnn.conectar());
Usuario usuario = new Usuario(null, null, null, 0, null, null, null, null);
Persona persona = new Persona(null,null,null,0,null,null);	
Carrera carrera = new Carrera(null, null, null);
Administrador administrador = new Administrador(null,null,null,0,null,null,null,null);

//administrador.crearCarrera();
carrera.verCarreras();
//carrera.verCarreras(cnn.getConnection());
	}

}
