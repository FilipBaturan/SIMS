package Model;

import java.text.ParseException;
import java.util.ArrayList;

import GUI.PrijavljivanjeDijalog;

public class Aplikacija {
	
	public static ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>(); 
	public static ArrayList<Mesto> listaMesta = new ArrayList<Mesto>();
	public static ArrayList<Klub> listaKlubova = new ArrayList<Klub>();
	public static ArrayList<Sala> listaSala = new ArrayList<Sala>();
	public static ArrayList<Igrac> listaIgraca = new ArrayList<Igrac>();
	public static ArrayList<Trener> listaTrenera = new ArrayList<Trener>();
	public static ArrayList<Osoba> listaSudija = new ArrayList<Osoba>();
	public static ArrayList<Utakmica> listaUtakmica = new ArrayList<Utakmica>();
	public static ArrayList<Osoba> listaDelegata = new ArrayList<Osoba>(); 
	
	private static int idKlub = 0;
	private static int idSala = 0;
	private static int idOsoba = 0;
	private static int idUtakmica = 0;
	
	public static int generisiKluc(char tip){
		if(tip == 'K') {return ++idKlub;}
		else if(tip == 'S') {return ++idSala;}
		else if(tip == 'O') {return ++idOsoba;}
		else if(tip == 'U') {return ++idUtakmica;}
		else return -1;
		
	}
	
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
	
	
	public static boolean pronadjiKorisnika(Korisnik k)
	{
		for (Korisnik korisnik : listaKorisnika) {
			
			if( (korisnik.getKorisnickoIme().compareTo(k.getKorisnickoIme()) == 0) &&
					(korisnik.getLozinka().compareTo(k.getLozinka()) == 0) )
				return true;
		}
		
		return false;
	}
	
	
	public static boolean dodajKorisnika(String korisnickoIme, String lozinka){
		if (!pronadjiKorisnika(korisnickoIme, lozinka)){
			listaKorisnika.add(new Korisnik(korisnickoIme, lozinka));
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public static boolean dodajKorisnika(Korisnik korisnik){
		String ime = korisnik.getKorisnickoIme();
		String lozinka = korisnik.getLozinka();
		if (!pronadjiKorisnika(ime, lozinka)){
			listaKorisnika.add(korisnik);
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean obrisiKorisnika(Korisnik korisnik){
		if(listaKorisnika.contains(korisnik))
		{
			listaKorisnika.remove(korisnik);
			return true;
		}
		return false;
	}
	
	
	public static boolean izmeniKoriniska(Korisnik k, String novoIme, String novaSifra)
	{
		if (!pronadjiKorisnika(k))
			return false;
		if (novoIme.compareTo("") == 0 )
			novoIme = k.getKorisnickoIme();
		if (novaSifra.compareTo("") == 0)
			novaSifra = k.getLozinka();
		
		Korisnik noviKorisnik = new Korisnik(novoIme, novaSifra);
		
		
		if(pronadjiKorisnika(noviKorisnik))
			return false;
		else
		{
			k.setKorisnickoIme(novoIme);
			k.setLozinka(novaSifra);
			return true;
		}
			
	}
	
	public static boolean pronadjiMesto(Mesto mesto){
		return listaMesta.contains(mesto);
	}
	
	public static Mesto pronadjiMesto(String naziv){
		for(Mesto mesto:listaMesta){
			if(mesto.getNaziv().compareTo(naziv) == 0)
				return mesto;
		}
		return null;
	}
	
	public static boolean obrisiMesto(Mesto mesto){
		if(listaMesta.contains(mesto))
			return listaMesta.remove(mesto);
		return false;
	}
	
	public static boolean obrisiMesto(String naziv){
		
		for(int i = 0; i< listaMesta.size();i++){
			if(listaMesta.get(i).getNaziv().compareTo(naziv)==0){
				listaMesta.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static boolean dodajMesto(String postanski, String naziv){
		if(pronadjiMesto(naziv) == null){
			listaMesta.add(new Mesto(postanski, naziv));
			return true;
		}
		return false;
	}
	
	
	public static boolean dodajKlub(Klub klub){
		if (!pronadjiKlub(klub)){
			listaKlubova.add(klub);
			return true;
		}
		return false;
	}
	
	public static boolean dodajKlub(String naziv){
		if(pronadjiKlub(naziv) == null){
			listaKlubova.add(new Klub(naziv, generisiKluc('K')));
			return true;
		}
		return false;
		
	}
	
	public static boolean pronadjiKlub(Klub klub){
		return listaKlubova.contains(klub);
	}
	
	public static Klub pronadjiKlub(String naziv)
	{
		for (Klub klub : listaKlubova) {
			if ( (klub.getNaziv().compareTo(naziv)) == 0)
				return klub;
		}
		
		return null;
	}
	
	public static Klub pronadjiKlub(int id){
		for(Klub klub:listaKlubova){
			if(klub.getId() == id){
				return klub;
			}
		}
		return null;
	}
	
	public static boolean obrisiKlub(Klub klub){
		return listaKlubova.remove(klub);
	}
	
	public static boolean obrisiKlub(int id){
		
		for(int i = 0;i<listaKlubova.size();i++){
			if(listaKlubova.get(i).getId() == id){
				listaKlubova.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	public static String[] preuzmiKlubove()
	{
		int brojKlubova = listaKlubova.size();
		String[] klubovi = new String[brojKlubova];
		int brojac = -1;
		for (Klub klub : listaKlubova) 
			klubovi[++brojac] = klub.getNaziv();
		
		return klubovi;
	}
	

	public static boolean dodajSalu(String naziv,Mesto mesto){
		if (pronadjiSalu(naziv) == null){
			listaSala.add(new Sala(naziv,generisiKluc('S'),mesto));
			return true;
		}
		return false;
	}
	
	public static Sala pronadjiSalu(int id){
		for(Sala sala:listaSala){
			if(sala.getId() == id) return sala;
		}
		return null;
	}
	
	public static Sala pronadjiSalu(String naziv){
		for(Sala sala:listaSala){
			if(sala.getNazivSale().compareTo(naziv)==0)
				return sala;
		}
		return null;
	}
	
	public static boolean obrisiSalu(Sala sala){
		return listaSala.remove(sala);
	}
	
	public static boolean obrisiSalu(String naziv){
		
		for(int i = 0;i <listaSala.size();i++){
			if(listaSala.get(i).getNazivSale().compareTo(naziv)==0){
				listaSala.remove(i);
				return true;}
		}
		
		return false;
	}
	
	public static boolean obrisiSalu(int id){
		
		for(int i = 0;i <listaSala.size();i++){
			if(listaSala.get(i).getId() == id){
				listaSala.remove(i);
				return true;
			}
		}
		return false;
	}
	

	public static boolean dodajIgraca(String ime, String prezime, String datumRodjenja,
			int brojDresa,double visina) throws ParseException{
		//if(pronadjiIgraca(brojDresa)== null){

		listaIgraca.add(new Igrac(generisiKluc('O'), ime, prezime, datumRodjenja,
				brojDresa, visina));
			return true;
		/*}
		return false;*/
	}
	
	public static boolean obrisiIgraca(Igrac igrac){
		return listaIgraca.remove(igrac);
	}
	
	public static boolean obirisiIgraca(int id){
		
		for(int i = 0; i<listaIgraca.size();i++){
			if(listaIgraca.get(i).getId() == id){
				listaIgraca.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static Igrac pronadjiIgraca(int id){
		for(Igrac igrac:listaIgraca){
			if(igrac.getId()==id) return igrac;
		}
		return null;
	}
	
	public static String[] preuzmiUtakmice(){
		int broj = listaUtakmica.size();
		String[] utakmice = new String[broj];
		int brojac = -1;
		for(Utakmica u : listaUtakmica){
			String utakmica = u.getDomacin().getNaziv() +  "-" + u.getGost().getNaziv() + " " + u.getId() + " ";
			utakmice[++brojac] = utakmica;
		}
		return utakmice;
	}
	
	public static Igrac pronadjiIgraca(String imeIPrezime){
		String ime;
		String prezime;
		
		
		String[] reci = imeIPrezime.split(" ");
		ime = reci[0];
		prezime = reci[1];
		
		for(Igrac igrac:listaIgraca){
			if( (igrac.getIme().compareTo(ime) == 0) && (igrac.getPrezime().compareTo(prezime) == 0 ) ) return igrac;
			
		}
		return null;
	}
	
	public static boolean prijavaKorisnika(String korisnickoImeTekst, String lozinkaTekst){
		boolean nasao = false;
		if (korisnickoImeTekst.compareTo("") != 0 && lozinkaTekst.compareTo("") != 0) {
			for(Korisnik k : Aplikacija.listaKorisnika){
				if (k.getKorisnickoIme().compareTo(korisnickoImeTekst) == 0 && k.getLozinka().compareTo(lozinkaTekst) == 0){
					nasao = true;
					break;
				}
			}
		}
		return nasao;
	}
	
	public static boolean registrovanjeKorisnika(String korisnickoIme, String lozinka, String potvrdnaLozinka){
		boolean prihvatanje = false;
		if (!Aplikacija.pronadjiKorisnika(korisnickoIme, lozinka)) {
			if (lozinka.compareTo(potvrdnaLozinka) == 0) {
				Aplikacija.dodajKorisnika(korisnickoIme, lozinka);
				prihvatanje = true;
			}
		}
		return prihvatanje;
	}
	
	/*public static Igrac pronadjiIgraca(double brojDresa){
		for(Igrac igrac:listaIgraca){
			if(igrac.getBrojDresa() == brojDresa) return igrac;
		}
		return null;
	}*/
	
	public static void dodajTrenera(String ime, String prezime,
			String datumRodjenja) throws ParseException{
		listaTrenera.add(new Trener(generisiKluc('O'), ime, prezime,
				datumRodjenja));
	}
	
	public static Trener pronadjiTrenera(int id){
		for(Trener trener:listaTrenera){
			if(trener.getId() == id) return trener;
		}
		return null;
	}
	
	public static boolean obrisiTrenera(Trener trener){
		return listaTrenera.remove(trener);
	}
	
	public static boolean obrisiTrenera(int id){
		
		for(int i = 0;i<listaTrenera.size();i++){
			if(listaTrenera.get(i).getId()==id){
				listaTrenera.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static void dodajSudiju( String ime, String prezime, String datumRodjenja) throws ParseException{
		listaSudija.add(new Osoba(generisiKluc('O'),ime,prezime,datumRodjenja));
	}
	
	public static Osoba pronadjiSudiju(int id){
		for(Osoba osoba:listaSudija){
			if(osoba.getId()== id) return osoba;
		}
		return null;
	}
	
	public static boolean obrisiSudiju(Osoba sudija){
		return listaSudija.remove(sudija);
	}
	
	public static boolean obrisiSudiju(int id){
		for(Osoba sudija:listaSudija){
			if(sudija.getId() == id){
				listaSudija.remove(sudija);
				return true;
			}
		}
		return false;
	}
	
	public static void dodajUtakmicu(Klub domacin,Klub gost){
		listaUtakmica.add(new Utakmica(generisiKluc('U'),domacin,gost));
	}
	
	public static void dodajUtakmicu(Klub domacin,Klub gost,Sala sala, String datum) throws ParseException{
		listaUtakmica.add(new Utakmica(generisiKluc('U'), domacin, gost, sala, datum));
	}
	/*public static void dodajUtakmicu(Klub domacin,Klub gost,Sala sala){
		listaUtakmica.add(new Utakmica(generisiKluc('U'), domacin, gost, sala));
	}*/
	
	public static Utakmica pronadjiUtamicu(int id){
		for(Utakmica utakmica:listaUtakmica){
			if(utakmica.getId()== id){
				return utakmica;
			}
		}
		return null;
	}
	
	
	
	public static boolean obrisiUtakmicu(Utakmica utakmica){
		return listaUtakmica.remove(utakmica);
	}
	
	public static boolean obrisiUtakmicu(int id){
		for(Utakmica utakmica:listaUtakmica){
			if(utakmica.getId() == id){
				listaUtakmica.remove(utakmica);
				return true;
			}
		}
		return false;
	}
	
	public static boolean dodajUtakmicu(Utakmica u)
	{
		if (!listaUtakmica.contains(u)){
			listaUtakmica.add(u);
			return true;
		}
		return false;
		
	}

	
	
	public static boolean proveriBazu(){
		return listaKlubova.size()>=2 && listaSala.size()>=1
				&& listaDelegata.size() >=1 && listaSudija.size()>=3;
	}
	
	public static boolean proveriBazu(Klub klub){
		return klub.igraci.size()>=5;
	}
	
	public static String prikaziGresku(){
		return "U bazi mora da  postoje bar dva kluba, jedna sala"
				+ ",tri sudije i delegat";
	}
	
	public static String prikaziGresku(Klub klub){
		return "Selektovani klub " + klub.getNaziv() + " nema pet igraca" ; 
	}
	
	public static String prikaziGresku(Klub gost,Klub domacin){
		return "Seletkovani klubovi nemaju po pet igraca";
	}
			
}
