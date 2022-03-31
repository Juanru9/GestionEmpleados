package com.gestionempleados;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gestionempleados.model.Director;
import com.gestionempleados.model.Empleado;
import com.gestionempleados.model.Gerente;
import com.gestionempleados.service.EmpleadoService;
import com.gestionempleados.data.EmpleadoDataImplement;
import com.gestionempleados.exception.UserNotFoundException;
import com.gestionempleados.data.EmpleadoData;

/**
 * Unit test for simple App.
 */

class TestEmpleadoServiceImplement {

	private Empleado empleado;
	private Gerente gerente;
	private Director director;
	private EmpleadoData lista;

	@BeforeEach
	void setUp() throws Exception {
		// Instanciamos un empleado con el constructor principal
		this.empleado = new Empleado("Juan", 50000, "05/01/1985");
		this.gerente = new Gerente("Paco de Lucia", 70000, "21/06/1955");
		this.director = new Director("Antonio Santos", 90000, "30/09/1980", "1974CNP");
		this.lista = new EmpleadoDataImplement();
		// System.out.println("Medante el constructor se ha creado a
		// "+empleado.toString());
	}

	@Test
	void testSiCreoUnEmpleadoElContructorFuncionaOK() {
		// Given: El admin crea un empleado
		// When: Se introducen sus datos por el cosntructor
		// Then: Los datos introducidos coinciden con lo mostrado por los getters
		assertThat(empleado.getNombre()).isEqualTo("Juan");
		assertThat(empleado.getSalario()).isEqualTo(50000);
		assertThat(empleado.getFechaNacimiento()).isEqualTo("05/01/1985");
	}

	@Test
	void seIntroduceEmpleadoALaListaOK() {
		// Given: El admin introduce al empleado en la capa de datos por el metodo
		// addEmpleado
		int id = lista.addEmpleado(empleado);
		// When: Se busca el empleado en la lista
		// Then: Los datos introducidos coinciden con lo mostrado por lo introducido en
		// la lista
		try {
			assertThat(id).isNotNull();
			assertThat(empleado.getNombre()).isEqualTo(lista.showEmpleados().get(id).getNombre());
			assertThat(empleado.getSalario()).isEqualTo(lista.showEmpleados().get(id).getSalario());
			assertThat(empleado.getFechaNacimiento()).isEqualTo(lista.showEmpleados().get(id).getFechaNacimiento());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void seIntroduceGerenteALaListaOK() {
		// Given: El admin introduce los datos del gerente
		// When: El admin introduce al gerente en la capa de datos por el metodo
		// addEmpleado
		int id = lista.addEmpleado(gerente);
		// Then: Los datos introducidos coinciden con lo mostrado por lo introducido en
		// la lista
		try {
			assertThat(id).isNotNull();
			assertThat(gerente.getNombre()).isEqualTo(lista.showEmpleados().get(id).getNombre());
			assertThat(gerente.getSalario()).isEqualTo(lista.showEmpleados().get(id).getSalario());
			assertThat(gerente.getFechaNacimiento()).isEqualTo(lista.showEmpleados().get(id).getFechaNacimiento());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void seIntroduceDirectorALaListaOK() {
		// Given: El admin introduce al director en la capa de datos por el metodo
		// addEmpleado

		int id = lista.addEmpleado(director);
		// When: Se busca el empleado en la lista
		// Then: Los datos introducidos coinciden con lo mostrado por lo introducido en
		// la lista
		try {
			assertThat(id).isNotNull();
			assertThat(director.getNombre()).isEqualTo(lista.showEmpleados().get(id).getNombre());
			assertThat(director.getSalario()).isEqualTo(lista.showEmpleados().get(id).getSalario());
			assertThat(director.getFechaNacimiento()).isEqualTo(lista.showEmpleados().get(id).getFechaNacimiento());
			assertThat(director.getMatricula()).isEqualTo(((Director) lista.showEmpleados().get(id)).getMatricula());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void seBorraEmpleadoDeLaListaOK() {
		// Given: El Admin introduce a 3 empleados en la lista
		boolean borrado = false;
		int id = lista.addEmpleado(empleado);
		int id2 = lista.addEmpleado(gerente);
		int id3 = lista.addEmpleado(director);
		// When: Se introduce al usuario en el metodo de borrado`
		try {
			borrado = lista.deleteEmpleado(id);
		} catch (UserNotFoundException e1) {
			e1.printStackTrace();
		}
		// Then: Se comprueba que el usuario ya no está en la lista
		try {
			assertThat(lista.showEmpleados().get(id)).isNull();
			assertThat(borrado).isEqualTo(true);
			// And: La dimension del HashMap se ha decrementado en 1 unidad
			assertThat(lista.showEmpleados().size()).isEqualTo(2);
			// And: La ID de usuario va autoincrementandose
			assertThat(id).isNotNull();
			assertThat(id2).isGreaterThan(id);
			assertThat(id3).isGreaterThan(id2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
