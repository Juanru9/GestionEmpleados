package com.gestionempleados.control;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gestionempleados.gui.Gui;
import com.gestionempleados.service.EmpleadoService;
import com.gestionempleados.service.EmpleadoServiceImplement;
import com.gestionempleados.util.LeerTeclado;

public class Gestor {
	// Llamamos a log4j2:
	private static Logger logger = LogManager.getLogger(Gestor.class);
	// Invocamos a la capa servicios:
	private EmpleadoService empleados = new EmpleadoServiceImplement();
	
	public void menu() {
		boolean seguir = true;
		
		do {
			Gui.menu();
			try {
			// Declaración de switch
			switch(LeerTeclado.leerByte("Introduzca la opción deseada: "))
			{
			   // Declaración case,
			   // los valores deben ser del mismo tipo de la expresión
			   case 1 :
				   logger.info("Seleccionado OP1");
				   empleados.addEmpleado();
			      break;
			   
			   case 2 :
				   logger.info("Seleccionado OP2");
				   empleados.deleteEmpleado();
			      break; // break es opcional
			      
			   case 3 :
				   logger.info("Seleccionado OP3");
				   empleados.promoteGerente();
			      break; // break es opcional

			   case 4 :
				   logger.info("Seleccionado OP4");
				   empleados.showEmpleados();
				      break;
				      
			   case 5 :
				   logger.info("Seleccionado OP5");
				   empleados.incentivarEmpleados();
				      break;
				      
			   case 6 :
				   logger.info("Seleccionado OP6");
				   empleados.modificarEmpleado();
				      break;
				      
			   case 0 :
				   logger.info("Seleccionado OP0");
				   seguir = false;
				      break;

			   default : 
			      Gui.errorMenu();
			}
			
			}
			catch(Exception e) {
				logger.error(e.toString());
			}
			
		}while(seguir!=false);
		System.out.println("--> Cerrando sesión <--");
	}

}
