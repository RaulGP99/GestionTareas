package org.zabalburu.GestionTareas.dao;

import java.util.List;

import org.zabalburu.GestionTareas.dao.modelo.Empleado;
import org.zabalburu.GestionTareas.dao.modelo.Tarea;

public interface TareasDao {
	Empleado getEmpleado(Integer id);
	List<Empleado> getEmpleados();
	Empleado nuevoEmpleado(Empleado e);
	Tarea getTarea(Integer id);
	Tarea nuevaTarea(Tarea t);
	Empleado login(String nombre, String password);
}
