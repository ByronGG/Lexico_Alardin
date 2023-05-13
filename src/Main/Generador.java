package Main;

public class Generador {

    public static void main(String[] args) throws Exception{
        String ruta = "C:/vscode/Java/Proyecto_Lexico/Lexico_Alardin/Lexico_Alardin/src/Lexema/AFlex.flex";
        generar_lexema(ruta);
    }

    public static void generar_lexema(String ruta) {
        try {
            String[] parametros = {ruta};
            jflex.Main.generate(parametros);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error durante la generación del analizador léxico: " + e.getMessage());
        }
    }
}
