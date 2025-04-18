package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;
import model.Empleado;

public class EmpleadoService {
	
	public int isExists(String rut) {
		int output = 0;
		try {
			Statement st = getConexion().createStatement();
			String sql = "SELECT rut FROM empleado WHERE rut = '"+rut+"'";		
			ResultSet rs = st.executeQuery(sql);			
			while(rs.next()) {
				output = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return output;
	}
	
	public JSONArray getAll(){
		JSONArray data = new JSONArray();	
		try {
			Statement st = getConexion().createStatement();
			String sql = "SELECT * FROM empleado";
			ResultSet rs = st.executeQuery(sql);			
			while(rs.next()) {
				Empleado emp = new Empleado();
				JSONObject row = new JSONObject();
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setRut(rs.getString("rut"));
				emp.setCargo(rs.getString("cargo"));
				emp.setSalario(rs.getInt("salario"));
				emp.setBonos(rs.getInt("bonos"));
				emp.setDescuentos(rs.getInt("descuentos"));				
				row.put("nombre", emp.getNombre());
				row.put("apellido", emp.getApellido());
				row.put("rut", emp.getRut());
				row.put("cargo", emp.getCargo());
				row.put("salario", emp.getSalario());
				row.put("bonos", emp.getBonos());
				row.put("descuentos", emp.getDescuentos());
				data.put(row);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return data;
	}
	
	public int add(Empleado emp) {		
		int output = 0;
		try {
			Statement st = getConexion().createStatement();
			String sql = "INSERT INTO empleado (nombre,apellido,rut,cargo,salario,bonos,descuentos) "
						+ "VALUES ('"+emp.getNombre()+"',"
								+ "'"+emp.getApellido()+"',"
								+ "'"+emp.getRut()+"',"
								+ "'"+emp.getCargo()+"',"
								+ ""+emp.getSalario()+","
								+ ""+emp.getBonos()+","
								+ ""+emp.getDescuentos()+")";			
			output = st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return output;
	}	
	
	public int delete(Integer id) {
		int output = 0;		
		try {
			Statement st = getConexion().createStatement();
			String sql = "DELETE FROM empleado WHERE id = "+id;
			output = st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return output;
	}
	
	public Connection getConexion() throws ClassNotFoundException, SQLException {
		String dbName = "jdbc:postgresql://localhost:5432/postgres";
		String dbDriver = "org.postgresql.Driver";
		String user = "postgres";
		String password = "admin";
		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbName,user,password);
		return con;
	}
	
}