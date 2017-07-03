package Model;

import java.util.ArrayList;
import java.util.Date;

public class Trener extends Osoba {
	
	public Klub klub;
	public ArrayList<UcinakTrenera> ucinak;
	
	public Trener(){}

	public Trener(int id, String ime, String prezime, Date datumRodjenja) {
		super(id, ime, prezime, datumRodjenja);
		
	}
	
	public Trener(int id, String ime, String prezime, Date datumRodjenja,Klub klub) {
		super(id, ime, prezime, datumRodjenja);
		this.klub = klub;
	}
	
	
}
