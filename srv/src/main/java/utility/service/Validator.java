package utility.service;

public class Validator {
	public static void check(boolean check, String message) throws ValidationException {
		if (check == false) throw new ValidationException(message);
	}
}
