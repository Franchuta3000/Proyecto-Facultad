package Clases;

public class Persona{
	private String nombre;
	private String apellido;
	private String fecha_Nacimiento;
	private int dni;
	private String domicilio;
	private String telefono;
	//protected int idPersona;
	
	public Persona(String nombre, String apellido, String fechaNacimiento, 
			int dni, String domicilio, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_Nacimiento = fechaNacimiento;
		this.dni = dni;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNumero() {
		return telefono;
	}

	public void setNumero(String numero) {
		this.telefono = numero;
	}

	public void mostrar() {
		System.out.println("\n"+nombre+" "+apellido);
	}
	
}
