package main;

import java.util.HashSet;
import java.util.Set;

public class LetraExtrema implements Comparable <LetraExtrema> {

	private int repeticiones = 1;
	private final Set<String> palabrasAsociadas = new HashSet<>();
	
	public LetraExtrema(String palabra_asociada) {
		this.palabrasAsociadas.add(palabra_asociada);
	}

	public int getRepeticiones() {
		return repeticiones;
	}
	
	public Set<String> getPalabrasAsociadas() {
		return palabrasAsociadas;
	}
	
	public void agregarRepeticion (String palabra_asociada) {
		this.repeticiones++;
		this.palabrasAsociadas.add(palabra_asociada);
	}

	@Override
	public int compareTo(LetraExtrema letraComparar) {
		return this.getRepeticiones() - letraComparar.getRepeticiones();
	}
}