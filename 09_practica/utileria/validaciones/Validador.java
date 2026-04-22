package utileria.validaciones;

import utileria.excepciones.*;
import vista.Vista;

public class Validador {
	private final Vista vista = new Vista(40);

	public static void validarCadena(String cadena) throws CadenaVaciaException, CadenaConEspaciosException {
		estaVacia(cadena);
		hayEspacios(cadena);
	}	

	public static void validarContrasena(String cadena) throws CadenaVaciaException, CadenaConEspaciosException, MinimoCaracteresException, NoMayusculaException, NoNumeroException, NoSimboloException {
		validarCadena(cadena);
		hayMinimoCaracteres(cadena);
		hayMayuscula(cadena);
		hayNumero(cadena);
		haySimbolo(cadena);
	}
	
	private static void estaVacia(String cadena) throws CadenaVaciaException {
		if(cadena.isEmpty()) {
			throw new CadenaVaciaException("Campo vacío");
		}
	}

	private static void hayEspacios(String cadena) throws CadenaConEspaciosException {
		if(cadena.contains(" ")) {
			throw new CadenaConEspaciosException("'%s' contiene espacios".formatted(cadena));
		}
	} 

	private static void hayMinimoCaracteres(String cadena) throws MinimoCaracteresException {
		if(cadena.length() < 6) {
			throw new MinimoCaracteresException("'%s' tiene menos de 6 caracteres".formatted(cadena));
		}
	}

	private static void hayMayuscula(String mensaje) throws NoMayusculaException {
		boolean hayMayus = false;
	
		for(int i = 0; i < mensaje.length(); i++) {
			if(Character.isUpperCase(mensaje.charAt(i))) {
				hayMayus = true;
			}
		}

		if(!hayMayus) {
			throw new NoMayusculaException("'%s' no contiene mayúsculas".formatted(mensaje));
		}
		
 	}

	private static void hayNumero(String mensaje) throws NoNumeroException {
		boolean hayNum = false;

		for(int i = 0; i < mensaje.length(); i++)	{
			if(Character.isDigit(mensaje.charAt(i))) {
				hayNum = true;
			}
		}

		if(!hayNum) {
			throw new NoNumeroException("'%s' no contiene números".formatted(mensaje));
		}
	}

	private static void haySimbolo(String mensaje) throws NoSimboloException {
		boolean haySimbolo = false;

		for(int i = 0; i < mensaje.length(); i++) {
			if(!Character.isLetterOrDigit(mensaje.charAt(i))) {
				haySimbolo = true;
			}
		}

		if(!haySimbolo) {
			throw new NoSimboloException("'%s' no contiene símbolos".formatted(mensaje));
		}
	}
}