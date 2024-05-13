public class Palabra {
	private String value;
	
    public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
}