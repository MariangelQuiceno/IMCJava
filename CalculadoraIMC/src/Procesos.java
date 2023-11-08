import java.util.ArrayList;
import java.util.Iterator;

public class Procesos {
	
	double imc;
	
	ArrayList <Persona> listaPersonas;
	
	public Procesos() {
		listaPersonas = new ArrayList<>();
	}
	
	public String registrarPersona(Persona persona) {
		
		String resultado = "¡Persona Registrada!  \n\n";
		
		resultado += "Documento: " + persona.getDocumento() + "\n";
		resultado += "Nombre: " + persona.getNombre() + "\n";
		resultado += "Edad: " + persona.getEdad() + "\n";
		resultado += "Peso: " + persona.getPeso() + "\n";
		resultado += "Altura: " + persona.getAltura() + "\n";
		
		 imc = persona.getPeso() / (persona.getAltura() *persona.getAltura() );
		
		String imcMsj = calcularIMC(imc);
		
		
		resultado += "" + imcMsj + "\n";
		
		persona.setImc(imc);
		
		listaPersonas.add(persona);
		
		return resultado;	
	}
	
	
	public String calcularIMC(double imc) {
		
		String msj = "";
		
		if (imc < 18) {
	        msj += "El IMC dicta: Anorexia";
	    } else if (imc < 20) {
	        msj += "El IMC dicta: Delgadez";
	    } else if (imc < 27) {
	        msj += "El IMC dicta: Normalidad";
	    } else if (imc < 30) {
	        msj += "El IMC dicta: Obesidad (Grado 1)";
	    } else if (imc < 35) {
	        msj += "El IMC dicta: Obesidad (Grado 2)";
	    } else if (imc < 40) {
	        msj += "El IMC dicta: Obesidad (Grado 3)";
	    } else {
	        msj += "El IMC dicta: Obesidad Morbida";
	    }
		
		return "IMC: " + imc + "\n" +  msj;
	}
	
	public String consultarLista() {
		
		String msj = "";
		
		Persona persona = null;
		
		for (int i = 0; i < listaPersonas.size(); i++) {
			persona = listaPersonas.get(i);
			
			msj += "Documento: " + persona.getDocumento() + "\n" +
			"Nombre: " + persona.getNombre() + "\n" +
			"Edad: " + persona.getEdad() + "\n" +
			"Altura: " + persona.getAltura() + "\n" +
			"Peso: " + persona.getPeso() + "\n" +
			"IMC: " + persona.getImc() + "\n" +
			"--------------------\n";
			
		}
		
		return msj;
		
	}
	
	
	public String calcularPromedio () {
		
		double suma = 0;
				
		for (int i = 0; i < listaPersonas.size(); i++) {
		 
			suma = suma + listaPersonas.get(i).getImc();				
	}
		
		double promedio = suma / listaPersonas.size();
		
		String resultado = "El promedio de " + calcularIMC(promedio);
		
		return resultado;
		
	}
	
public String calcularSoloIMC(double altura, double peso) {
	
	double imcAlt = peso / (altura * altura);
	
	String msj = "Su IMC es: " + imcAlt;
	
	return msj;
		
		
		
	}
	
	

}
