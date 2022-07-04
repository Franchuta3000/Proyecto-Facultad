package Clases;

public class Usuario extends Persona{
	protected String email;
	protected String contrase�a;
	protected int idUsuario;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Usuario(String nombre, String apellido, String fechaNacimiento, int dni, String domicilio, String string,
			String email, String contrase�a, int idUsuario) {
		super(nombre, apellido, fechaNacimiento, dni, domicilio, string);
		this.email = email;
		this.contrase�a = contrase�a;
		this.idUsuario = idUsuario;
	}

	
	

}
