package Clases;
import Utilidades.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.naming.CommunicationException;

public class Carrera {
	private String nombreCarrera;
	private String duracion;
	private String tituloOtorgado;
	
	// Getter, setter, Constructores
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getTituloOtorgado() {
		return tituloOtorgado;
	}
	public void setTituloOtorgado(String tituloOtorgado) {
		this.tituloOtorgado = tituloOtorgado;
	}
	public Carrera(String nombreCarrera, String duracion, String tituloOtorgado) {
		this.nombreCarrera = nombreCarrera;
		this.duracion = duracion;
		this.tituloOtorgado = tituloOtorgado;
	}
	
	//
	public static void verCarreras() throws CommunicationException {
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
				+ "FROM carrera "
				+ "order by idCarrera;";
			rs = statement.executeQuery(sql);
			System.out.println("Carreras disponibles ");
			while(rs.next()) 
			{
			
			int idCarrera = rs.getInt("idCarrera");
			String nombreCarrera = rs.getString("NombreCarrera");
			String duracion = rs.getString("Duración");
			String tituloOtorgado = rs.getString("TítuloOtorgado");
			System.out.println(idCarrera + " - " + nombreCarrera + " " + duracion + " " + tituloOtorgado);
			
			}
			System.out.println("Presione una tecla para continuar:");
			int carrera= sc.nextInt();  
		} catch (Exception e){
        e.printStackTrace();
		}
	}	
}
