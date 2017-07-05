package Model;

import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonProperty;

import Model.Evidentiranje.StatistikaKluba;


public class Klub {
	private String naziv;
	private int id;
	public ArrayList<StatistikaKluba> statistikaKluba;
	public Mesto mestoOsnivanja;
	public Trener trener;
	public ArrayList<Igrac> igraci;

	public Klub() {
	}

	public Klub(String naziv, int id) {
		this.naziv = naziv;
		this.id = id;
		igraci = new ArrayList<Igrac>();
	}

	public Klub(String naziv, int id, Mesto mestoOsnivanja) {
		this.naziv = naziv;
		this.id = id;
		this.mestoOsnivanja = mestoOsnivanja;
		igraci = new ArrayList<Igrac>();
		statistikaKluba = new ArrayList<StatistikaKluba>();
	}

	public String getNaziv() {
		return naziv;
	}
	
	@JsonProperty("naziv")
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	public Mesto getMestoOsnivanja() {
		return mestoOsnivanja;
	}

	// ako igrac vec postoji u ovom klubu vraca -1
	// ako igrac vec postoji u nekom drugom klubu vraca -2
	// ako igrac ima isti broj dresa sa nekim igracem u klubu -3
	public int dodajIgraca(Igrac igrac) {
		if (igrac.klub != null && igrac.klub != this) {
			return -2;
		}
			for (Igrac it : igraci) {
				if (it.getId() == igrac.getId()) {
					return -1;
				}
				else if(it.getBrojDresa() == igrac.getBrojDresa()){
					return -3;
				}
			}
		
		igraci.add(igrac);
		igrac.klub = this;
		return 0;
	}

	public boolean obrisiIgraca(Igrac igrac){
		return igraci.remove(igrac);
	}
	
	//OVO TI NE TREBA IZMENIO SAM TI U DIJALOGU
	/*public ArrayList<Igrac> preuzmiIgrace() {
		ArrayList<Igrac> listaIgraca = new ArrayList<Igrac>();
		for (Igrac igrac : igraci) {
			listaIgraca.add(igrac);
		}

		return listaIgraca;
	}*/

}
