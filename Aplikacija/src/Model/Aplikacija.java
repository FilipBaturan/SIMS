package Model;

import java.util.ArrayList;

import GUI.PrijavljivanjeDijalog;

public class Aplikacija {
	
	static ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>(); 
	
	
	public Aplikacija() {
		new PrijavljivanjeDijalog();
	}

	
	public static boolean pronadjiKorisnika(String korisnickoImeTekst, String lozinkaTekst)
	{
		for (Korisnik korisnik : listaKorisnika) {
			
			if( (korisnik.getKorisnickoIme().compareTo(korisnickoImeTekst) == 0) &&
					(korisnik.getLozinka().compareTo(lozinkaTekst) == 0) )
				return true;
		}
		
		return false;
	}
			
}
