package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.naming.CommunicationException;

import Utilidades.Conexion;

public class Persona{
	protected String nombre;
	protected String apellido;
	protected String fechaNacimiento;
	protected int dni;
	protected String domicilio;
	protected String telefono;
	//protected int idPersona;
	
	public Persona(String nombre, String apellido, String fechaNacimiento, 
			int dni, String domicilio, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
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
		return fechaNacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fechaNacimiento = fecha_Nacimiento;
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
    





