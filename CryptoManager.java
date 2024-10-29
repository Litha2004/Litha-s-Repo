public class CryptoManager {

    private static final char LOWER_RANGE = ' ';  // ASCII value 32
    private static final char UPPER_RANGE = '_';  // ASCII value 95
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    // Method to check if a string is within the allowable bounds
    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }
    

    // Caesar Encryption Method
    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }
        
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char encryptedChar = (char)(plainText.charAt(i) + key);
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    // Caesar Decryption Method
    public static String caesarDecryption(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char decryptedChar = (char)(encryptedText.charAt(i) - key);
            while (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }

    // Bellaso Encryption Method
    public static String bellasoEncryption(String plainText, String bellasoStr) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            int bellasoIndex = i % bellasoStr.length();
            char encryptedChar = (char)(plainText.charAt(i) + bellasoStr.charAt(bellasoIndex));
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    // Bellaso Decryption Method
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            int bellasoIndex = i % bellasoStr.length();
            char decryptedChar = (char)(encryptedText.charAt(i) - bellasoStr.charAt(bellasoIndex));
            while (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }
}