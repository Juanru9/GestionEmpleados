package com.gestionempleados.model;

public class Gerente extends Empleado {
	
	// Atributos especificos de 'Gerente'
	private double incentivo = 1.05;

	// Constructores especificos de 'Gerente'
	public Gerente() {
		super();
		this.darIncentivo();
	}
	
	public Gerente(String nombre, double salario, String fechaNacimiento) {
		super(nombre, salario, fechaNacimiento);
		this.darIncentivo();
	}

	public Gerente(String nombre, double salario, String fechaNacimiento, double incentivo) {
		super(nombre, salario, fechaNacimiento);
		this.incentivo = incentivo;
		this.darIncentivo();
	}

	// Metodos especificos de 'Gerente'
	public double getIncentivo() {
		return incentivo;
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	public void darIncentivo() {
		
		this.setSalario(getSalario()*incentivo);
		System.out.println("Salario de "+this.getSalario()/incentivo+" se ha multiplicado por (x "+incentivo+") y ahora es: "+this.getSalario());
		
	}
	
	@Override
	public String toString() {
		return "Gerente [nombre=" + this.getNombre() + ", salario=" + this.getSalario() + ", fechaNacimiento=" + this.getFechaNacimiento() + ", incentivo=" + incentivo +"]";
	}
	
}
