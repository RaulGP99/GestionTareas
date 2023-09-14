package org.zabalburu.GestionTareas.dao.servicio;

import java.util.List;

import org.zabalburu.GestionTareas.dao.TareasDao;
import org.zabalburu.GestionTareas.dao.TareasList;
import org.zabalburu.GestionTareas.dao.modelo.Empleado;
import org.zabalburu.GestionTareas.dao.modelo.Tarea;

public class TareasServicio {
	private TareasList tl = TareasList.getInstance();
	
	public Empleado getEmpleado(Integer id) {
		return tl.getEmpleado(id);
	}

	public List<Empleado> getEmpleados() {
		return tl.getEmpleados();
	}

	public Empleado nuevoEmpleado(Empleado e) {
		return tl.nuevoEmpleado(e);
	}

	public Tarea getTarea(Integer id) {
		return tl.getTarea(id);
	}

	public Tarea nuevaTarea(Tarea t) {
		return tl.nuevaTarea(t);
	}

	public Empleado login(String nombre, String password) {
		return tl.login(nombre, password);
	}

}
