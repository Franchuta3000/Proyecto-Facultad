package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.naming.CommunicationException;

import Utilidades.Conexion;

public class Materia extends Carrera{
	private String nombreMateria;
	private String nombreProfesor;
	private int horasCatedra;
	

	
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
	


static void verMateria() throws Exception{
	Scanner sc= new Scanner (System.in);
	Statement statement = null;
	String sql;
	ResultSet rs;
	PreparedStatement stmt;
	Conexion cnn;
	
	cnn = new Conexion("root","Ehdemian2010.$","base");
	System.out.println(cnn.conectar());
	
	Connection conexion=cnn.getConnection();
	try {
		statement = conexion.createStatement();
		sql = "SELECT * "
				+ "FROM materias "
				+ "order by idMateria;";
		rs = statement.executeQuery(sql);
		System.out.println("Materias disponibles; ");
		while(rs.next()) 
		{
			
			int idMateria = rs.getInt("idMateria");
			String nombreMateria= rs.getString("NombreMateria");
			String horasCatedra = rs.getString("HorasCatedra");
			String nombreProfesor = rs.getString("NombreProfesor");
			System.out.println(idMateria + " - " + nombreMateria + " " + horasCatedra + " " + nombreProfesor);
			
		}
		System.out.println("Presione una tecla para continuar:");
		int carrera= sc.nextInt();  
	} catch (Exception e){
		e.printStackTrace();
	}
	
}
}