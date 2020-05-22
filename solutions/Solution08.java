package de.unidue.iem.tdr.nis.client.solutions;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskObject;
import de.unidue.iem.tdr.nis.client.AbstractSolution;

public class Solution08 extends AbstractSolution {

	/** Aufgabe 8 - DES Feistel
	 * Parameter: String[0] Bin�rstring (64 Bit), String[1] Rundenschl�ssel (Bin�rstring 48 Bit)
	 * L�sung: String L-Block XOR R-Block (Bin�rstring)
	 */

	/* Konstruktor - NICHT ver�ndern */
	public Solution08(Connection con, TaskObject task) {
		super(con, task);
	}

	@Override
	public String run() {
		String L = super.task.getStringArray(0).substring(0, 32);
		String R = super.task.getStringArray(0).substring(32, 64);
		String Feistel = super.Feistel(R, super.task.getStringArray(1));
		return super.XOR(L, Feistel);
	}

}
