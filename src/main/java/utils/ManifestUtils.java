package utils;

import java.util.Random;

public class ManifestUtils {
	
	private static final Random random = new Random();

    public static String generateManifestTrackingNumber() {
        // Generate 9-digit number
        int number = 100000000 + random.nextInt(900000000);
        return number + "CLE";
    }

}
