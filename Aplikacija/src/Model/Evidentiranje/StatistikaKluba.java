package Model.Evidentiranje;

import java.util.ArrayList;

import Model.Utakmica;
import Model.Enumeracije.VrstaIzgubljeneLopte;
import Model.Enumeracije.VrstaLicneGreske;

public class StatistikaKluba {
	private int brojNapada;
	public ArrayList<VrstaIzgubljeneLopte> izgubljeneLopte;
	public ArrayList<VrstaLicneGreske> licneGreske;
	public ArrayList<Izmena> izmene;
	public Utakmica utakmica;

	public StatistikaKluba() {
		izgubljeneLopte = new ArrayList<VrstaIzgubljeneLopte>();
		licneGreske = new ArrayList<VrstaLicneGreske>();
	}

	public int getBrojNapada() {
		return brojNapada;
	}

	public void setBrojNapada(int brojNapada) {
		this.brojNapada = brojNapada;
	}

}
