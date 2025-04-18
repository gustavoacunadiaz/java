package model;

public class Empleado {	
	private Integer id;
	private String nombre;
	private String apellido;
	private String rut;
	private String cargo;
	private Integer salario;
	private Integer bonos;
	private Integer descuentos;
	
	public Empleado() {
		super();
	}
	
	public Empleado(Integer id, String nombre, String apellido, String rut, String cargo, Integer salario, Integer bonos, Integer descuentos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.cargo = cargo;
		this.salario = salario;
		this.bonos = bonos;
		this.descuentos = descuentos;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getSalario() {
		return salario;
	}
	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	public Integer getBonos() {
		return bonos;
	}
	public void setBonos(Integer bonos) {
		this.bonos = bonos;
	}
	public Integer getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(Integer descuentos) {
		this.descuentos = descuentos;
	}
	
}