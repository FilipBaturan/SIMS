package Model;

public class Main {

	public static void main(String[] args) {
		new Aplikacija();
		Aplikacija.dodajKorisnika("aa","aa");
		Aplikacija.dodajKorisnika("bb", "bb");
		Aplikacija.dodajKorisnika("cc", "cc");
		
		Aplikacija.dodajMesto("11000", "Beogra");
		Aplikacija.dodajMesto("11070", "Novi Beograd");
		Aplikacija.dodajMesto("26300", "Vrsac");
		
		Aplikacija.dodajKlub("KLUB1");
		Aplikacija.dodajKlub("KLUB2");
		Aplikacija.dodajKlub("KLUB3");
		Aplikacija.dodajKlub("KLUB4");
		
		
	}

}
