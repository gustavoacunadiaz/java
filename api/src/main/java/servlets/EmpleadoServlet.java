package servlets;

import org.json.JSONArray;
import controller.EmpleadoController;
import model.Empleado;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empleados")
public class EmpleadoServlet extends HttpServlet {		
	private static final long serialVersionUID = 1L;
	private EmpleadoController empleadoController = new EmpleadoController();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		System.out.println("En el doGet()");
		JSONArray lista = empleadoController.getAll();	
		System.out.println(lista);
		response.getWriter().append(lista.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empleado emp = new Empleado(0, request.getParameter("nombre").toString(), 
									request.getParameter("apellido").toString(),
									request.getParameter("rut").toString(), 
									request.getParameter("cargo").toString(), 
									Integer.parseInt(request.getParameter("salario")), 
									Integer.parseInt(request.getParameter("bonos")), 
									Integer.parseInt(request.getParameter("descuentos")));
		int resp = empleadoController.add(emp);
		response.getWriter().append(resp==1?"Empleado AGREGADO!":"Empleado NO agregado.");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("En el doDelete()");	
		String json = new BufferedReader(new InputStreamReader(request.getInputStream())).lines().collect( Collectors.joining("\n"));
		String[] line = json.split("=");
		int resp = empleadoController.delete(Integer.parseInt(line[1]));
		response.getWriter().append(resp==1?"Empleado ELIMINADO!":"Empleado NO eliminado.");
	}

}