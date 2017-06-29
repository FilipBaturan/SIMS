package Model;

import java.util.ArrayList;

public class UcinakTrenera {
	private int brojIzgubljenihLopti;
	public ArrayList<TimeOut> timeOuti;
	public ArrayList<LicnaGreska> licneGreske;

	public UcinakTrenera() {
	}

	public int getBrojIzgubljenihLopti() {
		return brojIzgubljenihLopti;
	}

	public void setBrojIzgubljenihLopti(int brojIzgubljenihLopti) {
		this.brojIzgubljenihLopti = brojIzgubljenihLopti;
	}

}
