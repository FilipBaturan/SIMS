package Model;

import java.util.ArrayList;

import Model.Enumeracije.VrstaLicneGreske;
import Model.Evidentiranje.Izmena;
import Model.Evidentiranje.StatistikaKluba;
import Model.StanjeUtakmice.Odigravanje;
import Model.StanjeUtakmice.Stanje;

public class Utakmica {
	private int id;
	private Stanje trenutnoStanje;
	private int vreme;
	public Sala sala;
	//public StatistikaKluba statistikaDomacegKluba;
	//public StatistikaKluba statistikaGostujucegKluba;
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
		aktivni = new ArrayList<Igrac>();
	}
	
	public Utakmica(int id,Klub domacin,Klub gost,Sala sala){
		this.id = id;
		this.domacin = domacin;
		this.gost = gost;
		this.sala = sala;
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

	public void promeniStanje(Stanje stanje) {
		trenutnoStanje = stanje;
		stanje.entry();
	}

	private void otkucavanjeVremena() {
	}

	public void postaviStartere() {
	}

	public void zaustaviVreme() {

	}

	public void pokreniVreme() {

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
	
	public void azuriranje(Osoba osoba,int tip,int vrednost){
		if(osoba instanceof Igrac){
			switch (tip) {
			case 0:
				
				break;
			case 1:
				break;
			default:
				break;
			}
		}
		else if(osoba instanceof Trener){
			
		}
	}
	
	public void azuriranje(Klub klub,int tip,int vrednost){
		
	}
}

