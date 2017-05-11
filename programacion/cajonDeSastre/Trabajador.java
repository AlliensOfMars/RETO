public abstract class Trabajador {

	private int id;
	private String dni;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String categoria;
	private String calle;
	private int numero;
	private int piso;
	private String mano;
	private String ciudad;
	private int codigoPostal;
	private String provincia;
	private int movilEmpresa;
	private int movilPersonal;
	private double salario;
	private Date fechaNacimiento;

	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return this.dni;
	}

	/**
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	/**
	 * 
	 * @param primerApellido
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	/**
	 * 
	 * @param segundoApellido
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCategoria() {
		return this.categoria;
	}

	/**
	 * 
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCalle() {
		return this.calle;
	}

	/**
	 * 
	 * @param calle
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return this.numero;
	}

	/**
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return this.piso;
	}

	/**
	 * 
	 * @param piso
	 */
	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getMano() {
		return this.mano;
	}

	/**
	 * 
	 * @param mano
	 */
	public void setMano(String mano) {
		this.mano = mano;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	/**
	 * 
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCodigoPostal() {
		return this.codigoPostal;
	}

	/**
	 * 
	 * @param codigoPostal
	 */
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return this.provincia;
	}

	/**
	 * 
	 * @param provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getMovilEmpresa() {
		return this.movilEmpresa;
	}

	/**
	 * 
	 * @param movilEmpresa
	 */
	public void setMovilEmpresa(int movilEmpresa) {
		this.movilEmpresa = movilEmpresa;
	}

	public int getMovilPersonal() {
		return this.movilPersonal;
	}

	/**
	 * 
	 * @param movilPersonal
	 */
	public void setMovilPersonal(int movilPersonal) {
		this.movilPersonal = movilPersonal;
	}

	public double getSalario() {
		return this.salario;
	}

	/**
	 * 
	 * @param salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	/**
	 * 
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}