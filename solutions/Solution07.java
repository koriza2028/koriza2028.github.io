package de.unidue.iem.tdr.nis.client.solutions;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskObject;
import de.unidue.iem.tdr.nis.client.AbstractSolution;

public class Solution07 extends AbstractSolution {

	/** Aufgabe 7 - DES R-Block
	 * Parameter: String[0] Bin�rstring (64 Bit), int[0] Runde
	 * L�sung: String R-Block (Bin�rstring 48 Bit)
	 */

	/* Konstruktor - NICHT ver�ndern */
	public Solution07(Connection con, TaskObject task) {
		super(con, task);
	}

	@Override
	public String run() {
		String key = "0000000000000000000000000000000000000000000000000000000000000000";
		return super.findR(super.task.getStringArray(0), super.task.getIntArray(0), key);
	}

}
