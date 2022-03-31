package com.gestionempleados.model;

public class Director extends Empleado {
	
	// Atributos especificos de 'Director'
	private double incentivo = 1.1;
	private String matricula;

	// Constructores especificos de 'Director'	
	public Director() {
		super();
		this.darIncentivo();
	}
	
	public Director(String nombre, double salario, String fechaNacimiento) {
		super(nombre, salario, fechaNacimiento);
		this.darIncentivo();
	}
	
	public Director(String nombre, double salario, String fechaNacimiento, String matricula) {
		super(nombre, salario, fechaNacimiento);
		this.matricula = matricula;
		this.darIncentivo();
	}
	
	public Director(String nombre, double salario, String fechaNacimiento, double incentivo, String matricula) {
		super(nombre, salario, fechaNacimiento);
		this.incentivo = incentivo;
		this.matricula = matricula;
		this.darIncentivo();
	}
	
	// Metodos especificos de 'Director'	
	public double getIncentivo() {
		return incentivo;
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void darIncentivo() {
		this.setSalario(getSalario()*this.incentivo+100);
		System.out.println("Salario de "+(this.getSalario()/incentivo-100)+" se ha multiplicado por '(x "+incentivo+") + 100' y ahora es: "+this.getSalario());
	}

	@Override
	public String toString() {
		return "Director [nombre=" + this.getNombre() + ", salario=" + this.getSalario() + ", fechaNacimiento=" + this.getFechaNacimiento() + ", incentivo=" + incentivo + ", matricula=" + matricula +  "]";
	}

}
