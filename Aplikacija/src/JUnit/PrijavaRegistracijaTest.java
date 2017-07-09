package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Model.Aplikacija;
import Model.Korisnik;

public class PrijavaRegistracijaTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		Korisnik k1 = new Korisnik("aca", "aca");
		Korisnik k2 = new Korisnik("cofi", "cofi");
		Korisnik k3 = new Korisnik("deni", "deni");
		
		Aplikacija.dodajKorisnika(k1);
		Aplikacija.dodajKorisnika(k2);
		Aplikacija.dodajKorisnika(k3);
	}
	
	@AfterClass
	public static void tearDownAfretClass() throws Exception{
		
	}
	
	@Before
	public void setUp()  throws Exception{
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void testPrijavaKorisnika(){
		String korisnicko1 = "aca";
		String korisnicko2 = "marko";
		String lozinka1 = "aca";
		String lozinka2 = "cofi";
		
		// uspesno prijavljivanje korsinika na sistem
		assertTrue(Aplikacija.prijavaKorisnika(korisnicko1, lozinka1));
		
		//neuspesno prijavljivanje korisnika na sistem
		assertFalse(Aplikacija.prijavaKorisnika(korisnicko2, lozinka2));
		assertFalse(Aplikacija.prijavaKorisnika(korisnicko1, lozinka2));
	}
	
	@Test
	public void testRegistrovanjeKorisnika(){
		String korisnicko1 = "aca";
		String korisnicko2 = "marko";
		String korisnicko3 = "kica";
 		String lozinka1 = "aca";
		String lozinka2 = "cofi"; 
		String lozinka3 = "xsdv";
		
		//uspesno registrovanje korisnika
		assertTrue(Aplikacija.registrovanjeKorisnika(korisnicko2, lozinka2, lozinka2));
		
		//vec postoji korisnik, neuspesno registrovanje
		assertFalse(Aplikacija.registrovanjeKorisnika(korisnicko1, lozinka1, lozinka1));
		
		//nije uneta dobra potvrda, neuspesno registrovanje
		assertFalse(Aplikacija.registrovanjeKorisnika(korisnicko3, lozinka3, lozinka2));
	}
}
