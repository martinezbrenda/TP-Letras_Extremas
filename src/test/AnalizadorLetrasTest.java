package test;

import main.AnalizadorLetras;
import main.Palabra;
import main.Resultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnalizadorLetrasTest {

    private AnalizadorLetras analizadorLetras;

    @BeforeEach
    public void setup() {
        analizadorLetras = new AnalizadorLetras();
    }

    @Test
    public void dadaUnaListaDePalabrasObtenerLaLetraQueMasSeRepite() {
        Palabra[] palabras = {
                new Palabra("arbol"),
                new Palabra("orden"),
                new Palabra("susana"),
                new Palabra("otro"),
                new Palabra("listo"),
                new Palabra("nexos")};

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        validarCaracterMasRepetidos(List.of('o'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("orden", "otro", "listo"), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    @Test
    public void dadoQueDosOMasLetrasSeRepitenDeFormaMaximaEntoncesSeObtienenTodasLetras() {
        Palabra[] palabras = {
                new Palabra("arbol"),
                new Palabra("orden")
        };

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        validarCaracterMasRepetidos(List.of('o', 'n', 'a', 'l'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("orden", "arbol"), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    @Test
    public void dadaUnaPalabraConMismaLetraExtremaInicialYFinalEntoncesCuentaPor2Repeticiones() {
        Palabra[] palabras = {
                new Palabra("arbol"),
                new Palabra("otro"),
                new Palabra("mora"),
                new Palabra("perro")
        };

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        validarCaracterMasRepetidos(List.of('o'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("otro", "perro"), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    @Test
    public void dadaUnaPalabraQueSeRepiteParaDosLetrasExtremasMaximasEntoncesSeMuestraUnaSolaVez() {
        Palabra[] palabras = {
                new Palabra("arbol")
        };

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        validarCaracterMasRepetidos(List.of('a', 'l'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("arbol"), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    private void validarCaracterMasRepetidos(List<Character> caracteresEsperados, List<Character> caracteresMasRepetidos) {
        assertEquals(caracteresEsperados.size(), caracteresMasRepetidos.size());
        assertTrue(caracteresMasRepetidos.containsAll(caracteresEsperados));
    }

    private void validarPalabrasParaCaracteresMasRepetidos(List<String> palabrasEsperadas, Set<String> palabrasDeCaracteresMasRepetidos) {
        assertEquals(palabrasEsperadas.size(), palabrasDeCaracteresMasRepetidos.size());
        assertTrue(palabrasDeCaracteresMasRepetidos.containsAll(palabrasEsperadas));
    }

}
