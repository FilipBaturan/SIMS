package Model;

import java.util.ArrayList;

public class StatistikaKluba {
	private int brojNapada;
	public ArrayList<VrstaIzgubljeneLopte> izgubljeneLopteIgraca;
	public ArrayList<VrstaIzgubljeneLopte> izgubljeneLopteTrenera;
	public ArrayList<Izmena> izmene;

	public StatistikaKluba() {
	}

	public int getBrojNapada() {
		return brojNapada;
	}

	public void setBrojNapada(int brojNapada) {
		this.brojNapada = brojNapada;
	}

}
