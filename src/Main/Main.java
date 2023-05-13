package Main;

import java.io.*;
import Lexema.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Abrir archivo de entrada y salida
        BufferedReader in = new BufferedReader(new FileReader("C:/vscode/Java/Proyecto_Lexico/Lexico_Alardin/Lexico_Alardin/src/Main/input"));
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

        // Crear instancia de AFlex
        AFlex lexer = new AFlex(in);

        // Generar y escribir tokens en el archivo de salida
        Tokens token;
        while ((token = lexer.yylex()) != null) {
            out.write(token.toString() + "\n");
        }

        // Cerrar archivos
        in.close();
        out.close();
    }
}
