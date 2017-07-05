package Model.Evidentiranje;

import java.util.ArrayList;

import Model.Utakmica;
import Model.Enumeracije.TipTimeOut;
import Model.Enumeracije.VrstaLicneGreske;

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

	public void azuriranje(int tip) {
		switch (tip) {
		case 0:
			setBrojIzgubljenihLopti(getBrojIzgubljenihLopti()+1);
			break;
		case 1:
			licneGreske.add(VrstaLicneGreske.tehnickaGreska);
			break;
		case 2:
			timeOuti.add(new TimeOut(TipTimeOut.mali,utakmica.getVreme(),utakmica.izracunaCetvrtinu()));
			break;
		case 3:
			timeOuti.add(new TimeOut(TipTimeOut.veliki,utakmica.getVreme(),utakmica.izracunaCetvrtinu()));
			break;
		default:
			break;
		}
	}
}
