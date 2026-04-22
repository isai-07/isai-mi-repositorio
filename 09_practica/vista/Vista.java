package vista;

import java.util.Scanner;
import java.util.InputMismatchException;
import utileria.excepciones.*;
import static utileria.validaciones.Validador.*;
import static utileria.formato.Formateador.*;
import static utileria.formato.Colores.*;



public class Vista {
	private final int TAM;	
	private final Scanner leer = new Scanner(System.in);	

	public Vista(int TAM) {
		this.TAM = TAM;
	}
		
	public void mensaje(String mensaje) {
		System.out.print(mensaje);
	}

	public void mensajeln(String mensaje) {
		System.out.println(mensaje);
	}
	
	public int mostrarMenu() {
		System.out.println(menuCaja("MENU","Crear cuenta,Iniciar Sesión,Salir", TAM));
		return leerEntero();
	}

	public void opcionMenuNoValida() {
		mensajeln(error("Opción no válida"));
	}

	public void mostrarOpcionCrearCuenta(){
		System.out.println(tituloBloque("Crear cuenta", "═", TAM));
	}

	public void mostrarOpcionIniciarSesion() {
		mensajeln(tituloBloque("Iniciar Sesión", "═", TAM));
	}

	public String crearNombre() {
		while(true) {
			mensaje("[?] Nombre: ");
			String cadena = leer.nextLine();

			try {
				validarCadena(cadena);
				return cadena;
			} catch(CadenaVaciaException e) {
				mensajeln(error(e.getMessage()));
			} catch(CadenaConEspaciosException e) {
				mensajeln(error(e.getMessage()));
			}
		}
	}

	public String crearApellido() {
		while(true) {
			mensaje("[?] Apellido: ");
			String cadena = leer.nextLine();

			try {
				validarCadena(cadena);
				return cadena;
			} catch(CadenaVaciaException e) {
				mensajeln(error(e.getMessage()));
			} catch(CadenaConEspaciosException e) {
				mensajeln(error(e.getMessage()));
			}
		}
	}

	public String crearUsuario() {
		while(true) {
			mensaje("[?] Usuario: ");
			String cadena = leer.nextLine();

			try {
				validarCadena(cadena);
				return cadena;
			} catch(CadenaVaciaException e) {
				mensajeln(error(e.getMessage()));
			} catch(CadenaConEspaciosException e) {
				mensajeln(error(e.getMessage()));
			}
		}
	}

	public void existeUsuario(String usuarioExistente){
		mensajeln(error("'%s' ya existe, intenta con otro usuario".formatted(usuarioExistente)));
	}

	public void mostrarCriterioContrasena() {
		String texto = "[i] INFO: La contraseña debe contener al menos 6 caracteres, 1 mayúscula, 1 número y 1 símbolo";
		texto = texto(texto, TAM);
		texto = texto.replace("[i] INFO:", CIAN_CLARITO + "[i] INFO:" + RESET);
		mensajeln(texto);
	}

	public String crearContrasena() {
		while(true) {
			mensaje("[?] Contraseña: ");
			String cadena = leer.nextLine();

			try {
				validarCadena(cadena);
				validarContrasena(cadena);
				return cadena;
			} catch(CadenaVaciaException e) {
				mensajeln(error(e.getMessage()));
			} catch(CadenaConEspaciosException e) {
				mensajeln(error(e.getMessage()));
			} catch(MinimoCaracteresException e) {
				mensajeln(error(e.getMessage()));
			} catch(NoMayusculaException e) {
				mensajeln(error(e.getMessage()));
			} catch(NoNumeroException e) {
				mensajeln(error(e.getMessage()));
			} catch(NoSimboloException e) {
				mensajeln(error(e.getMessage()));
			}
		}
	}

	public boolean confirmarContrasena(String contrasena) {
		mensaje("[?] Confirma la contraseña: ");
		String reintentoContrasena = leer.nextLine();

		if(!contrasena.equals(reintentoContrasena)) {
			mensajeln(error("La contraseña no coincide"));
		}

		return contrasena.equals(reintentoContrasena);
	}

	public void confirmacionCuentaCreada(String usuario) {
		String texto = "[✓] COMPLETADO: ¡Cuenta creada con éxito! Bienvenido @%s".formatted(usuario);
		texto = texto(texto, TAM);
		texto = texto.replace("[✓] COMPLETADO:", VERDE + "[✓] COMPLETADO:" + RESET);
		mensajeln(texto);
	}

	public String pedirInicioSesionUsuario() {
		mensaje("[?] Usuario: ");
		return leer.nextLine();
	}

	public void noExisteUsuario(String usuario) {
		mensajeln(error("'%s' no existe".formatted(usuario)));
	}

	public String pedirInicioSesionContrasena() {
		mensaje("[?] Contraseña: ");
		return leer.nextLine();
	}

	public void confirmacionSesionIniciada(String usuario) {
		String texto = "[✓] COMPLETADO: ¡Has Iniciado Sesión! Hola de vuelta @%s".formatted(usuario);
		texto = texto(texto, TAM);
		texto = texto.replace("[✓] COMPLETADO:", VERDE + "[✓] COMPLETADO:" + RESET);
		mensajeln(texto);
	}

	public void contrasenaIncorrecta() {
		mensajeln(error("Contraseña incorrecta"));
	}

	public int leerEntero() {
		while(true) {	
			try {
				System.out.print(">>> ");
				int entero = leer.nextInt();
				leer.nextLine();
				return entero;
			}catch(InputMismatchException e){
				leer.nextLine();
				mensajeln(error("Ingresa un número entero"));
			}
		}
	}
}