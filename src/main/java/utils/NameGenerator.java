package utils;

import java.security.SecureRandom;

public class NameGenerator {

	 private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    private static final String DIGITS = "0123456789";
	    private static final SecureRandom random = new SecureRandom();

	    // Generates a name with 6 alphabets + space + 2 digits
	    public static String getAlphaNumName() {
	        StringBuilder sb = new StringBuilder();

	        // Add 6 random alphabets
	        for (int i = 0; i < 6; i++) {
	            sb.append(ALPHABETS.charAt(random.nextInt(ALPHABETS.length())));
	        }

	        // Add a space
	        sb.append(" ");

	        // Add 2 random digits
	        for (int i = 0; i < 2; i++) {
	            sb.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
	        }

	        return sb.toString();
	    }
}
