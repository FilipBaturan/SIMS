package Model;

import java.util.ArrayList;

public class Klub {
	private String naziv;
	private int id;
	public StatistikaKluba statistikaKluba;
	public Mesto mestoOsnivanja;
	public Trener trener;
	public ArrayList<Igrac> igraci;

	public Klub() {
	}

	public Klub(String naziv, int id) {
		this.naziv = naziv;
		this.id = id;
	}
	
	public Klub(String naziv, int id,Mesto mestoOsnivanja) {
		this.naziv = naziv;
		this.id = id;
		this.mestoOsnivanja = mestoOsnivanja;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mesto getMestoOsnivanja() {
		return mestoOsnivanja;
	}


}
