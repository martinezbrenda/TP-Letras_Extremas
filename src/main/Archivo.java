package main;

import main.Exception.analizadorLetrasException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Archivo {

    private String path;

    Archivo(String path) {
        this.path = path;
    }

    public Palabra[] getPalabras() {
        Scanner scanner = null;

        try {
            File file = new File(this.path + ".in");
            scanner = new Scanner(file);
            scanner.useLocale(Locale.ENGLISH);
            seteaSaltoDeLineaComoDelimitador(scanner);

            int cantidadDePalabras = scanner.nextInt();
            Palabra[] palabras = new Palabra[cantidadDePalabras];
            int i;

            for (i = 0; i < cantidadDePalabras; i++) {
                palabras[i] = new Palabra(scanner.next());
            }

            scanner.close();
            return palabras;

        } catch (Exception e) {
            e.printStackTrace();
            if (scanner != null) {
                scanner.close();
            }

            return new Palabra[0];
        }
    }

    public void escribir(List<Character> letrasExtremas, Set<String> palabras) {
        FileWriter archivo;
        PrintWriter writer;

        try {
            archivo = new FileWriter(path + ".out");
            writer = new PrintWriter(archivo);

            StringBuilder stringBuilder = new StringBuilder();
            for (Character letraExtrema : letrasExtremas) {
                stringBuilder.append(letraExtrema).append(" - ");
            }

            String primerRenglon = stringBuilder.toString();
            primerRenglon = primerRenglon.substring(0, primerRenglon.length() - 2);
            writer.println(primerRenglon);

            for (String palabra : palabras) {
                writer.println(palabra);
            }

            try {
                archivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void seteaSaltoDeLineaComoDelimitador(Scanner scanner) {
        scanner.useDelimiter("\n|\r\n");
    }

}
