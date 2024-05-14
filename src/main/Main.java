package main;

public class Main {
    public static void main(String[] args) {
        Archivo archivo = new Archivo("src/resources/palabras");
        Palabra[] palabras = archivo.getPalabras();

        AnalizadorLetras analizadorLetras = new AnalizadorLetras();

        // pasar palabras extremas - OJO - no se pueden repetir las palabras - armar un test para esto
        //archivo.escribir(letrasExtremas, palabrasExtremas);
    }

}