package Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import Model.Evidentiranje.UcinakTrenera;

public class Trener extends Osoba {
	
	public Klub klub;
	public ArrayList<UcinakTrenera> ucinak;
	
	public Trener(){}

	public Trener(int id, String ime, String prezime, String datumRodjenja) throws ParseException {
		super(id, ime, prezime, datumRodjenja);
		
	}
	
	
	
}
