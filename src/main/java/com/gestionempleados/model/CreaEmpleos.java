package com.gestionempleados.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gestionempleados.control.Gestor;
import com.gestionempleados.gui.Gui;
import com.gestionempleados.util.LeerTeclado;

public class CreaEmpleos {
	// Llamamos a log4j2:
	private static Logger logger = LogManager.getLogger(Gestor.class);

	public static Empleado seleccionador() {
		Empleado emp = null;
		boolean comprobacion = false;
		do {
			try {
				switch (LeerTeclado.leerByte(
						"Seleccione el rango:\n(1)-> Empleado\n(2)-> Gerente\n(3)-> Director\n--------------")) {
				case 1:
					emp = CreaEmpleos.empleado();
					comprobacion = true;
					break;
				case 2:
					emp = CreaEmpleos.gerente();
					comprobacion = true;
					break;
				case 3:
					emp = CreaEmpleos.director();
					comprobacion = true;
					break;
				default:
					Gui.errorMenu();
				}
			} catch (Exception e) {
				logger.error(e.toString());
			}
		} while (comprobacion != true);
		return emp;
	}

	public static Empleado empleado() {
		Empleado emp = null;
		boolean comprobacion = false;
		do {
			try {
				emp = new Empleado(LeerTeclado.leerString("Introduzca el nombre: "),
						LeerTeclado.leerDouble("Introduzca sueldo base: "),
						LeerTeclado.leerString("Introduzca fecha de nacimiento (dd/mm/aaaa): "));
				comprobacion = true;
			} catch (Exception e) {
				logger.error(e.toString());
			}
		} while (comprobacion != true);
		return emp;
	}

	public static Gerente gerente() {
		Gerente gerente = null;
		boolean comprobacion = false;
		do {
			try {
				gerente = new Gerente(LeerTeclado.leerString("Introduzca el nombre: "),
						LeerTeclado.leerDouble("Introduzca sueldo base: "),
						LeerTeclado.leerString("Introduzca fecha de nacimiento (dd/mm/aaaa): "));
				comprobacion = true;
			} catch (Exception e) {
				logger.error(e.toString());
			}
		} while (comprobacion != true);
		return gerente;
	}

	public static Director director() {
		Director director = null;
		boolean comprobacion = false;
		do {
			try {
				director = new Director(LeerTeclado.leerString("Introduzca el nombre: "),
						LeerTeclado.leerDouble("Introduzca sueldo base: "),
						LeerTeclado.leerString("Introduzca fecha de nacimiento (dd/mm/aaaa): "),
						LeerTeclado.leerString("Introduzca la matrícula de su nuevo coche de empresa: "));
				comprobacion = true;
			} catch (Exception e) {
				logger.error(e.toString());
			}
		} while (comprobacion != true);
		return director;
	}

}
