import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("SUMMER TIME"));
        assertFalse(CryptoManager.isStringInBounds("summer 2025!"));
        assertFalse(CryptoManager.isStringInBounds("suMMer #$%!_-"));
    }

	@Test
	public void testVigenereEncryptDecrypt() {
        String plain = "TIME FOR THE BEACH";
        String key = "HELLO";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }
    
	@Test
    public void testPlayfairEncryptDecrypt() {
        String plain = "BEACH!@$%";
        String key = "KEYWORD!";
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        assertEquals("BEACH!@$%X", decrypted);
    }

}
