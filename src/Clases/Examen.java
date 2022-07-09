package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.naming.CommunicationException;

import Utilidades.Conexion;

public class Examen extends Materia{
	private int examen;
	private int nota;
	private String fecha;
	private String horaInicio;
	private String horaFinal;
	
	
	public Examen(String nombreCarrera, String duracion, String tituloOtorgado) {
		super(nombreCarrera, duracion, tituloOtorgado);
		// TODO Auto-generated constructor stub
	}
	public static int asociarConMateria() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n###############################################\n");
		System.out.printf("\n-Asocie el Examen con una Materia-");
		Materia.verMateria();
		System.out.printf("\n-Seleccione la Materia (ingrese el numero): ");
		int idMateria = sc.nextInt();
		
		return idMateria;	
	}
}

