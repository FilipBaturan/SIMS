package Model;

import java.util.ArrayList;
import java.util.Timer;

import Model.Enumeracije.VrstaIzgubljeneLopte;
import Model.Enumeracije.VrstaLicneGreske;
import Model.Evidentiranje.Izmena;
import Model.Evidentiranje.StatistikaKluba;
import Model.Evidentiranje.UcinakIgraca;
import Model.Evidentiranje.UcinakTrenera;
import Model.StanjeUtakmice.Stanje;

public class Utakmica {
	private int id;
	private Stanje trenutnoStanje;
	private int vreme;
	private boolean pokrenut;
	private Timer timer;
	public Sala sala;
	public Klub domacin;
	public Klub gost;
	public ArrayList<Igrac> aktivni;

	public Utakmica() {
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
	}
	//TREBA I AKTIVNIM IGRACIMA DA UCECAVA VREME
	private void otkucavanjeVremena() {
		while(pokrenut){
			
		}
	}

	public void postaviStartere() {
	}

	public void zaustaviVreme() {
		pokrenut = false;
	}

	public void pokreniVreme() {
		pokrenut = true;
	}

	public void prikazStatistike() {

	}

	public void prikazTerena() {

	}
	
	public void prikazDijaloga(Osoba osoba){
		
	}
	
	public void prikazDijaloga(Klub klub){
		
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
		//izvrsi izemnu
		for(Igrac igrac:aktivni){
			if(igrac == izlazi){
				igrac = ulazi;
			}
		}
		
	}
	
	public void tuca(){
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
	
	public void azuriranje(Osoba osoba,int tip,int vrednost,int zona){
		if(osoba instanceof Igrac){
			//pronadji utakmicu koja se trenutno azurira
			for(UcinakIgraca ucinak:((Igrac)osoba).ucinak){
				if(ucinak.utakmica == this){
					ucinak.azuriranje(tip, vrednost, zona);
					break;
				}
			}
		}
		else if(osoba instanceof Trener){
			for(UcinakTrenera ucinak:((Trener)osoba).ucinak){
				if(ucinak.utakmica == this){
					ucinak.azuriranje(tip);
					break;
				}
			}
		}
	}
	
	public void azuriranje(Klub klub,int tip,int vrednost){
		for(StatistikaKluba statistika:klub.statistikaKluba){
			if(statistika.utakmica == this){
				statistika.azuriranje(tip, vrednost);
				break;
			}
		}
	}
}

