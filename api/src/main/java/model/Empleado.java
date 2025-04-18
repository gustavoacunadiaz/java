package model;

public class Empleado {	
	private String nombre;
	private String apellido;
	private String rut;
	private String cargo;
	private String salario;
	private String bonos;
	private String descuentos;
	
	public Empleado() {
		super();
	}
	
	public Empleado(String nombre, String apellido, String rut, String cargo, String salario, String bonos, String descuentos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.cargo = cargo;
		this.salario = salario;
		this.bonos = bonos;
		this.descuentos = descuentos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getBonos() {
		return bonos;
	}
	public void setBonos(String bonos) {
		this.bonos = bonos;
	}
	public String getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(String descuentos) {
		this.descuentos = descuentos;
	}
	
}