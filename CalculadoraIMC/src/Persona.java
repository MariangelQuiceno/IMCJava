
public class Persona {
	
	private String documento;
	private String nombre;
	private int edad; 
	private double peso;
	private double altura;
	private double imc;
	
	public Persona() {
		
	}

	public Persona(String documento, String nombre, int edad, double peso, double altura, double imc) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		this.imc = imc;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}
	
	
	
	

}
