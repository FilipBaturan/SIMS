package Model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	public void dodajIgraca(Igrac i) {
		igraci.add(i);
	}

}
