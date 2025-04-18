package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import model.Empleado;
import javax.servlet.http.HttpServletRequest;

public class NominaController {
	private EmpleadoController empleadoController = new EmpleadoController();
	
	public void calcular(HttpServletRequest request) throws IOException {		
		List<Empleado> lista = new ArrayList<Empleado>();
		Stream<String> json = new BufferedReader(new InputStreamReader(request.getInputStream())).lines();
		
		json.forEach(eee -> {	
			String[] linea = eee.split(",");
			Empleado emp = new Empleado();
			emp.setRut(linea[0]);
			emp.setNombre(linea[1]);
			emp.setApellido(linea[2]);
			emp.setCargo(linea[3]);
			emp.setSalario(linea[4]);
			emp.setBonos(linea[5]);
			emp.setDescuentos(linea[6]);			
			lista.add(emp);			
		});
		
		for (int i=1; i<lista.size(); i++) {
			empleadoController.add(lista.get(i));
		}		
	}
	
}