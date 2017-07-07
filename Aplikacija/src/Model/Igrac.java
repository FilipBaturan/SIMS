package Model;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import Model.Evidentiranje.UcinakIgraca;

public class Igrac extends Osoba {
	

	private int brojDresa;
	private double visina;
	public Klub klub;
	public ArrayList<UcinakIgraca> ucinak;

	
	public Igrac(){}

	public Igrac(int id, String ime, String prezime, Date datumRodjenja,
			int brojDresa,double visina) {
		super(id, ime, prezime, datumRodjenja);
		this.brojDresa = brojDresa;
		this.visina = visina;
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
		return "Igrac " + getIme() + " " + getPrezime();
	}
	
}
