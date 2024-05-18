package main;

import java.util.*;

public class AnalizadorLetras {
	Map<Character, LetraExtrema> letrasAnalizar = new HashMap<>();

	public Resultado obtenerUsosDeLetraExtremaMasUtilizada(Palabra[] palabras) {
		for (Palabra palabra: palabras) {
			agregarRepeticionDePalabraParaLetraExtrema(palabra, palabra.getLetraInicial());
			agregarRepeticionDePalabraParaLetraExtrema(palabra, palabra.getLetraFinal());
		}

		int maximasRepeticiones = 0;
		List<Character> maximosCaracteres = new ArrayList<>();
		Set<String> palabrasMaximas = new HashSet<>();
		for (Map.Entry<Character, LetraExtrema> letra : letrasAnalizar.entrySet()) {
			int repeticiones = letra.getValue().getRepeticiones();

			if (repeticiones > maximasRepeticiones) {
				maximasRepeticiones = repeticiones;
				maximosCaracteres.clear();
				palabrasMaximas.clear();
			}

			if (repeticiones == maximasRepeticiones) {
				maximosCaracteres.add(letra.getKey());
				palabrasMaximas.addAll(letra.getValue().getPalabrasAsociadas());
			}
		}

		return new Resultado(maximosCaracteres, palabrasMaximas);
	}

	private void agregarRepeticionDePalabraParaLetraExtrema(Palabra palabra, char letraExtrema) {
		if (!letrasAnalizar.containsKey(letraExtrema)) {
			letrasAnalizar.put(letraExtrema, new LetraExtrema(palabra.getValue()));
		}
		else {
			letrasAnalizar.get(letraExtrema).agregarRepeticion(palabra.getValue());
		}
	}
}
