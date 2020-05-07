package de.unidue.iem.tdr.nis.client.solutions;

public class Helper {
	/** Hier k�nnen Sie ihre allgemeinen Funktionen erstellen,
	 * welche in allen L�sungen verf�gbar sind.
	 * Sie k�nnen auch statische Methoden oder Subklassen benutzen.
	 * Sie k�nnen jedoch NICHT die Signatur des Konstruktors ver�ndern.
	 */
	public Helper() {
		
	}

    public String fromDeсToBinaryString(int dec) {
        String binaryString = "";
        int next = dec;
        while (next != 0) {
            binaryString = (next%2) + binaryString;
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
            System.out.println(binaryString);
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
}
