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
	public void crearCarrera(Connection conexion) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n###############################################\n");
		System.out.printf("\nCreación de Carrera");
		System.out.printf("\nIngresa los datos de la carrera: \n");
		System.out.printf("\n-Nombre de la carrera: ");
	String	nombreCarrera = sc.nextLine();
		System.out.printf("\n-Duración de la carrera (numeros y letras): ");
	String	duracion = sc.nextLine();
		System.out.printf("\n-Titulo otorgado: ");
	String	tituloOtorgado = sc.nextLine();
		
	Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		
		try {
			//ULTIMO ID REGISTRADO EN LA TABLA
			statement = conexion.createStatement();
			sql = "SELECT idCarrera FROM carrera order by idCarrera DESC LIMIT 1;";
			rs = statement.executeQuery(sql);
			int idCarrera = 0;
			while(rs.next()) 
			{
				idCarrera = rs.getInt("idCarrera");
			}
			
			stmt = conexion.prepareStatement("INSERT INTO carrera VALUES (?,?,?,?)");
        	stmt.setInt(1,idCarrera+1);
        	stmt.setString(2,nombreCarrera);
        	stmt.setString(3,duracion);
        	stmt.setString(4,tituloOtorgado);
        	
        	
        	int response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto la carrera correctamente");
        	}
	
	} catch (SQLException sqle){
        System.out.println("SQLState: "+ sqle.getSQLState());
        System.out.println("SQLErrorCode: " + sqle.getErrorCode());
        sqle.printStackTrace();
    }catch (Exception e){
        e.printStackTrace();
    }
}
	
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
			String duracion = rs.getString("Duración");
			String tituloOtorgado = rs.getString("TítuloOtorgado");
			System.out.println(idCarrera + " - " + nombreCarrera + " " + duracion + " " + tituloOtorgado);
			int carrera= sc.nextInt();
			
    	}
	
		
	} catch (Exception e){
        e.printStackTrace();
	
}}
	
		
	
}
