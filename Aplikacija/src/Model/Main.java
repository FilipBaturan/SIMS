package Model;

<<<<<<< HEAD
=======
import java.util.Date;

>>>>>>> ae55ecf52fb700202de25e76c1d716c722d16749
public class Main {

	public static void main(String[] args) {
		new Aplikacija();
		Aplikacija.dodajKorisnika("aa","aa");
		Aplikacija.dodajKorisnika("bb", "bb");
		Aplikacija.dodajKorisnika("cc", "cc");
		
<<<<<<< HEAD
		Aplikacija.dodajMesto("11000", "Beogra");
		Aplikacija.dodajMesto("11070", "Novi Beograd");
		Aplikacija.dodajMesto("26300", "Vrsac");
		
		Aplikacija.dodajKlub("KLUB1");
		Aplikacija.dodajKlub("KLUB2");
		Aplikacija.dodajKlub("KLUB3");
		Aplikacija.dodajKlub("KLUB4");
=======
		Klub k1 = new Klub("Klub1", 1);
		k1.dodajIgraca(new Igrac(1, "Ime1", "Prezime1", new Date(1998-01-01), "2", 198));
		k1.dodajIgraca(new Igrac(2, "Ime2", "Prezime2", new Date(1998-02-01), "24", 198));
		
		Klub k2 = new Klub("Klub2", 2);
		k2.dodajIgraca(new Igrac(3, "Ime3", "Prezime3", new Date(1998-01-01), "23", 198));
		k2.dodajIgraca(new Igrac(4, "Ime4", "Prezime4", new Date(1998-02-01), "12", 198));
		
		Klub k3 = new Klub("Klub3", 3);
		k3.dodajIgraca(new Igrac(5, "Ime5", "Prezime5", new Date(1998-03-01), "7", 198));
		k3.dodajIgraca(new Igrac(6, "Ime6", "Prezime6", new Date(1998-04-01), "99", 198));
		
		Aplikacija.dodajKlub(k1);
		Aplikacija.dodajKlub(k2);
		Aplikacija.dodajKlub(k3);
		//Aplikacija.dodajKlub(k4);
>>>>>>> ae55ecf52fb700202de25e76c1d716c722d16749
		
		
	}

}
