package Clases;

public class ValidarInicio {
	boolean validarInicio;
	int idEstudiante;
	public boolean isValidarInicio() {
		return validarInicio;
	}
	public void setValidarInicio(boolean validarInicio) {
		this.validarInicio = validarInicio;
	}
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public ValidarInicio(boolean validarInicio, int idEstudiante) {
		this.validarInicio = validarInicio;
		this.idEstudiante = idEstudiante;
	}
	
}
