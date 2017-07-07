package main;



import java.util.Date;

import GUI.Test;
import Model.Aplikacija;
import Model.Igrac;
import Model.Klub;
import Model.Mesto;
import Model.Sala;
import Model.Utakmica;


public class Main {

	public static void main(String[] args) {
		new Aplikacija();
		Aplikacija.dodajKorisnika("aa","aa");
		Aplikacija.dodajKorisnika("bb", "bb");
		Aplikacija.dodajKorisnika("cc", "cc");
		
		Mesto mesto1 = new Mesto("11000", "Beogra");
		Mesto mesto2 = new Mesto("11070", "Novi Beograd");
		Mesto mesto3 = new Mesto("26300", "Vrsac");
		Aplikacija.listaMesta.add(mesto1);
		Aplikacija.listaMesta.add(mesto2);
		Aplikacija.listaMesta.add(mesto3);
		
		Sala sala1 = new Sala("sala1",1,mesto1);
		Sala sala2 = new Sala("sala2",2,mesto2);
		Aplikacija.listaSala.add(sala1);
		Aplikacija.listaSala.add(sala2);
		
		Klub k1 = new Klub("Klub1", 1,mesto1);
		Igrac igrac1 = new Igrac(1, "Ime1", "Prezime1", new Date(1998-01-01), 2, 198);
		Igrac igrac2 = new Igrac(2, "Ime2", "Prezime2", new Date(1998-02-01), 22, 198); 
		Igrac igrac3 = new Igrac(3, "Ime3", "Prezime3", new Date(1998-01-01), 23, 198);
		Igrac igrac4 = new Igrac(4, "Ime4", "Prezime4", new Date(1998-03-01), 24, 198);
		Igrac igrac5 = new Igrac(5, "Ime5", "Prezime5", new Date(1998-05-01), 25, 198);
		Igrac igrac6 = new Igrac(6, "Ime6", "Prezime6", new Date(1998-06-01), 26, 198);
		Igrac igrac7 = new Igrac(7, "Ime7", "Prezime7", new Date(1998-07-01), 27, 198);
		Igrac igrac8 = new Igrac(8, "Ime8", "Prezime8", new Date(1998-01-01), 28, 198);
		Igrac igrac9 = new Igrac(9, "Ime9", "Prezime9", new Date(1998-01-01), 29, 198);
		Igrac igrac10 = new Igrac(10, "Ime10", "Prezime10", new Date(1998-01-01), 30, 198);
		k1.dodajIgraca(igrac1);k1.dodajIgraca(igrac2);k1.dodajIgraca(igrac3);
		k1.dodajIgraca(igrac4);k1.dodajIgraca(igrac5);k1.dodajIgraca(igrac6);
		k1.dodajIgraca(igrac7);k1.dodajIgraca(igrac8);k1.dodajIgraca(igrac9);
		k1.dodajIgraca(igrac10);
		
		Klub k2 = new Klub("Klub2", 2,mesto2);
		Igrac igrac11 = new Igrac(11, "Ime11", "Prezime11", new Date(1998-01-01), 2, 198);
		Igrac igrac12 = new Igrac(12, "Ime12", "Prezime12", new Date(1998-02-01), 22, 198); 
		Igrac igrac13 = new Igrac(13, "Ime13", "Prezime13", new Date(1998-01-01), 23, 198);
		Igrac igrac14 = new Igrac(14, "Ime14", "Prezime14", new Date(1998-03-01), 24, 198);
		Igrac igrac15 = new Igrac(15, "Ime15", "Prezime15", new Date(1998-05-01), 25, 198);
		Igrac igrac16 = new Igrac(16, "Ime16", "Prezime16", new Date(1998-06-01), 26, 198);
		Igrac igrac17 = new Igrac(17, "Ime17", "Prezime17", new Date(1998-07-01), 27, 198);
		Igrac igrac18 = new Igrac(18, "Ime18", "Prezime18", new Date(1998-01-01), 28, 198);
		Igrac igrac19 = new Igrac(19, "Ime19", "Prezime19", new Date(1998-01-01), 29, 198);
		Igrac igrac20 = new Igrac(20, "Ime20", "Prezime20", new Date(1998-01-01), 30, 198);
		k2.dodajIgraca(igrac11);k2.dodajIgraca(igrac12);k2.dodajIgraca(igrac13);
		k2.dodajIgraca(igrac14);k2.dodajIgraca(igrac15);k2.dodajIgraca(igrac16);
		k2.dodajIgraca(igrac17);k2.dodajIgraca(igrac18);k2.dodajIgraca(igrac19);
		k2.dodajIgraca(igrac20);
		
		Klub k3 = new Klub("Klub3", 3,mesto3);
		Igrac igrac21 = new Igrac(21, "Ime21", "Prezime21", new Date(1998-01-01), 2, 198);
		Igrac igrac22 = new Igrac(22, "Ime22", "Prezime22", new Date(1998-02-01), 22, 198); 
		Igrac igrac23 = new Igrac(23, "Ime23", "Prezime23", new Date(1998-01-01), 23, 198);
		Igrac igrac24 = new Igrac(24, "Ime24", "Prezime24", new Date(1998-03-01), 24, 198);
		Igrac igrac25 = new Igrac(25, "Ime25", "Prezime25", new Date(1998-05-01), 25, 198);
		Igrac igrac26 = new Igrac(26, "Ime26", "Prezime26", new Date(1998-06-01), 26, 198);
		Igrac igrac27 = new Igrac(27, "Ime27", "Prezime27", new Date(1998-07-01), 27, 198);
		Igrac igrac28 = new Igrac(28, "Ime28", "Prezime28", new Date(1998-01-01), 28, 198);
		Igrac igrac29 = new Igrac(29, "Ime29", "Prezime29", new Date(1998-01-01), 29, 198);
		Igrac igrac30 = new Igrac(30, "Ime30", "Prezime30", new Date(1998-01-01), 30, 198);
		k3.dodajIgraca(igrac21);k3.dodajIgraca(igrac22);k3.dodajIgraca(igrac23);
		k3.dodajIgraca(igrac24);k3.dodajIgraca(igrac25);k3.dodajIgraca(igrac26);
		k3.dodajIgraca(igrac27);k3.dodajIgraca(igrac28);k3.dodajIgraca(igrac29);
		k3.dodajIgraca(igrac30);
		
		Aplikacija.dodajKlub(k1);
		Aplikacija.dodajKlub(k2);
		Aplikacija.dodajKlub(k3);
		//Aplikacija.dodajKlub(k4);

		
		
		Utakmica u = new Utakmica(0, k1, k2, sala1);
		//Test t = new Test(u);
		//u.pocetak();
		
		
	}

}
