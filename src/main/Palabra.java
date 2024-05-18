package main;

public class Palabra {
	private final String value;
	
    public String getValue() {
		return value;
	}
 
    public Palabra(String palabra) {
        this.value = palabra;
    }

    public char getLetraInicial() {
    	return this.value.charAt(0);
    }
 
    public char getLetraFinal() {
    	return this.value.charAt(this.value.length() - 1);
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "value='" + value + '\'' +
                '}';
    }
}