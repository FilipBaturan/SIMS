package Model;

import java.util.Date;

public class Igrac extends Osoba {
	String brojDresa;
	double visina;
	
	public Igrac(){}

	public Igrac(int id, String ime, String prezime, Date datumRodjenja,
			String brojDresa,double visina) {
		super(id, ime, prezime, datumRodjenja);
		this.brojDresa = brojDresa;
		this.visina = visina;
	}

	public String getBrojDresa() {
		return brojDresa;
	}

	public void setBrojDresa(String brojDresa) {
		this.brojDresa = brojDresa;
	}

	public double getVisina() {
		return visina;
	}

	public void setVisina(double visina) {
		this.visina = visina;
	}
	
	
	
	
}
