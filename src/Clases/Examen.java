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
	
	public static void crearExamen() throws CommunicationException {
	Scanner	sc= new Scanner(System.in);
	
	System.out.println("Ingrese nombre del examen: ");
	String examen= sc.next();
	System.out.println("Ingrese fecha del examen");
	String fecha= sc.next();
	System.out.println("Ingrese inicio del examen");
	String inicio= sc.next();
	System.out.println("Ingrese final del examen");
	String finalExamen= sc.next();
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		Conexion cnn;
		
		cnn = new Conexion("root","Ehdemian2010.$","base");
		System.out.println(cnn.conectar());
		
		Connection conexion=cnn.getConnection();
		
		try {
			//ULTIMO ID REGISTRADO EN LA TABLA
			statement = conexion.createStatement();
			sql = "SELECT idMesa_De_Examens FROM mesa_de_examens order by idMesa_De_Examens DESC LIMIT 1;"
					+"SELECT idMateria FROM materias order by idMateria DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			int idExamen = 0;
			int materia= 0;
			while(rs.next()) {
				idExamen = rs.getInt("idMesa_De_Examens");
				materia = rs.getInt("idMAteria");
				}			
			stmt = conexion.prepareStatement("INSERT INTO mesa_de_examens VALUES (?,?,?,?,?,?)");
        	stmt.setInt(1,idExamen+1);
        	stmt.setInt(2,materia+1);
        	stmt.setString(3,examen);
        	stmt.setString(4,fecha);
        	stmt.setString(5,inicio);
        	stmt.setString(6,finalExamen);
        	
        	
        	int response = stmt.executeUpdate();
        	if(response>0) {
        		System.out.println("se inserto Examen correctamente");
        	}
		
	}catch (Exception e) {
		// TODO: handle exception
	}
}
	}
