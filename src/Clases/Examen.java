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
	public static void verExamen() throws CommunicationException {
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
				+ "FROM mesa_de_examens "
				+ "order by idMesa_De_Examens;";
			rs = statement.executeQuery(sql);
			System.out.println("examenes disponibles ");
			while(rs.next()) 
			{
			int idExamen = rs.getInt("idMesa_De_Examens");
			int materiaIdMateria= rs.getInt("Materias_idMaterias");
			String examen = rs.getString("Examen");
			String fechaMesa = rs.getString("fecha_Mesa");
			String fechainicio = rs.getString("fecha_Inicio");
			String fechafinal = rs.getString("fecha_Final");
			
			System.out.println(idExamen + ") " +" " + examen + " " + fechaMesa);
			}	
		} catch (Exception e){
        e.printStackTrace();
		}
	}	
}

