package Model;

import java.text.ParseException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import Model.Evidentiranje.UcinakIgraca;

public class Igrac extends Osoba {
	

	private int brojDresa;
	private double visina;
	public Klub klub;
	public ArrayList<UcinakIgraca> ucinak;

	
	public Igrac(){}

	public Igrac(int id, String ime, String prezime, String datumRodjenja,
			int brojDresa,double visina) throws ParseException {
		super(id, ime, prezime, datumRodjenja);
		this.brojDresa = brojDresa;
		this.visina = visina;
		ucinak = new ArrayList<>();
	}
	
	
	public int getBrojDresa() {
		return brojDresa;
	}

	@JsonProperty("brojDresa")
	public void setBrojDresa(int brojDresa) {
		this.brojDresa = brojDresa;
	}

	public double getVisina() {
		return visina;
	}

	@JsonProperty("visina")
	public void setVisina(double visina) {
		this.visina = visina;
	}
	
	
	@Override
	public String toString() {
		return ime + " " + prezime;
	}
	
}
