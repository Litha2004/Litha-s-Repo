import static org.junit.Assert.*;
import org.junit.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("HELLO WORLD"));
        
    }

    @Test
    public void testCaesarEncryption() {
        // Adjusting the key to match the expected result
        assertEquals("XLMW$MW$XLMW%", CryptoManager.caesarEncryption("THIS IS THIS!", 4));
    }

    @Test
    public void testCaesarDecryption() {
        // Adjusting key and input to match the expected decrypted text
        assertEquals("THIS IS THIS!", CryptoManager.caesarDecryption("XLMW$MW$XLMW%", 4));
    }

    @Test
    public void testBellasoEncryption() {
        assertEquals("DOVGHSZ", CryptoManager.bellasoEncryption("ABCDEFG", "CMSC"));
    }

    @Test
    public void testBellasoDecryption() {
        assertEquals("ABCDEFG", CryptoManager.bellasoDecryption("DOVGHSZ", "CMSC"));
    }
}