# Proyecto de Programación de Sistemas Base 1 :mask:
 Proyecto de la clase "Programación de Sistemas Base 1"
 Este proyecto es un analizador léxico que funciona como una herramienta de procesamiento de lenguaje natural. El
 objetivo principal es separar una cadena de entrada en tokens y etiquetas asociadas, que se pueden utilizar para 
 ompilar o interpretar un programa. El proyecto está escrito en Java y utiliza la biblioteca JFlex para la generación del
 analizador léxico. 

## Ejemplo Reglas
Un ejemplo de reglas en este proyecto son
```
Numero <- 0|1|2|3|4|5|6|7|8|9
Letras <- a|b|c|...|z|A|B|C|...|Z
Logicos <- AND|OR|NOT
ect...
```

## Generacion de Reglas
El funcionamiento del programa se basa en la definición de reglas en un archivo de especificación léxica (.flex). Estas reglas definen los patrones que el analizador debe buscar en el archivo de entrada para identificar cada uno de los tokens. 

```Java
Lexema - AFlex.flex
```

Para generar el archivo Flex.java en la version JFlex - 1.9.1 debe generar con la ruta absoluta del archivo .flex :mask:

```Java
public class Generador {

    public static void main(String[] args) throws Exception{
        String ruta = "ruta del archivo../AFlex.flex"; //Cambiar por la ruta del archivo en tu PC.
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
```

Una vez generado el archivo Flex.java, en caso de error de package con la clase tokens debe indicar su ubicación

```Java
import static Lexema.Tokens.*;
```

Este caso la clase Tokens esta en la carpeta *Lexema* 😷

## Uso del proyecto  :nerd_face: ☝️

Ejecutar la clase Main.java el contructor lexer analizara el archivo *input.txt* y regresara un archivo de texto *output.txt*

```Java
// Generar y escribir tokens en el archivo de salida
        Tokens token;
        while ((token = lexer.yylex()) != null) {
            out.write(token.toString() + "\n");
        }
```

Entrada: *Prueba Git - Luis AND Alardin -3.1416 < if / while Reyna505 public 123 * static false ©*

Salida: *Identificador Identificador Resta Identificador Identificador Identificador Numero Relacional Reservadas Dividir Reservadas Identificador Reservadas Numero Multiplicar Reservadas Reservadas ERROR*
