package Clases;

public class Materia extends Carrera{
	private String nombreMateria;
	private String nombreProfesor;
	private int horasCatedra;
	
	static void crearMateria(){
		
	}

	
	// Constructor, getter y setter.
	public Materia(String nombreCarrera, String duracion, String tituloOtorgado) {
		super(nombreCarrera, duracion, tituloOtorgado);
		// TODO Auto-generated constructor stub
	}


	public String getNombreMateria() {
		return nombreMateria;
	}


	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}


	public String getNombreProfesor() {
		return nombreProfesor;
	}


	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}


	public int getHorasCatedra() {
		return horasCatedra;
	}


	public void setHorasCatedra(int horasCatedra) {
		this.horasCatedra = horasCatedra;
	}
	
}
