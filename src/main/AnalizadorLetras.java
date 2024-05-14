package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalizadorLetras {
	Map<Character, LetraExtrema> letrasAnalizar = new HashMap<>();

	public void obtenerUsosDeLetraExtremaMasUtilizada(List<Palabra> palabras) {
		for (Palabra palabra: palabras) {
			agregarPalabraParaLetraExtrema(letrasAnalizar, palabra, palabra.getLetraInicial());
			agregarPalabraParaLetraExtrema(letrasAnalizar, palabra, palabra.getLetraFinal());
		}

		// obtener letras extremas mas usadas

		// devolver palabras asociadas a la o las letras extremas mas usadas
	}

	private void agregarPalabraParaLetraExtrema(Map<Character, LetraExtrema> letrasAnalizar, Palabra palabra, char letraExtrema) {
		if (!letrasAnalizar.containsKey(letraExtrema)) {
			letrasAnalizar.put(letraExtrema, new LetraExtrema(palabra.getValue()));
		}
		else {
			letrasAnalizar.get(letraExtrema).agregarRepeticion(palabra.getValue());
		}
	}

	public void obtenerLetrasMasRepeticiones() { //List[] obtenerLetrasMasRepeticiones () {
		// Metodo de ordenamiento fusion
		
		/*do while	-> Obtenes mayor
				   	-> Agrearlo a la lista
				   	-> Sacas del hashmap
				   	-> Obtenes el 2do mayor
				   	-> Comparas
				   	-> Si son != terminas, sino seguis la iteacion
		*/		   		
	}
}
