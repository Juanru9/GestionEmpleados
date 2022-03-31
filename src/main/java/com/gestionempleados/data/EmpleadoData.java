package com.gestionempleados.data;

import java.util.Map;

import com.gestionempleados.exception.UserNotFoundException;
import com.gestionempleados.model.Empleado;

/**
 * 
 * @author Juanru
 *
 */
public interface EmpleadoData {
	
	public int addEmpleado(Empleado empleado);
	public boolean deleteEmpleado(int indice)throws UserNotFoundException;
	public boolean promoteGerente(int indice)throws UserNotFoundException;
	public boolean incentivarEmpleados(int indice) throws UserNotFoundException;
	public boolean modificarEmpleado(int indice, Empleado empleado) throws UserNotFoundException;
	public Map<Integer, Empleado> showEmpleados() throws UserNotFoundException;

}
