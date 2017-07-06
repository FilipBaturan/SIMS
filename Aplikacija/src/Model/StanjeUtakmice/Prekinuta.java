package Model.StanjeUtakmice;

import Model.Igrac;
import Model.Klub;
import Model.Osoba;
import Model.Utakmica;
import Model.Evidentiranje.StatistikaKluba;
import Model.Evidentiranje.Enumeracije.VrstaLicneGreske;

public class Prekinuta extends Stanje {

	public Prekinuta() {}
	
	public Prekinuta(Utakmica utakmica){
		this.utakmica = utakmica;
	}
	
	@Override
	public void entry() {
		utakmica.setPokrenut(false);
		
	}

	@Override
	public void tuca() {
		for(StatistikaKluba it:utakmica.domacin.statistikaKluba){
			if(it.utakmica == utakmica){
				it.licneGreske.add(VrstaLicneGreske.tuca);
				break;
			}
		}
		for(StatistikaKluba it:utakmica.gost.statistikaKluba){
			if(it.utakmica == utakmica){
				it.licneGreske.add(VrstaLicneGreske.tuca);
				break;
			}
		}
		//utakmica.tuca();
		utakmica.promeniStanje(new Zavrsena(utakmica));
		
	}

	@Override
	public void nastavak() {
		utakmica.setPokrenut(true);
		utakmica.promeniStanje(new Odigravanje(utakmica));
		
	}

	@Override
	public void prekid() {
		
		
	}

	@Override
	public void zavrsetak() {
		
		
	}

	@Override
	public void dijalog(Osoba osoba) {
		
		
	}

	@Override
	public void dijalog(Klub klub) {
		
		
	}

	@Override
	public void selektcija(Igrac igrac) {
		
		
	}

	@Override
	public void azuriranje( int tip, int vrednost,int zona) {
		
		
	}

	@Override
	public void azuriranje( int tip, int vrednost) {
		
		
	}

	@Override
	public void do_() {
		
		
	}

}
