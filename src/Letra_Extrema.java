import java.util.HashSet;
import java.util.Set;

public class Letra_Extrema implements Comparable <Letra_Extrema> {

	private int repeticiones;
	private Set<String> palabras_asociadas;
	
	public Letra_Extrema(String palabra_asociada) {
		this.repeticiones = 1;
		this.palabras_asociadas = new HashSet<>();
		this.palabras_asociadas.add(palabra_asociada);
	}

	public int getRepeticiones() {
		return repeticiones;
	}
	
	public Set<String> getPalabras_asociadas() {
		return palabras_asociadas;
	}
	
	public void agregarRepeticion (String palabra_asociada) {
		this.repeticiones++;
		this.palabras_asociadas.add(palabra_asociada);
	}

	@Override
	public int compareTo(Letra_Extrema letraComparar) {
		return this.getRepeticiones() - letraComparar.getRepeticiones();
	}
}