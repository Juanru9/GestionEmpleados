package com.gestionempleados.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gestionempleados.control.Gestor;
import com.gestionempleados.data.EmpleadoData;
import com.gestionempleados.data.EmpleadoDataImplement;
import com.gestionempleados.exception.UserNotFoundException;
import com.gestionempleados.gui.Gui;
import com.gestionempleados.model.Empleado;
import com.gestionempleados.model.ModificaEmpleos;
import com.gestionempleados.model.CreaEmpleos;
import com.gestionempleados.util.LeerTeclado;

public class EmpleadoServiceImplement implements EmpleadoService {
	// Llamamos a log4j2:
	private static Logger logger = LogManager.getLogger(Gestor.class);
	// Invocamos a la capa de Datos
	private EmpleadoData empleados = new EmpleadoDataImplement();
	
	@Override
	public boolean addEmpleado() {
		Empleado emp = CreaEmpleos.seleccionador(); // Llamamos al que crea Empleados, gerentes o Directores
		if( emp != null) {
			empleados.addEmpleado(emp);
			return true;
		}
		else {
			Gui.errorNull();
			return false;
		}
	}
	
	@Override
	public boolean deleteEmpleado() {
		boolean comprobacion = false;
		try {
			comprobacion = empleados.deleteEmpleado(LeerTeclado.leerInt("Introduzca la ID del empleado a eliminar: "));
		} catch (Exception e) {
			logger.error(e.toString());
		}
		finally {
			if(!comprobacion) Gui.errorId();
			else Gui.deleteOk();
		}
		return comprobacion;
	}

	@Override
	public void promoteGerente() {
		boolean comprobacion = false;
		try {
			comprobacion = empleados.promoteGerente(LeerTeclado.leerInt("Introduzca la ID del empleado a ascender: "));
		} catch (Exception e) {
			logger.error(e.toString());
		}
		finally {
			if(!comprobacion) Gui.errorId();
		}
		
	}

	@Override
	public void showEmpleados() {
		try {
			empleados.showEmpleados().forEach((k,v) -> System.out.println("ID: " + k + " -> " + v));
		} catch (UserNotFoundException e) {
			logger.error(e.toString());
		}
	}
	
	@Override
	public boolean incentivarEmpleados() {
		
		boolean comprobacion = false;
		try {
			comprobacion = empleados.incentivarEmpleados(LeerTeclado.leerInt("Introduzca la ID del gerente/director: "));
		} catch (Exception e) {
			logger.error(e.toString());
		}
		finally {
			if(!comprobacion) Gui.errorId();
			else Gui.deleteOk();
		}
		return comprobacion;
	}
	
	@Override
	public boolean modificarEmpleado() {
		boolean comprobacion = false;
		try {
			int selector = LeerTeclado.leerInt("Introduzca la ID del empleado a modificar");
			comprobacion = empleados.showEmpleados().containsKey(selector);
			if (!comprobacion) throw new UserNotFoundException(selector);
			empleados.modificarEmpleado(selector, ModificaEmpleos.modificador(empleados.showEmpleados().get(selector)));
			logger.info("Usuario con ID: "+selector+" actualizado");
		} catch (UserNotFoundException e) {
			logger.error(e.toString());
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return comprobacion;
	}
	

}
