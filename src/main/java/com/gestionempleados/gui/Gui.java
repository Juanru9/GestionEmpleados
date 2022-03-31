package com.gestionempleados.gui;

public class Gui {
	
	public static void menu() {
		System.out.println("----------- Menú de empleados -----------\n"
						  +"| 1. Añadir nuevo empleado\n"
						  +"| 2. Eliminar un empleado\n"
						  +"| 3. Ascender a gerente\n"
						  +"| 4. Listar toda la plantilla\n"
						  +"| 5. Incentivar a Gerentes o Directores\n"
						  +"| 6. Modificar los datos de un empleado\n"
						  +"| 0. Salir\n"
						  +"-----------------------------------------");
	}
	
	public static void errorMenu() {
		System.out.println("Opción elegida inexistente, vuelva a introducir su selección.");
	}
	
	public static void errorNull() {
		System.out.println("Empleado no insertado, vuelva a intentarlo.");
	}
	
	public static void errorId() {
		System.out.println("Empleado no existente, pruebe con otro.");
	}
	
	public static void deleteOk() {
		System.out.println("Empleado eliminado con éxito.");
	}
	
	public static void modEmpleado() {
		System.out.println("Introduzca la ID del empleado a modificar:");
	}

}
