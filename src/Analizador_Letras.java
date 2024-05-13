import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analizador_Letras {
	private Map<Character, Letra_Extrema> letrasAnalizar;
	
	public Analizador_Letras() {
		this.letrasAnalizar = new HashMap<>();
	}

	public Map<Character, Letra_Extrema> getLetrasAnalizar() {
		return letrasAnalizar;
	}

	public void agregarLetrasAnalizar(List<Palabra> palabrasAnalizar) {
		char letraInicial;
		char letraFinal;
		
		for (Palabra palabra: palabrasAnalizar) {
			letraInicial = palabra.getLetraInicial();
			
			if (!this.letrasAnalizar.containsKey(letraInicial)) {
				letrasAnalizar.put(letraInicial, new Letra_Extrema(palabra.getValue()));
			}
			else {
				letrasAnalizar.get(letraInicial).agregarRepeticion(palabra.getValue());
			}
			
			letraFinal = palabra.getLetraFinal();
			
			if (!this.letrasAnalizar.containsKey(letraFinal)) {
				letrasAnalizar.put(letraFinal, new Letra_Extrema(palabra.getValue()));
			}
			else {
				letrasAnalizar.get(letraFinal).agregarRepeticion(palabra.getValue());
			}
			
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
