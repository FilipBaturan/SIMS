package Model;

import java.util.ArrayList;
import java.util.Date;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;


public class Igrac extends Osoba {
	int brojDresa;
	int visina;
=======
import Model.Evidentiranje.UcinakIgraca;

public class Igrac extends Osoba {
	private String brojDresa;
	private int visina;
	public Klub klub;
	public ArrayList<UcinakIgraca> ucinak;
>>>>>>> 17c4d1099af0f7868f51324d98664c5c755a1822
	
	public Igrac(){}

	public Igrac(int id, String ime, String prezime, Date datumRodjenja,
			int brojDresa,int visina) {
		super(id, ime, prezime, datumRodjenja);
		this.brojDresa = brojDresa;
		this.visina = visina;
	}
<<<<<<< HEAD
	
	public int getBrojDresa() {
=======

	
	
	public String getBrojDresa() {
>>>>>>> 17c4d1099af0f7868f51324d98664c5c755a1822
		return brojDresa;
	}

	@JsonProperty("brojDresa")
	public void setBrojDresa(int brojDresa) {
		this.brojDresa = brojDresa;
	}

	public int getVisina() {
		return visina;
	}

	@JsonProperty("visina")
	public void setVisina(int visina) {
		this.visina = visina;
	}
	
	
	
	
}
