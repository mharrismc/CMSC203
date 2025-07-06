/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Madison Harris
*/


/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. 
 * 
 * The first approach is called the c.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * @author Huseyin Aygun
 * @version 5/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_";

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
        String repeatedKey = "";
        char c;
        int keyIndex = 0;
        
        // repeat keyword to match length of plain text
        for (int i = 0; i < plainText.length(); i++) {
            if (keyIndex == key.length()) {
                keyIndex = 0;
            }
            c = key.charAt(keyIndex);
            repeatedKey += c;
            keyIndex++;
        }
        
        // encryption
        String encryptedText = "";
        
        for (int i = 0; i < repeatedKey.length(); i++) {
            int plainPosition = plainText.charAt(i) - LOWER_RANGE;
            int keyPosition = repeatedKey.charAt(i) - LOWER_RANGE;
            
            int shiftedPosition = plainPosition + keyPosition;
            
            // ensure index in range
            if (shiftedPosition > RANGE - 1) {
                shiftedPosition -= RANGE;
            }
            
            char encryptedChar = (char)(shiftedPosition + LOWER_RANGE);
            encryptedText += encryptedChar;
        }
        
        return encryptedText;
    }


    public static String vigenereDecryption(String encryptedText, String key) {
        String repeatedKey = "";
        char c;
        int keyIndex = 0;
        
        // repeat keyword to match length of encrypted text
        for (int i = 0; i < encryptedText.length(); i++) {
            if (keyIndex == key.length()) {
                keyIndex = 0;
            }
            c = key.charAt(keyIndex);
            repeatedKey += c;
            keyIndex++;
        }
        
        // decryption
        String decryptedText = "";
        
        for (int i = 0; i < repeatedKey.length(); i++) {
            int encryptedPosition = encryptedText.charAt(i) - LOWER_RANGE;
            int keyPosition = repeatedKey.charAt(i) - LOWER_RANGE;
            
            int shiftedPosition = encryptedPosition - keyPosition;
            
            // ensure index in range
            if (shiftedPosition < 0) {
                shiftedPosition += RANGE;
            }
            
            char decryptedChar = (char)(shiftedPosition + LOWER_RANGE);
            decryptedText += decryptedChar;
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
        final int matrixSize = 8;
        char[][] matrix = new char[matrixSize][matrixSize];
        char[] usedChars = new char[matrixSize * matrixSize];
        int used = 0;

        // loop through each character of the keyword
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            boolean alreadyUsed = false;

            for (int j = 0; j < used; j++) {
                if (usedChars[j] == c) {
                    alreadyUsed = true;
                    break;
                }
            }

            if (!alreadyUsed) {
                usedChars[used++] = c;
            }
        }

        // fill list with remaining ASCII characters
        for (char c = 32; c <= 126 && used < matrixSize * matrixSize; c++) {
            boolean alreadyUsed = false;
            for (int j = 0; j < used; j++) {
                if (usedChars[j] == c) {
                    alreadyUsed = true;
                    break;
                }
            }

            if (!alreadyUsed) {
                usedChars[used++] = c;
            }
        }

        // fill matrix with characters from key and ascii
        int index = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = usedChars[index++];
            }
        }

        // Make sure plain text only contains characters used in the matrix
        String cleanedText = "";
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            for (int j = 0; j < used; j++) {
                if (usedChars[j] == c) {
                    cleanedText += c;
                    break;
                }
            }
        }

        // create letter pairs
        String preparedText = "";
        int i = 0;
        while (i < cleanedText.length()) {
            char first = cleanedText.charAt(i);
            char second;

            if (i + 1 < cleanedText.length()) {
                second = cleanedText.charAt(i + 1);
                //replace duplicate letter
                if (first == second) {
                    second = 'X';
                    i += 1;
                } else {
                    i += 2;
                }
            //if not enough for another pair add an X as a place holder
            } else {
                second = 'X';
                i += 1;
            }

            preparedText += first;
            preparedText += second;
        }

        // begin encryption process
        String encryptedText = "";
        for (int j = 0; j < preparedText.length(); j += 2) {
        	
        	//A and b represent first pair of letters
            char a = preparedText.charAt(j);
            char b = preparedText.charAt(j + 1);
            
            
            //if program crashes due to negative index, this shows the character was not found
            int rowA = -1, colA = -1, rowB = -1, colB = -1;

            // find positions of a and b
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    if (matrix[row][col] == a) {
                        rowA = row;
                        colA = col;
                    }
                    if (matrix[row][col] == b) {
                        rowB = row;
                        colB = col;
                    }
                }
            }

            if (rowA == rowB) {
                // same row
                encryptedText += matrix[rowA][(colA + 1) % matrixSize];
                encryptedText += matrix[rowB][(colB + 1) % matrixSize];
            } else if (colA == colB) {
                // same column
                encryptedText += matrix[(rowA + 1) % matrixSize][colA];
                encryptedText += matrix[(rowB + 1) % matrixSize][colB];
            } else {
                // rectangle
                encryptedText += matrix[rowA][colB];
                encryptedText += matrix[rowB][colA];
            }
        }

        return encryptedText;
    }

    // Vigenere Decryption
    public static String playfairDecryption(String encryptedText, String key) {
        final int matrixSize = 8;
        char[][] matrix = new char[matrixSize][matrixSize];
        char[] usedChars = new char[matrixSize * matrixSize];
        int used = 0;

        // Build usedChars from key
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            boolean alreadyUsed = false;
            for (int j = 0; j < used; j++) {
                if (usedChars[j] == c) {
                    alreadyUsed = true;
                    break;
                }
            }
            if (!alreadyUsed) {
                usedChars[used++] = c;
            }
        }

        // Fill remaining printable ASCII characters
        for (char c = 32; c <= 126 && used < matrixSize * matrixSize; c++) {
            boolean alreadyUsed = false;
            for (int j = 0; j < used; j++) {
                if (usedChars[j] == c) {
                    alreadyUsed = true;
                    break;
                }
            }
            if (!alreadyUsed) {
                usedChars[used++] = c;
            }
        }

        // recreate same matrix used in encryption
        int index = 0;
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = usedChars[index++];
            }
        }

        // Decrypt pairs
        String decryptedText = "";
        int i = 0;
        while (i < encryptedText.length()) {
            char a = encryptedText.charAt(i);
            char b = encryptedText.charAt(i + 1);
            i += 2;

            int rowA = -1, colA = -1, rowB = -1, colB = -1;

            // Find positions of a and b
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    if (matrix[row][col] == a) {
                        rowA = row;
                        colA = col;
                    }
                    if (matrix[row][col] == b) {
                        rowB = row;
                        colB = col;
                    }
                }
            }
            
            //opposite of encryption rules
            if (rowA == rowB) {
                // same row: move left (wrap using modulus)
                decryptedText += matrix[rowA][(colA - 1 + matrixSize) % matrixSize];
                decryptedText += matrix[rowB][(colB - 1 + matrixSize) % matrixSize];
            } else if (colA == colB) {
                // same column: move up (wrap using modulus)
                decryptedText += matrix[(rowA - 1 + matrixSize) % matrixSize][colA];
                decryptedText += matrix[(rowB - 1 + matrixSize) % matrixSize][colB];
            } else {
                // rectangle swap columns
                decryptedText += matrix[rowA][colB];
                decryptedText += matrix[rowB][colA];
            }
        }

        return decryptedText;
    }


}
