package Clases;
import Utilidades.Conexion;

public class Usuario extends Persona{
	private String email;
	private String contraseña;
	protected int idUsuario;
	
	static void registrarUsuario() {
		
	}
	static void iniciarSesionUsuario(){
		
	}
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Usuario(String nombre, String apellido, String fechaNacimiento, int dni, 
			String domicilio, String telefono, String email, String contraseña) {
		super(nombre, apellido, fechaNacimiento, dni, domicilio, telefono);
		// TODO Auto-generated constructor stub
		this.email = email;
		this.contraseña = contraseña;
	}
	
	

	
	

}
