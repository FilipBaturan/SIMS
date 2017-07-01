package Model;

import java.util.ArrayList;

import GUI.PrijavljivanjeDijalog;

public class Aplikacija {
	
	public static ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>(); 
	public static ArrayList<Mesto> listaMesta = new ArrayList<Mesto>();
	public static ArrayList<Klub> listaKlubova = new ArrayList<Klub>();
	public static ArrayList<Sala> listaSala = new ArrayList<Sala>();
	
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
	
	public static void dodajKorisnika(String korisnickoIme, String lozinka){
		listaKorisnika.add(new Korisnik(korisnickoIme, lozinka));
	}
	
	public static void dodajMesto(int postanski, String naziv){
		listaMesta.add(new Mesto(postanski, naziv));
	}
	
	public static void dodajKlub(int id, String naziv){
		listaKlubova.add(new Klub(naziv, id));
	}
	
	public static void dodajSalu(String naziv, int id){
		listaSala.add(new Sala(naziv, id));
	}
			
}
