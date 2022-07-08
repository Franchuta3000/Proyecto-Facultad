package Clases;
import Utilidades.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
	public void verCarreras(Connection conexion) {
		Scanner sc= new Scanner (System.in);
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		try {
			statement = conexion.createStatement();
			sql = "SELECT * "
				+ "FROM carrera "
				+ "order by idCarrera;";
			rs = statement.executeQuery(sql);
			System.out.println("Seleccione Carrera ");
			while(rs.next()) 
			{
			int idCarrera = rs.getInt("idCarrera");
			String nombreCarrera = rs.getString("NombreCarrera");
			String duracion = rs.getString("Duraci�n");
			String tituloOtorgado = rs.getString("T�tuloOtorgado");
			System.out.println(idCarrera + " - " + nombreCarrera + " " + duracion + " " + tituloOtorgado);
			int carrera= sc.nextInt();
			}		
		} catch (Exception e){
        e.printStackTrace();
		}
	}	
}
