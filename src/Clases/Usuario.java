package Clases;

public class Usuario extends Persona{
	protected String email;
	protected String contraseña;
	protected int idUsuario;
	
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
	public Usuario(String nombre, String apellido, String fechaNacimiento, int dni, String domicilio, String string,
			String email, String contraseña, int idUsuario) {
		super(nombre, apellido, fechaNacimiento, dni, domicilio, string);
		this.email = email;
		this.contraseña = contraseña;
		this.idUsuario = idUsuario;
	}

	
	

}
