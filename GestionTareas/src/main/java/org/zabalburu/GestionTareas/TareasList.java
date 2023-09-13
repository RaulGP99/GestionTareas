package org.zabalburu.GestionTareas;

import java.util.List;
import java.util.ArrayList;

import org.zabalburu.GestionTareas.modelo.Empleado;
import org.zabalburu.GestionTareas.modelo.Tarea;

public class TareasList implements TareasDao {

	private static TareasList tl = null;
	private List<Empleado> empleados = new ArrayList<>();
	private List<Tarea> tareas = new ArrayList<>();
	
	public static TareasList getInstance() {
		if (tl == null) {
			tl = new TareasList();
		}
		return tl;
	}
	
	@Override
	public Empleado getEmpleado(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	@Override
	public Empleado nuevoEmpleado(Empleado e) {
		Integer id = 1;
		if (empleados.size()>0) {
			id = empleados.stream()
					.max((e1,e2) -> e1.getId() - e2.getId())
					.map(emp -> emp.getId() + 1)
					.get();
		}
		e.setId(id);
		empleados.add(e);
		return e;
	}

	@Override
	public Tarea getTarea(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarea nuevaTarea(Tarea t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado login(String nombre, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
