public class Parte {

	private Date fecha;
	private int kmInicial;
	private int kmFinal;
	private double gastoPeaje;
	private double gastoDietas;
	private double gastoCombustible;
	private double gastoVarios;
	private String incidencias;
	private String notasAdministrativas;
	private boolean estado;

	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getKmInicial() {
		return this.kmInicial;
	}

	/**
	 * 
	 * @param kmInicial
	 */
	public void setKmInicial(int kmInicial) {
		this.kmInicial = kmInicial;
	}

	public void getKmFinal() {
		// TODO - implement Parte.getKmFinal
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param kmFinal
	 */
	public void setKmFinal(int kmFinal) {
		this.kmFinal = kmFinal;
	}

	public double getGastoPeaje() {
		return this.gastoPeaje;
	}

	/**
	 * 
	 * @param gastoPeaje
	 */
	public void setGastoPeaje(double gastoPeaje) {
		this.gastoPeaje = gastoPeaje;
	}

	public double getGastoDietas() {
		return this.gastoDietas;
	}

	/**
	 * 
	 * @param gastoDietas
	 */
	public void setGastoDietas(double gastoDietas) {
		this.gastoDietas = gastoDietas;
	}

	public double getGastoCombustible() {
		return this.gastoCombustible;
	}

	/**
	 * 
	 * @param gastoCombustible
	 */
	public void setGastoCombustible(double gastoCombustible) {
		this.gastoCombustible = gastoCombustible;
	}

	public double getGastoVarios() {
		return this.gastoVarios;
	}

	/**
	 * 
	 * @param gastoVarios
	 */
	public void setGastoVarios(double gastoVarios) {
		this.gastoVarios = gastoVarios;
	}

	public String getIncidencias() {
		return this.incidencias;
	}

	/**
	 * 
	 * @param incidencias
	 */
	public void setIncidencias(String incidencias) {
		this.incidencias = incidencias;
	}

	public String getNotasAdministrativas() {
		return this.notasAdministrativas;
	}

	/**
	 * 
	 * @param notasAdministrativas
	 */
	public void setNotasAdministrativas(String notasAdministrativas) {
		this.notasAdministrativas = notasAdministrativas;
	}

	public boolean getEstado() {
		return this.estado;
	}

	/**
	 * 
	 * @param estado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}