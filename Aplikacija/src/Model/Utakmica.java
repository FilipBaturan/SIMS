package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Evidentiranje.Izmena;
import Model.Evidentiranje.StatistikaKluba;
import Model.Evidentiranje.UcinakIgraca;
import Model.Evidentiranje.UcinakTrenera;
import Model.Evidentiranje.Enumeracije.VrstaLicneGreske;
import Model.StanjeUtakmice.Odigravanje;
import Model.StanjeUtakmice.Stanje;

public class Utakmica {
	private int id;
	private Stanje trenutnoStanje;
	private int vreme;
	private boolean pokrenut;
	// private Timer timer;
	public Date datum;
	public Sala sala;
	public Klub domacin;
	public Klub gost;
	public ArrayList<Igrac> aktivni;
	public Osoba delegat;
	public ArrayList<Osoba> sudije;

	public Utakmica() {
		pokrenut = false;
		aktivni = new ArrayList<Igrac>();
		sudije = new ArrayList<Osoba>();
	}

	public Utakmica(int id, Klub domacin, Klub gost) {
		this.id = id;
		this.domacin = domacin;
		this.gost = gost;
		vreme = 0;
		pokrenut = false;
		aktivni = new ArrayList<Igrac>();
		sudije = new ArrayList<Osoba>();
		delegat = new Osoba();

	}

	public Utakmica(int id, Klub domacin, Klub gost, Sala sala, String datum) throws ParseException {
		this.id = id;
		this.domacin = domacin;
		this.gost = gost;
		this.sala = sala;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.datum = sdf.parse(datum);
		pokrenut = false;
		aktivni = new ArrayList<Igrac>();
		sudije = new ArrayList<Osoba>();
		delegat = new Osoba();
	}

	public Utakmica(Klub d, Klub g) {
		domacin = d;
		gost = g;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Klub getDomacin() {
		return domacin;
	}

	public void setDomacin(Klub domacin) {
		this.domacin = domacin;
	}

	public Klub getGost() {
		return gost;
	}

	public void setGost(Klub gost) {
		this.gost = gost;
	}

	public Stanje getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public Osoba getDelegat() {
		return delegat;
	}

	public void setDelegat(Osoba delegat) {
		this.delegat = delegat;
	}

	public ArrayList<Osoba> getSudije() {
		return sudije;
	}

	public void setSudije(ArrayList<Osoba> sudije) {
		this.sudije = sudije;
	}

	public void setTrenutnoStanje(Stanje trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}

	public int getVreme() {
		return vreme;
	}

	public void setVreme(int vreme) {
		this.vreme = vreme;
	}

	public boolean isPokrenut() {
		return pokrenut;
	}

	public void setPokrenut(boolean pokrenut) {
		this.pokrenut = pokrenut;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	private void postaviUcinke() {
		domacin.statistikaKluba.add(new StatistikaKluba(this));
		gost.statistikaKluba.add(new StatistikaKluba(this));
		for (Igrac igrac : domacin.igraci) {
			igrac.ucinak.add(new UcinakIgraca(this));
		}
		domacin.trener.ucinak.add(new UcinakTrenera(this));

		for (Igrac igrac : gost.igraci) {
			igrac.ucinak.add(new UcinakIgraca(this));
		}
		gost.trener.ucinak.add(new UcinakTrenera(this));

	}

	

	public void evidentirajTucu(){
		for(StatistikaKluba it:domacin.statistikaKluba){
			if(it.utakmica == this){
				it.licneGreske.add(VrstaLicneGreske.tuca);
				break;
			}
		}
		for(StatistikaKluba it:gost.statistikaKluba){
			if(it.utakmica == this){
				it.licneGreske.add(VrstaLicneGreske.tuca);
				break;
			}
		}
	}
	
	public void pocetak() throws ParseException{
		postaviUcinke();
		pokrenut = true;
		promeniStanje(new Odigravanje(this));
	}

	public int izracunaCetvrtinu() {
		if (getVreme() <= 10)
			return 1;
		else if (getVreme() > 10 && getVreme() <= 20)
			return 2;
		else if (getVreme() > 20 && getVreme() <= 30)
			return 3;
		else
			return 4;
	}

	public void promeniStanje(Stanje stanje) throws ParseException {
		trenutnoStanje = stanje;
		stanje.entry();
		stanje.do_();
	}

	public void postaviStartere(ArrayList<Igrac> igraci) {
		aktivni = igraci;
	}

	public void prekid() throws ParseException {
		trenutnoStanje.prekid();
	}

	public void nastavak() throws ParseException {
		trenutnoStanje.nastavak();
	}

	public void prikazDijaloga(Osoba osoba) {
		trenutnoStanje.dijalog(osoba);
	}

	public void prikazDijaloga(Klub klub) {
		trenutnoStanje.dijalog(klub);
	}

	public void selekcija(Igrac igrac) {
		trenutnoStanje.selektcija(igrac);
	}

	public void izmena(Igrac ulazi, Igrac izlazi) {
		Klub klub = ulazi.klub;
		// napravi novu izmenu
		for (StatistikaKluba it : klub.statistikaKluba) {
			if (it.utakmica == this) {
				it.izmene.add(new Izmena(ulazi, izlazi));
				break;
			}
		}
		// izvrsi izmenu
		for (Igrac igrac : aktivni) {
			if (igrac == izlazi) {
				igrac = ulazi;
			}
		}

	}

	public void tuca() throws ParseException {
		trenutnoStanje.tuca();
	}

	public void azuriranje(int tip, int vrednost, int zona) {
		trenutnoStanje.azuriranje(tip, vrednost, zona);
	}

	public void azuriranje(int tip, int vrednost) {
		trenutnoStanje.azuriranje(tip, vrednost);
	}
}
