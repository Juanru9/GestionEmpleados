package com.gestionempleados.data;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

import com.gestionempleados.exception.UserNotFoundException;
import com.gestionempleados.model.Director;
import com.gestionempleados.model.Empleado;
import com.gestionempleados.model.Gerente;
import com.gestionempleados.util.LeerTeclado;

public class EmpleadoDataImplement implements EmpleadoData {
	// Llamamos a log4j2:
	private static Logger logger = LogManager.getLogger(EmpleadoDataImplement.class);

	// Creamos un HashMap para guardar a toda la plantilla
	private Map<Integer, Empleado> plantilla = new HashMap<>();
	private int indice = 1;

	@Override
	public int addEmpleado(Empleado empleado) {
		if (plantilla.isEmpty()) {
			plantilla.put(indice, empleado);
		} else {
			indice++;
			plantilla.put(indice, empleado);
		}
		return indice;
	}
	
	@Override
	public boolean deleteEmpleado(int indice) throws UserNotFoundException{
		Empleado e = plantilla.remove(indice);
		if (e != null) {
			return true;
		} else {
			throw new UserNotFoundException(indice);
		}
	}

	@Override
	public boolean promoteGerente(int indice) throws UserNotFoundException{
		if (plantilla.containsKey(indice) & plantilla.get(indice).getClass() == Empleado.class) {
			try {
				plantilla.replace(indice,
						new Director(plantilla.get(indice).getNombre(), plantilla.get(indice).getSalario(),
								plantilla.get(indice).getFechaNacimiento(),
								LeerTeclado.leerString("Introduzca la matrícula de su nuevo coche de empresa: ")));
				logger.info(
						"El empleado " + plantilla.get(indice).getNombre() + " ha sido ascendido a Gerente, matrícula: "
								+ ((Director) plantilla.get(indice)).getMatricula());
				return true;
			} catch (Exception e) {
				logger.error(e.toString());
				return false;
			}
		} else {
			throw new UserNotFoundException("No se ha encontrado un empleado con rango básico para su ascenso con la ID: "+indice);
		}
	}

	@Override
	public Map<Integer, Empleado> showEmpleados() throws UserNotFoundException {
		if (plantilla.isEmpty()) {
			String msg = "No existe ningún empleado dado de alta.";
			throw new UserNotFoundException(msg);
		}
		return plantilla;
	}
	
	@Override
	public boolean incentivarEmpleados(int indice) throws UserNotFoundException {
		if (!plantilla.containsKey(indice) || plantilla.get(indice).getClass() == Empleado.class) {
			logger.warn("No existe ningún gerente/director con esa ID.");
			throw new UserNotFoundException(indice);
		}
		else if (plantilla.get(indice).getClass() == Gerente.class) {
			((Gerente) plantilla.get(indice)).darIncentivo();
			return true;
		}
		else if (plantilla.get(indice).getClass() == Director.class) {
			((Director) plantilla.get(indice)).darIncentivo();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean modificarEmpleado(int indice, Empleado e) throws UserNotFoundException {
		if (!plantilla.containsKey(indice)) {
			logger.warn("No existe ningún gerente/director con esa ID.");
			throw new UserNotFoundException(indice);
		}
		else {
			plantilla.put(indice, e);
		}
		return false;
	}


}
