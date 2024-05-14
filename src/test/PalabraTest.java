package test;

import main.Palabra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalabraTest {

    @Test
    public void dadaUnaPalabraSeObtieneLaLetraInicial() {
        Palabra arbol = new Palabra("arbol");

        char letraInicial = arbol.getLetraInicial();

        assertEquals('a', letraInicial);
    }

    @Test
    public void dadaUnaPalabraSeObtieneLaLetraFinal() {
        Palabra arbol = new Palabra("arbol");

        char letraFinal = arbol.getLetraFinal();

        assertEquals('l', letraFinal);
    }
}
