package de.unidue.iem.tdr.nis.client.solutions;

public class Helper {
	/** Hier k�nnen Sie ihre allgemeinen Funktionen erstellen,
	 * welche in allen L�sungen verf�gbar sind.
	 * Sie k�nnen auch statische Methoden oder Subklassen benutzen.
	 * Sie k�nnen jedoch NICHT die Signatur des Konstruktors ver�ndern.
	 */
	public Helper() {
		
	}

    public int modulo(int number1, int number2) {
        int div = number1/number2;
        return number1-number2*div;
    }

    public String fromDeсToBinaryString(int dec) {
        String binaryString = "";
        int next = dec;
        while (next != 0) {
            binaryString = modulo(next,2) + binaryString;
            next = next / 2;
        }
        return binaryString;
    }

    public int hexSymbolIntoDec(String hexSymbol) {
        if (hexSymbol.equals("A") || hexSymbol.equals("a")) {
            return 10;
        } else if (hexSymbol.equals("B") || hexSymbol.equals("b")) {
            return 11;
        } else if (hexSymbol.equals("C") || hexSymbol.equals("c")) {
            return 12;
        } else if (hexSymbol.equals("D") || hexSymbol.equals("d")) {
            return 13;
        } else if (hexSymbol.equals("E") || hexSymbol.equals("e")) {
            return 14;
        } else if (hexSymbol.equals("F") || hexSymbol.equals("f")) {
            return 15;
        } else {
            return Integer.parseInt(hexSymbol);
        }
    }

    public String fromHexToBinaryString(String hexString) {
        String binaryString = "";
        StringBuilder hex = new StringBuilder(hexString);

        if (hexString.length()==1) {
            return fromDeсToBinaryString(hexSymbolIntoDec(hexString));
        } else {
            for (int i=0; i < hex.length(); i++) {
                int decSymbol = hexSymbolIntoDec(hex.substring(i, i+1));
                if (decSymbol<2) {
                    binaryString += "000" + decSymbol;
                } else if (decSymbol<4) {
                    binaryString += "00" + fromDeсToBinaryString(decSymbol);
                } else if (decSymbol<8) {
                    binaryString += "0" + fromDeсToBinaryString(decSymbol);
                } else {
                    binaryString += fromDeсToBinaryString(decSymbol);
                }
            }
            return binaryString;
        }
    }
    public String XOR(String binaryString1, String binaryString2) {
        StringBuilder string1 = new StringBuilder(binaryString1);
        StringBuilder string2 = new StringBuilder(binaryString2);
        String result = "";

        while (string1.length()!=string2.length()) {
            if (string1.length()>string2.length()) {
                string2.insert(0, "0");
            } else string1.insert(0, "0");
        }

        for (int i = 0; i < string1.length(); i++) {
            int current1 = Integer.parseInt(string1.substring(i, i+1));
            int current2 = Integer.parseInt(string2.substring(i, i+1));

            if (current1==current2) {
                result += "0";
            } else result += "1";
        }
        return result;
    }

    public String primFaktor(int number) {
        String result = "";
        return prim(number, result);
    }

    private String prim(int number, String result) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (modulo(number,i)==0) {
                return result + i + "*" + prim(number/i, result);
            }
        }
        return "" + number;
    }

    public String desRoundKey(String key, int round) {
        int[] PC1 = new int[] {57, 49, 41, 33, 25, 17,  9,
                1, 58, 50, 42, 34, 26, 18,
                10,  2, 59, 51, 43, 35, 27,
                19, 11,  3, 60, 52, 44, 36,
                63, 55, 47, 39, 31, 23, 15,
                7, 62, 54, 46, 38, 30, 22,
                14,  6, 61, 53, 45, 37, 29,
                21, 13,  5, 28, 20, 12,  4};

        int[] PC2 = new int[] {14, 17, 11, 24,  1,  5,
                3, 28, 15,  6, 21, 10,
                23, 19, 12,  4, 26,  8,
                16,  7, 27, 20, 13,  2,
                41, 52, 31, 37, 47, 55,
                30, 40, 51, 45, 33, 48,
                44, 49, 39, 56, 34, 53,
                46, 42, 50, 36, 29, 32};

        int r = 1;
        String permutedKey = permutation(PC1, key);
        String C = permutedKey.substring(0, 28);
        String D = permutedKey.substring(28, 56);
        String roundKey = "";

        while (r!=round+1) {
            C = shiftToTheLeft(r, C);
            D = shiftToTheLeft(r, D);
            roundKey = permutation(PC2, C+D);
            r++;
        }

        return roundKey;
    }

    public String permutation(int[] PC, String key) {
        String permutedKey = "";

        for (int i=0; i<PC.length; i++) {
            permutedKey += key.toCharArray()[PC[i]-1];
        }

        return permutedKey;
    }

    public String shiftToTheLeft(int round, String key) {
        String rotatedKey = "";

        if (round == 1 || round == 2 || round == 9 || round == 16) {
            String last = "" + key.toCharArray()[0];
            for (int i=1; i<key.length(); i++) {
                rotatedKey += key.toCharArray()[i];
            }
            rotatedKey += last;
        } else {
            String last = "" + key.toCharArray()[0] + key.toCharArray()[1];
            for (int i=2; i<key.length(); i++) {
                rotatedKey += key.toCharArray()[i];
            }
            rotatedKey += last;
        }

        return rotatedKey;
    }

    public String expansion(String R) {
        int[] E = {32, 1, 2, 3, 4, 5,
                4, 5, 6, 7, 8, 9,
                8, 9, 10, 11, 12, 13,
                12, 13, 14, 15, 16, 17,
                16, 17, 18, 19, 20, 21,
                20, 21, 22, 23, 24, 25,
                24, 25, 26, 27, 28, 29,
                28, 29, 30, 31, 32, 1 };
        String eR = "";

        for(int i: E) {
            eR += R.toCharArray()[i-1];
        }
        return eR;
    }

    public String SBox(String B) {
        int[][] S1 = {
                {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
        };

        int[][] S2 = {
                {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
        };

        int[][] S3 = {
                {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
        };

        int[][] S4 = {
                {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
        };

        int[][] S5 = {
                {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
        };

        int[][] S6 = {
                {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
        };

        int[][] S7 = {
                {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
        };

        int[][] S8 = {
                {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
        };

        StringBuilder C = new StringBuilder();

        for (int i = 0; i < 48; i+=6) {

            int row = fromBinaryToDec(B.toCharArray()[i] + "" + B.toCharArray()[i+5]);
            int	column = fromBinaryToDec(B.substring(i+1, i+5));

            if (i<6) {
                C.append(fourSymbolsBinary(S1[row][column]));
            } else if (i<12) {
                C.append(fourSymbolsBinary(S2[row][column]));
            } else if (i<18) {
                C.append(fourSymbolsBinary(S3[row][column]));
            } else if (i<24) {
                C.append(fourSymbolsBinary(S4[row][column]));
            } else if (i<30) {
                C.append(fourSymbolsBinary(S5[row][column]));
            } else if (i<36) {
                C.append(fourSymbolsBinary(S6[row][column]));
            } else if (i<42) {
                C.append(fourSymbolsBinary(S7[row][column]));
            } else {
                C.append(fourSymbolsBinary(S8[row][column]));
            }
        }

        return C.toString();
    }

    private String fourSymbolsBinary(int dec) {
        StringBuilder binaryString = new StringBuilder(fromDeсToBinaryString(dec));

        if (binaryString.length() == 0) {
            binaryString.insert(0, "0000");
        } else if (binaryString.length()<2) {
            binaryString.insert(0, "000");
        } else if (binaryString.length()<3) {
            binaryString.insert(0, "00");
        } else if (binaryString.length()<4) {
            binaryString.insert(0,"0");
        }

        return binaryString.toString();
    }

    public int fromBinaryToDec(String binaryString) {
        int dec = 0;
        for (int i=binaryString.length()-1; i>=0; i--) {
            dec += Math.pow(2, i)*Integer.parseInt(binaryString.toCharArray()[binaryString.length()-1-i]+"");
        }
        return dec;
    }

    public String Feistel(String R, String key) {
        int[] P = {
                16, 7, 20, 21,
                29, 12, 28, 17,
                1, 15, 23, 26,
                5, 18, 31, 10,
                2, 8, 24, 14,
                32, 27, 3, 9,
                19, 13, 30, 6,
                22, 11, 4, 25 };
        String expansionR = expansion(R);
        String B = XOR(expansionR, key);
        String C = SBox(B);
        return permutation(P, C);
    }

    public String findR(String binaryString, int round, String key) {
        int[] IP = new int[] {
                58, 50, 42, 34, 26, 18, 10, 2,
                60, 52, 44, 36, 28, 20, 12, 4,
                62, 54, 46, 38, 30, 22, 14, 6,
                64, 56, 48, 40, 32, 24, 16, 8,
                57, 49, 41, 33, 25, 17,  9, 1,
                59, 51, 43, 35, 27, 19, 11, 3,
                61, 53, 45, 37, 29, 21, 13, 5,
                63, 55, 47, 39, 31, 23, 15, 7
        };
        binaryString = permutation(IP, binaryString);

        String L = binaryString.substring(0, 32);
        String R = binaryString.substring(32, 64);

        int r = 1;

        while (r<round+1) {
            String newR = XOR(L, Feistel(R, desRoundKey(key, r)));
            L = R;
            R = newR;
            r++;
        }

        return R;
    }

    public String roundResult(String L, String R, String key, int round) {
	    String newR = XOR(L, Feistel(R, desRoundKey(key, round)));
	    L = R;
	    R = newR;
	    return L+R;
    }
}
