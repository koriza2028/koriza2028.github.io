package de.unidue.iem.tdr.nis.client.solutions;

import de.unidue.iem.tdr.nis.client.Connection;
import de.unidue.iem.tdr.nis.client.TaskObject;
import de.unidue.iem.tdr.nis.client.AbstractSolution;

public class Solution09 extends AbstractSolution {

	/** Aufgabe 9 - DES komplette Runde
	 * Parameter: String[0] L-Block vorheriger Runde (Bin�rstring 32 Bit)
	 * 			  String[1] R-Block vorheriger Runde (Bin�rstring 32 Bit)
	 * 			  String[2] Key (Bin�rstring 64 Bit)
	 * 			  int[0] Runde (1-16)
	 * L�sung: String Bin�rstring (64 Bit, L-Block + R-Block)
	 */

	/* Konstruktor - NICHT ver�ndern */
	public Solution09(Connection con, TaskObject task) {
		super(con, task);
	}

	@Override
	public String run() {
		return super.roundResult(super.task.getStringArray(0), super.task.getStringArray(1),
				super.task.getStringArray(2), super.task.getIntArray(0));
	}


}
