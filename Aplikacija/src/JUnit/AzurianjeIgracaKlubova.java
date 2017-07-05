package JUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Model.Aplikacija;
import Model.Igrac;
import Model.Klub;
import Model.Mesto;

public class AzurianjeIgracaKlubova {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Mesto mesto1 = new Mesto("11000", "Beogra");
		Mesto mesto2 = new Mesto("11070", "Novi Beograd");
		Aplikacija.listaMesta.add(mesto1);
		Aplikacija.listaMesta.add(mesto2);
	
		
		Klub k1 = new Klub("Klub1", 1,mesto1);
		Igrac igrac1 = new Igrac(1, "Ime1", "Prezime1", new Date(1998-01-01), 2, 198);
		Igrac igrac2 = new Igrac(2, "Ime2", "Prezime2", new Date(1998-02-01), 22, 198);
		k1.dodajIgraca(igrac1);
		k1.dodajIgraca(igrac2);
		
		Klub k2 = new Klub("Klub2", 2,mesto2);
		Igrac igrac3 = new Igrac(3, "Ime3", "Prezime3", new Date(1998-01-01), 23, 198);
		Igrac igrac4 = new Igrac(4, "Ime4", "Prezime4", new Date(1998-03-01), 24, 198);
		k2.dodajIgraca(igrac3);
		k2.dodajIgraca(igrac4);
		
		Aplikacija.dodajKlub(k1);
		Aplikacija.dodajKlub(k2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void dodavanjeIgracaTest() {
		Klub klub = Aplikacija.listaKlubova.get(0);
		int velicina = klub.igraci.size();
		klub.dodajIgraca
		(new Igrac(5, "Ime5", "Prezime5", new Date(1998-05-01), 25, 198));
		assertTrue(klub.igraci.size() == velicina + 1);
		
		//dodavanje igraca koji se vec nalazi u istom klubu
		int indikator = klub.dodajIgraca(klub.igraci.get(0));
		assertTrue("Dodao dva ista igraca u klub",indikator == -1);
		
		//dodavanje igraca sa istim brojem dresa
		indikator = klub.dodajIgraca
		(new Igrac(6, "Ime6", "Prezime6", new Date(1998-05-01), 25, 198));
		assertTrue("Dodao dva igraca sa isim dresom",indikator == -3);
	}
	
	@Test
	public void dodavanjeIgracaViseKlubovima(){
		Klub klub = Aplikacija.listaKlubova.get(0);
		int velicina = klub.igraci.size();
		int indikator = klub.dodajIgraca
				(Aplikacija.listaKlubova.get(1).igraci.get(0));
		assertTrue("Dodao igraca u dva razlicita kluba",indikator == -2);
		assertTrue(velicina == klub.igraci.size());
	}
	
	@Test
	public void brisanjeNepostojecegIgraca(){
		Klub klub = Aplikacija.listaKlubova.get(0);
		int velicina = klub.igraci.size();
		assertFalse(klub.obrisiIgraca
				(Aplikacija.listaKlubova.get(1).igraci.get(0)));
		assertTrue(klub.igraci.size() == velicina);
	}
	
	@Test
	public void brisanjeIgracaIzPrazneListeTest(){
		Klub klub = new Klub("Metalac",3,Aplikacija.listaMesta.get(0));
		assertFalse(klub.obrisiIgraca(null));
		assertTrue(klub.igraci.size() == 0);
			
	}

}
