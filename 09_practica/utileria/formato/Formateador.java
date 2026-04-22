package utileria.formato;

public class Formateador{

	public static String lista(String opcionesMenu){
		StringBuilder lista = new StringBuilder();

		String[] opciones = opcionesMenu.split(",");
		for(int i = 0; i < opciones.length; i++){
			lista.append("%d. %s\n".formatted((i + 1), opciones[i]));
		}
		return lista.toString();
	}
	public static String texto(String texto, int tam) {
		StringBuilder parrafo = new StringBuilder();

		while(texto.length() > tam) {
			boolean hayCorte = false;
			for(int i = tam; !hayCorte && i >= 0; i--) {
				if (texto.charAt(i) == ' ') {
					parrafo.append(texto, 0, i+1);
					parrafo.setCharAt(parrafo.length() - 1, '\n');
					texto = texto.substring(i+1);
					hayCorte = true;
				}
			}
			if(!hayCorte) {
				parrafo.append(texto, 0, tam+1);
				parrafo.setCharAt(parrafo.length() - 1, '\n');
				texto = texto.substring(tam);
			}
		}

		parrafo.append(texto);
		return parrafo.toString();
	}

	public static String menuCaja(String titulo, String opcionesMenu, int tamTitulo) {
		StringBuilder menu = new StringBuilder();
		int tamLineaHorizontal = tamTitulo - 2;
		int inicioTitulo = (tamTitulo - titulo.length() - 2) / 2;

		menu.append("╔");
		menu.append("═".repeat(tamLineaHorizontal));
		menu.append("╗\n");

		titulo = " " + titulo + " ";
		menu.replace(inicioTitulo, titulo.length() + inicioTitulo, titulo.toUpperCase());

		String[] opciones = opcionesMenu.split(",");
		int opcUbi = tamTitulo - 7;
		for(int i = 0; i < opciones.length; i++){
			String linea = ("║ %d. %-"+opcUbi+"s ║\n").formatted((i + 1), opciones[i]);
			menu.append(linea);
		}

		menu.append("╚");
		menu.append("═".repeat(tamLineaHorizontal));
		menu.append("╝");

		return menu.toString();
	}

	public static String titulo(String palabraTitulo, String separador, int tamTitulo){
		StringBuilder titulo = new StringBuilder();

		int lado = (tamTitulo - palabraTitulo.length() - 2) / 2;
		int ladoDer = lado;
		
		if((tamTitulo - palabraTitulo.length()) % 2 == 1) ladoDer++;

		titulo.append(separador.repeat(lado));
		titulo.append(" %s ".formatted(palabraTitulo.toUpperCase()));
		titulo.append(separador.repeat(ladoDer));

		return titulo.toString();
	}

	public static String tituloBloque(String palabraTitulo, String separador, int tamTitulo) {
		StringBuilder titulo = new StringBuilder();

		titulo.append(separador.repeat(tamTitulo));
		titulo.append("\n");
		titulo.append(titulo(palabraTitulo, " ", tamTitulo));
		titulo.append("\n");
		titulo.append(separador.repeat(tamTitulo));

		return titulo.toString();
	}

	public static String tituloCaja(String palabra, int anchoTitulo, int padding){
		StringBuilder titulo = new StringBuilder();

		titulo.append("╔");
		titulo.append("═".repeat(anchoTitulo - 2));
		titulo.append("╗\n");

		for(int i = 0; i < padding; i++){
			titulo.append("║");
			titulo.append(" ".repeat(anchoTitulo - 2));
			titulo.append("║\n");
		}

		titulo.append("║");
		titulo.append(titulo(palabra, " ", anchoTitulo - 2));
		titulo.append("║\n");

		for(int i = 0; i < padding; i++){
			titulo.append("║");
			titulo.append(" ".repeat(anchoTitulo - 2));
			titulo.append("║\n");
		}

		titulo.append("╚");
		titulo.append("═".repeat(anchoTitulo - 2));
		titulo.append("╝");

		return titulo.toString();
	}
}