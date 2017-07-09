package Model.StanjeUtakmice;

import GUI.PrekinutDijalog;
import Model.Igrac;
import Model.Klub;
import Model.Osoba;
import Model.Utakmica;

public class Prekinuta extends Stanje {

	public Prekinuta() {}
	
	public Prekinuta(Utakmica utakmica){
		this.utakmica = utakmica;
	}
	
	@Override
	public void entry() {
		utakmica.setPokrenut(false);
		new PrekinutDijalog(utakmica);
		
	}

	@Override
	public void tuca() {
		utakmica.evidentirajTucu();
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
