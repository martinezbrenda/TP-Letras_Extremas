package main;

public class Main {
    public static void main(String[] args) {
        Archivo archivo = new Archivo("src/resources/palabras");
        Palabra[] palabras = archivo.getPalabras();

        AnalizadorLetras analizadorLetras = new AnalizadorLetras();
        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        archivo.escribir(resultado.getCaracterMasRepetidos(), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

}