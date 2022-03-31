package com.gestionempleados.model;

import com.gestionempleados.gui.Gui;
import com.gestionempleados.util.LeerTeclado;

public class ModificaEmpleos {
	
	public static Empleado modificador(Empleado emp) throws Exception {
		
		Gui.modEmpleado();
		
		boolean comprobacion = false;
		do {
				switch (LeerTeclado.leerByte(
						"Seleccione qué atributo modificar:\n(1)-> Nombre\n(2)-> Sueldo base\n(3)-> Edad\n--------------")) {
				case 1:
					emp.setNombre(LeerTeclado.leerString("Introduzca el nuevo nombre: "));
					comprobacion = true;
					break;
				case 2:
					emp.setSalario(LeerTeclado.leerDouble("Introduzca sueldo base: "));
					comprobacion = true;
					break;
				case 3:
					emp.setFechaNacimiento(LeerTeclado.leerString("Introduzca nueva fecha de nacimiento (dd/mm/aaaa): "));
					comprobacion = true;
					break;
				default:
					Gui.errorMenu();
				}
		} while (comprobacion != true);
		
		return emp;
	}

}
