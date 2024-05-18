package main;

import java.util.List;
import java.util.Set;

public class Resultado {
    private final List<Character> caracterMasRepetidos;
    private final Set<String> palabrasDeCaracteresMasRepetidos;

    public Resultado(List<Character> maximosCaracteres, Set<String> palabrasMaximas) {
        this.caracterMasRepetidos = maximosCaracteres;
        this.palabrasDeCaracteresMasRepetidos = palabrasMaximas;
    }

    public List<Character> getCaracterMasRepetidos() {
        return caracterMasRepetidos;
    }

    public Set<String> getPalabrasDeCaracteresMasRepetidos() {
        return palabrasDeCaracteresMasRepetidos;
    }
}
