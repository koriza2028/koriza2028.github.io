package de.unidue.iem.tdr.nis.client.solutions;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskObject;
import de.unidue.iem.tdr.nis.client.AbstractSolution;

public class Solution06 extends AbstractSolution {

	/** Aufgabe 6 - DES Rundenschl�ssel
	 * Parameter: String[0] Key (Bin�rstring), int[0] Runde (1-16)
	 * L�sung: String Rundenschl�ssel (Bin�rstring 48 Bit)
	 */

	/* Konstruktor - NICHT ver�ndern */
	public Solution06(Connection con, TaskObject task) {
		super(con, task);
	}

	@Override
	public String run() {
		return super.desRoundKey(super.task.getStringArray(0), super.task.getIntArray(0));
	}

}
