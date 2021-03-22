package hw9_1;

public class IncorrectInputExeption extends Exception {
	private String message;

	public IncorrectInputExeption(String message) {
		this.message = message;
	}

}
