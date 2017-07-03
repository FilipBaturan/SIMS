package Model;

import java.util.ArrayList;
import java.util.Date;

public class Igrac extends Osoba {
	private String brojDresa;
	private int visina;
	public Klub klub;
	public ArrayList<UcinakIgraca> ucinak;
	
	public Igrac(){}

	public Igrac(int id, String ime, String prezime, Date datumRodjenja,
			String brojDresa,int visina) {
		super(id, ime, prezime, datumRodjenja);
		this.brojDresa = brojDresa;
		this.visina = visina;
	}

	public Igrac(int id, String ime, String prezime, Date datumRodjenja,
			String brojDresa,int visina,Klub klub) {
		super(id, ime, prezime, datumRodjenja);
		this.brojDresa = brojDresa;
		this.visina = visina;
		this.klub = klub;
	}
	
	public String getBrojDresa() {
		return brojDresa;
	}

	public void setBrojDresa(String brojDresa) {
		this.brojDresa = brojDresa;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}
	
	
	
	
}
