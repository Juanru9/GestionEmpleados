package com.gestionempleados.model;

import java.util.Objects;

public class Empleado {
	
	// Atributos
	private String nombre;
	private double salario;
	private String fechaNacimiento;
	
	// Metodo constructor
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	// Metodo constructor
	public Empleado(String nombre, double salario, String fechaNacimiento) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.salario = salario;
	}

	// Metodos especificos de la clase
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, nombre, salario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", salario=" + salario + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
