package de.unidue.iem.tdr.nis.client.solutions;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskObject;
import de.unidue.iem.tdr.nis.client.AbstractSolution;

public class Solution05 extends AbstractSolution {

	/** Aufgabe 5 - Vigen�re
	 * Parameter: String[0] Chiffretext, String[1] Key
	 * L�sung: String Klartext
	 */

	/* Konstruktor - NICHT ver�ndern */
	public Solution05(Connection con, TaskObject task) {
		super(con, task);
	}

	public int findIndexOf(char[] arrayOfChars, char letter) {
		int i = 0;
		for (char c: arrayOfChars) {
			if (c==letter) {
				return i;
			} else i++;
		}
		return 0;
	}

	public String Vigenere(String cipher, String key) {
		cipher = cipher.toUpperCase();
		key = key.toUpperCase();
		char[] cipherChars = cipher.toCharArray();
		char[] fullKey = new char[cipherChars.length];
		char[] keyChars = key.toCharArray();

		char[] alphabet = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U',
				'V', 'W', 'X', 'Y', 'Z'};
		int indexOfChars = 0;

		for (int i = 0; i<cipherChars.length; i++) {
			if (indexOfChars==keyChars.length) {
				indexOfChars = 0;
			}
			fullKey[i] = keyChars[indexOfChars];
			indexOfChars++;
		}

		String result = "";

		for (int i = 0; i<cipherChars.length; i++) {
			int indexOfCipher = findIndexOf(alphabet, cipherChars[i]);
			int indexOfKey = findIndexOf(alphabet, fullKey[i]);

			result += alphabet[super.modulo(indexOfCipher+26-indexOfKey, 26)];
		}

		return result;
	}

	@Override
	public String run() {
		return Vigenere(super.task.getStringArray(0), super.task.getStringArray(1));
	}

}
