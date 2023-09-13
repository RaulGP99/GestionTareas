package org.zabalburu.GestionTareas;

import java.util.List;

import org.zabalburu.GestionTareas.modelo.Empleado;
import org.zabalburu.GestionTareas.modelo.Tarea;

public interface TareasDao {
	Empleado getEmpleado(Integer id);
	List<Empleado> getEmpleados();
	Empleado nuevoEmpleado(Empleado e);
	Tarea getTarea(Integer id);
	Tarea nuevaTarea(Tarea t);
	Empleado login(String nombre, String password);
}
