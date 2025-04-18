package controller;

import org.json.JSONArray;
import model.Empleado;
import service.EmpleadoService;

public class EmpleadoController {
	
	private EmpleadoService empleadoService = new EmpleadoService();
	
	public JSONArray getAll(){
		return empleadoService.getAll();
	}
	
	public int add(Empleado emp) {
		if (empleadoService.isExists(emp.getRut()) != 1) {
			if (emp.getSalario() > 400000) {
				if (emp.getBonos() <= emp.getSalario()/2) {
					if (emp.getDescuentos() <= emp.getSalario()) {
						
						return empleadoService.add(emp);
						
					} else { System.out.println("El total de descuentos no puede ser mayor al salario base!!!"); }
				} else { System.out.println("Bonos no pueden superar el 50% del salario base!!!"); }
			} else { System.out.println("Salario debe ser mayor a $400.000!!!"); }
		} else { System.out.println("Rut existe!!!"); }		
		return 0;
	}
	
	public int delete(Integer id) {
		return empleadoService.delete(id);
	}
	
}