package utileria.formato;

public class Colores {
    public static final String RESET = "\u001b[0m";

    public static final String ROJO = "\u001b[38;2;255;0;0m";
    public static final String VERDE = "\u001b[38;2;0;255;0m";
    public static final String AZUL = "\u001b[38;2;0;0;255m";
    public static final String AMARILLO = "\u001b[38;2;255;255;0m";
    public static final String BLANCO = "\u001b[38;2;255;255;255m";

    public static final String VERDE_NEON = "\u001b[38;2;57;255;20m";
    public static final String CIAN_CLARITO = "\u001b[38;2;0;255;255m";
    public static final String MAGENTA_HACKER = "\u001b[38;2;255;0;255m";
    public static final String NARANJA_ALERTA = "\u001b[38;2;255;102;0m";
    public static final String AMARILLO_RADIOACTIVO = "\u001b[38;2;224;255;51m";

    public static final String ROSA_PASTEL = "\u001b[38;2;255;182;193m";
    public static final String AZUL_PASTEL = "\u001b[38;2;173;216;230m";
    public static final String VERDE_PASTEL = "\u001b[38;2;152;251;152m";
    public static final String AMARILLO_PASTEL = "\u001b[38;2;253;253;150m";
    public static final String LILA_SUAVE = "\u001b[38;2;200;162;200m";

    public static final String GRIS_OSCURO = "\u001b[38;2;105;105;105m";
    public static final String GRIS_CLARO = "\u001b[38;2;169;169;169m";
    public static final String AZUL_MARINO = "\u001b[38;2;0;0;128m";
    public static final String ROJO_VINO = "\u001b[38;2;128;0;0m";
    public static final String VERDE_OLIVA = "\u001b[38;2;128;128;0m";

    public static final String FONDO_ROJO_ERROR = "\u001b[48;2;200;0;0m";
    public static final String FONDO_BLANCO = "\u001b[48;2;255;255;255m";
    public static final String FONDO_VERDE_EXITO = "\u001b[48;2;0;150;0m";

    public static String error(String mensaje){
        return "%s[!] ERROR:%s %s".formatted(ROJO, RESET, mensaje);
    }

    public static String exito(String mensaje){
        return "%s[✓] COMPLETADO:%s %s".formatted(VERDE, RESET, mensaje);
    }
}