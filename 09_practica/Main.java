import vista.Vista;
import controlador.Controlador;

public class Main {
	public static void main(String[] args) {
		Vista vista = new Vista(40);
		Controlador controlador = new Controlador(vista);
		controlador.iniciar();
	}
}