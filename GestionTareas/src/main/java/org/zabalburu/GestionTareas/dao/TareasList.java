package org.zabalburu.GestionTareas.dao;

import java.util.List;

import org.zabalburu.GestionTareas.dao.modelo.Empleado;
import org.zabalburu.GestionTareas.dao.modelo.Tarea;

import java.util.ArrayList;
import java.util.GregorianCalendar;

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
	
	private TareasList() {
		empleados.add(new Empleado(1,"López Marín","Juan","juan@empresa.com","12345",new ArrayList<>()));
		empleados.add(new Empleado(2,"Cáceres Royo","Ana","ana@empresa.com","12345",new ArrayList<>()));
		empleados.add(new Empleado(3,"Arias Brito","Miren","miren@empresa.com","12345",new ArrayList<>()));
		empleados.add(new Empleado(4,"Lorente Font","Carlos","carlos@empresa.com","12345",new ArrayList<>()));
		empleados.add(new Empleado(5,"Gallardo Romero","Eva","eva@empresa.com","12345",new ArrayList<>()));
		nuevaTarea(new Tarea(1,empleados.get(0),"Análisis del Proyecto de ENVASA", new GregorianCalendar(2023,9,5).getTime(),new GregorianCalendar(2023,10,5).getTime()));
		nuevaTarea(new Tarea(2,empleados.get(2),"Requerimientos de IBEX", new GregorianCalendar(2023,9,15).getTime(),new GregorianCalendar(2023,9,21).getTime()));
		nuevaTarea(new Tarea(3,empleados.get(0),"Desarrollo Aplicación ENVASA", new GregorianCalendar(2023,10,5).getTime(),new GregorianCalendar(2023,11,25).getTime()));
		nuevaTarea(new Tarea(4,empleados.get(1),"Desarrollo Aplicación ENVASA", new GregorianCalendar(2023,10,5).getTime(),new GregorianCalendar(2023,11,25).getTime()));
		nuevaTarea(new Tarea(5,empleados.get(2),"Análisis Aplicación IBEX", new GregorianCalendar(2023,9,21).getTime(),new GregorianCalendar(2023,10,11).getTime()));
		nuevaTarea(new Tarea(6,empleados.get(0),"Testeo Aplicación ENVASA", new GregorianCalendar(2023,10,23).getTime(),new GregorianCalendar(2023,10,28).getTime()));
		
	}
	
	@Override
	public Empleado getEmpleado(Integer id) {
		// TODO Auto-generated method stub
		return empleados.stream()
				.filter(e -> e.getId().equals(id))
				.findAny()
				.orElse(null);
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
		return tareas.stream()
				.filter(t -> t.getId().equals(id))
				.findAny()
				.orElse(null);
	}

	@Override
	public Tarea nuevaTarea(Tarea t) {
		Integer id = 1;
		if (tareas.size()>0) {
			id = tareas.stream()
					.max((t1,t2) -> t1.getId() - t2.getId())
					.map(tar -> tar.getId() + 1)
					.get();
		}
		t.setId(id);
		tareas.add(t);
		t.getEmpleado().getTareas().add(t);
		return t;
	}

	@Override
	public Empleado login(String nombre, String password) {
		Empleado emp = empleados.stream()
				.filter(e -> e.getEmail().equalsIgnoreCase(nombre)
					&& e.getPassword().equals(password))
				.findAny().
				orElse(null);
		return emp;
	}
	
	public List<Tarea> getTareas() {
		return tareas;
	}
	

}
