package Model;

import java.util.ArrayList;

import Model.Evidentiranje.Izmena;
import Model.Evidentiranje.StatistikaKluba;
import Model.Evidentiranje.UcinakIgraca;
import Model.Evidentiranje.UcinakTrenera;
import Model.StanjeUtakmice.Odigravanje;
import Model.StanjeUtakmice.Stanje;

public class Utakmica {
	private int id;
	private Stanje trenutnoStanje;
	private int vreme;
	private boolean pokrenut;
	//private Timer timer;
	public Sala sala;
	public Klub domacin;
	public Klub gost;
	public ArrayList<Igrac> aktivni;

	public Utakmica() {
		pokrenut = false;
		aktivni = new ArrayList<Igrac>();
		
	}
	
	public Utakmica(int id,Klub domacin, Klub gost)
	{
		this.id = id;
		this.domacin = domacin;
		this.gost = gost;
		vreme = 0;
		pokrenut = false;
		aktivni = new ArrayList<Igrac>();
		
	}
	
	public Utakmica(int id,Klub domacin,Klub gost,Sala sala){
		this.id = id;
		this.domacin = domacin;
		this.gost = gost;
		this.sala = sala;
		pokrenut = false;
		aktivni = new ArrayList<Igrac>();
		
	}
	
	public int getId() {
		return id;
	}
	
	public Utakmica(Klub d, Klub g)
	{
		domacin = d;
		gost = g;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Stanje getTrenutnoStanje() {
		return trenutnoStanje;
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

	
	void postaviUcinke(){
		domacin.statistikaKluba.add(new StatistikaKluba(this));
		gost.statistikaKluba.add(new StatistikaKluba(this));
		for(Igrac igrac : domacin.igraci){
			igrac.ucinak.add(new UcinakIgraca(this));
		}
		domacin.trener.ucinak.add(new UcinakTrenera(this));
		
		for(Igrac igrac : gost.igraci){
			igrac.ucinak.add(new UcinakIgraca(this));
		}
		gost.trener.ucinak.add(new UcinakTrenera(this));
		
	}
	
	public void pocetak(){
		//postaviUcinke();
		pokrenut = true;
		promeniStanje(new Odigravanje(this));
	}
	
	public int izracunaCetvrtinu(){
		if(getVreme() <=10) return 1;
		else if(getVreme() >10
				&& getVreme() <=20) return 2;
		else if(getVreme() >20
				&& getVreme() <=30) return 3;
		else return 4;
	}
	
	public void promeniStanje(Stanje stanje) {
		trenutnoStanje = stanje;
		stanje.entry();
		stanje.do_();
	}
	

	public void postaviStartere(ArrayList<Igrac> igraci) {
		aktivni = igraci;
	}

	public void prekid() {
		trenutnoStanje.prekid();
	}

	public void nastavak() {
		trenutnoStanje.nastavak();
	}

	
	public void prikazDijaloga(Osoba osoba){
		trenutnoStanje.dijalog(osoba);
	}
	
	public void prikazDijaloga(Klub klub){
		trenutnoStanje.dijalog(klub);
	}

	public void selekcija(Igrac igrac){
		trenutnoStanje.selektcija(igrac);
	}

	public void izmena(Igrac ulazi, Igrac izlazi) {
		Klub klub = ulazi.klub;
		//napravi novu izmenu
		for(StatistikaKluba it:klub.statistikaKluba){
			if(it.utakmica == this){
				it.izmene.add(new Izmena(ulazi, izlazi));
				break;
			}
		}
		//izvrsi izmenu
		for(Igrac igrac:aktivni){
			if(igrac == izlazi){
				igrac = ulazi;
			}
		}
		
	}
	
	public void tuca(){
		trenutnoStanje.tuca();
	}
	
	public void azuriranje(int tip,int vrednost,int zona){
		trenutnoStanje.azuriranje(tip, vrednost, zona);
	}
	
	public void azuriranje(int tip,int vrednost){
		trenutnoStanje.azuriranje( tip, vrednost);
	}
}


