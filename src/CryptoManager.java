/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";
    
    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {

        // Repeat the key to match the length of the plaintext
        String encryptedKey = "";

        for (int i = 0; i < plainText.length(); i++) {
            encryptedKey += key.charAt(i % key.length());
        }

        String encryptedText = "";

        for (int i = 0; i < encryptedKey.length(); i++) {

            int unCrypLetter = plainText.charAt(i);
            int keyLetter = encryptedKey.charAt(i);

            int realPositionOfPlain = unCrypLetter - LOWER_RANGE;
            int realPositionOfKey = keyLetter - LOWER_RANGE;
            int finaEncryLetter = (realPositionOfPlain + realPositionOfKey) % RANGE;

            char actFinalEncrLetter = (char) (finaEncryLetter + LOWER_RANGE);
            encryptedText += actFinalEncrLetter;
            
        }

        return encryptedText;
        
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
    	
    	String encryptedKey = "";
    	
        for (int i = 0; i < encryptedText.length(); i++) {
        	
            encryptedKey += key.charAt(i % key.length());
            
        }

        String decryptedText = "";
        
        for (int i = 0; i < encryptedKey.length(); i++) {
        	
            int unCrypLetter = encryptedText.charAt(i);
            int keyLetter = encryptedKey.charAt(i);
            
            int realPositionOfPlain = unCrypLetter - LOWER_RANGE;
            int realPositionOfKey = keyLetter - LOWER_RANGE;
            int finaEncryLetter = ((realPositionOfPlain - realPositionOfKey) + RANGE) % RANGE;
            
            char actFinalEncrLetter = (char) (finaEncryLetter + LOWER_RANGE);
            decryptedText += actFinalEncrLetter;
            
        }
        
        return decryptedText;
   
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
    	
    	String newAlphabet = "";

        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);

            if (newAlphabet.indexOf(letter) == -1) {
                newAlphabet += letter;
            }
        }

        for (int i = 0; i < ALPHABET64.length(); i++) {
            char letter = ALPHABET64.charAt(i);

            if (newAlphabet.indexOf(letter) == -1) {
                newAlphabet += letter;
            }
        }

        char[][] matrix = new char[8][8];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = newAlphabet.charAt(row * 8 + column);
            }
        }

        
        
        String encryptedText = "";

        for (int i = 0; i < plainText.length(); i += 2) {

            char first = plainText.charAt(i);
            char second = plainText.charAt(i + 1);

            int firstIndex = newAlphabet.indexOf(first);
            int secondIndex = newAlphabet.indexOf(second);

            int firstRow = firstIndex / 8;
            int firstCol = firstIndex % 8;

            int secondRow = secondIndex / 8;
            int secondCol = secondIndex % 8;

            
            
            if (firstRow == secondRow) {

                encryptedText += matrix[firstRow][(firstCol + 1) % 8];
                encryptedText += matrix[secondRow][(secondCol + 1) % 8];

            } else if (firstCol == secondCol) {

                encryptedText += matrix[(firstRow + 1) % 8][firstCol];
                encryptedText += matrix[(secondRow + 1) % 8][secondCol];

            } else {

                encryptedText += matrix[firstRow][secondCol];
                encryptedText += matrix[secondRow][firstCol];
                
            }
        }

        
        return encryptedText;
        
        
    }

    // Vigenere Decryption
    public static String playfairDecryption(String encryptedText, String key) {
    	
    	String newAlphabet = "";

        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);

            if (newAlphabet.indexOf(letter) == -1) {
                newAlphabet += letter;
            }
        }

        for (int i = 0; i < ALPHABET64.length(); i++) {
            char letter = ALPHABET64.charAt(i);

            if (newAlphabet.indexOf(letter) == -1) {
                newAlphabet += letter;
            }
        }

        char[][] matrix = new char[8][8];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = newAlphabet.charAt(row * 8 + column);
            }
        }

        
        
        String decryptedText = "";

        for (int i = 0; i < encryptedText.length(); i += 2) {

            char first = encryptedText.charAt(i);
            char second = encryptedText.charAt(i + 1);

            int firstIndex = newAlphabet.indexOf(first);
            int secondIndex = newAlphabet.indexOf(second);

            int firstRow = firstIndex / 8;
            int firstCol = firstIndex % 8;

            int secondRow = secondIndex / 8;
            int secondCol = secondIndex % 8;

            
            
            if (firstRow == secondRow) {

                decryptedText += matrix[firstRow][(firstCol + 7) % 8];
                decryptedText += matrix[secondRow][(secondCol + 7) % 8];

            } else if (firstCol == secondCol) {

                decryptedText += matrix[(firstRow + 7) % 8][firstCol];
                decryptedText += matrix[(secondRow + 7) % 8][secondCol];

            } else {

                decryptedText += matrix[firstRow][secondCol];
                decryptedText += matrix[secondRow][firstCol];
                
            }
        }

        return decryptedText;
        
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
    	
    	String encryptedText = "";
    	
    	for (int i = 0; i < plainText.length(); i++) {
    		
    		char letter = plainText.charAt(i);
    		int position = ((letter - LOWER_RANGE) + key) % RANGE;
    		char encryptedLetter = (char) (position + LOWER_RANGE);
    		encryptedText += encryptedLetter;
    		
    	}
    	
    	return encryptedText;

    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
    	
    	String decryptedText = "";
    	
    	for (int i = 0; i < encryptedText.length(); i++) {
    		
    		char letter = encryptedText.charAt(i);
    		int position = ((letter - LOWER_RANGE) - key + RANGE) % RANGE;
    		char decryptedLetter = (char) (position + LOWER_RANGE);
    		decryptedText += decryptedLetter;
    		
    	}
    	
    	return decryptedText;

    }    

}
