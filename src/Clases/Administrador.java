package Clases;
import Test.ConexionTest;
import Utilidades.Conexion;
/*
Crear una carrera
Crear una materia asociada a la carrera 
Crear mesas de examen 
Generar listado de resultados de exmenes 
*/
public class Administrador extends Usuario{
	
	public Administrador(String nombre, String apellido, String fechaNacimiento, int dni, String domicilio,
			String telefono, String email, String contraseña) {
		super(nombre, apellido, fechaNacimiento, dni, domicilio, telefono, email, contraseña);
		// TODO Auto-generated constructor stub
	}
	static void crearCarrera() {
		Conexion cnn = new Conexion("root","Ehdemian2010.$","base");
		try {
			System.out.println(cnn.conectar());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	static void crearMateria() {}
	static void crearMesaExamen() {}
	static void generarListadoResultadosExamen() {}
	
}
