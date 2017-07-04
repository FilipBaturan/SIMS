package Model;

import java.util.ArrayList;

public class UcinakTrenera {
	private int brojIzgubljenihLopti;
	public ArrayList<TimeOut> timeOuti;
	public ArrayList<VrstaLicneGreske> licneGreske;
	public Utakmica utakmica;

	public UcinakTrenera() {
		timeOuti = new ArrayList<TimeOut>();
		licneGreske = new ArrayList<VrstaLicneGreske>();
	}

	public int getBrojIzgubljenihLopti() {
		return brojIzgubljenihLopti;
	}

	public void setBrojIzgubljenihLopti(int brojIzgubljenihLopti) {
		this.brojIzgubljenihLopti = brojIzgubljenihLopti;
	}

}
