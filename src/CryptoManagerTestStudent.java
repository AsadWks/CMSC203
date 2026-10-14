import junit.framework.TestCase;

public class CryptoManagerTestStudent extends TestCase {

    public void testIsStringInBounds() {
    	
        assertTrue(CryptoManager.isStringInBounds("JAVA ROCKS 2026!"));
        assertFalse(CryptoManager.isStringInBounds("Java Rocks 2026!"));
        assertFalse(CryptoManager.isStringInBounds("JAVA ROCKS 2026~"));
        
    }

    public void testCaesarEncryptDecrypt() {
    	
        String plain = "JAVA ROCKS 2026!";
        int key = 7;

        String encrypted = CryptoManager.caesarEncryption(plain, key);
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);

        assertEquals(plain, decrypted);
        
    }

    public void testVigenereEncryptDecrypt() {
    	
        String plain = "JAVA ROCKS 2026!";
        String key = "CODE42";

        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);

        assertEquals(plain, decrypted);
        
    }

    public void testPlayfairEncryptDecrypt() {
    	
        String plain = "JAVA ROCKS 2026!";
        String key = "CODE42";

        String encrypted = CryptoManager.playfairEncryption(plain, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);

        assertEquals(plain, decrypted);
        
    }
}
