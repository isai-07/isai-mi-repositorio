package controlador;

import modelo.Cuenta;
import vista.Vista;

public class Controlador {
	private Cuenta[] cuentas = new Cuenta[100];
	private int contador;
	Vista vista;	

	
	public Controlador(Vista vista) {
		this.vista = vista;
		this.contador = 0;
	}	
	
	public void iniciar() {
		int opcion = 0;
		
		while(opcion != 3) {
			opcion = vista.mostrarMenu();
			
			switch(opcion) {
				case 1 -> crearCuenta();
				case 2 -> iniciarSesion();
				default -> vista.opcionMenuNoValida();
			}
		}
		
	}

	public void crearCuenta() {
		vista.mostrarOpcionCrearCuenta();

		String nombre = vista.crearNombre();
		String apellido = vista.crearApellido();
		String usuario = obtenerUsuarioValido();
		String contrasena = obtenerContrasenaValida();

		cuentas[contador++] = new Cuenta(nombre, apellido, usuario, contrasena);
		vista.confirmacionCuentaCreada(usuario);
	}

	public void iniciarSesion() {
		vista.mostrarOpcionIniciarSesion();

		String usuario = vista.pedirInicioSesionUsuario();
		int indiceUsuario = existeUsuario(usuario);

		if(indiceUsuario == -1) {
			vista.noExisteUsuario(usuario);
		} else {
			String contrasena = vista.pedirInicioSesionContrasena();
			if(cuentas[indiceUsuario].getContrasena().equals(contrasena)) {
				vista.confirmacionSesionIniciada(cuentas[indiceUsuario].getUsuario());
			} else {
				vista.contrasenaIncorrecta();
			}
		}
	}

	public String obtenerUsuarioValido(){
		while(true) {
			String usuario = vista.crearUsuario();
			if(existeUsuario(usuario) != -1) {
				vista.existeUsuario(usuario);
			} else {
				return usuario;
			}
		}
	}

	public int existeUsuario(String usuario) {
		for(int i = 0; i < contador; i++) {
			if(cuentas[i].getUsuario().equals(usuario)) {
				return i;
			}
		}
		return -1;
	}

	public String obtenerContrasenaValida() {
		vista.mostrarCriterioContrasena();
		String contrasena;
		do{
			contrasena = vista.crearContrasena();
		}while(!vista.confirmarContrasena(contrasena));
		return contrasena;
	}
}