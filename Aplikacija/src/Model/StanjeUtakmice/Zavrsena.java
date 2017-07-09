package Model.StanjeUtakmice;

import GUI.IzvestajStatistike;
import Model.Igrac;
import Model.Klub;
import Model.Osoba;
import Model.Utakmica;

public class Zavrsena extends Stanje {
	

	public Zavrsena() {}
	
	public Zavrsena(Utakmica utakmica){
		this.utakmica = utakmica;
	}
	
	@Override
	public void entry() {
		new IzvestajStatistike();
	}

	@Override
	public void tuca() {
		
		
	}

	@Override
	public void nastavak() {
		
		
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
