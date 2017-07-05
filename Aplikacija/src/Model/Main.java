package Model;

import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import UIPodsistem.IgraciUI;
import UIPodsistem.KorisnikUI;


public class Main {

	public static void main(String[] args) throws ParseException, JsonGenerationException, JsonMappingException, IOException {
		new Aplikacija();
		Aplikacija.dodajKorisnika("aa", "aa");
		Aplikacija.dodajKorisnika("bb", "bb");
		Aplikacija.dodajKorisnika("cc", "cc");

		Aplikacija.dodajKlub("KLUB1");
		Aplikacija.dodajKlub("KLUB2");
		Aplikacija.dodajKlub("KLUB3");
		Aplikacija.dodajKlub("KLUB4");
		
		IgraciUI i = new IgraciUI();
		i.iscitajIgrace();
		
		KorisnikUI k = new KorisnikUI();
		k.upisiKorisnike();
		
	}

}
