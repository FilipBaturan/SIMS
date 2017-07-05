package Model.StanjeUtakmice;

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
		utakmica.zaustaviVreme();
		
	}

	@Override
	public void tuca() {
		utakmica.tuca();
		utakmica.promeniStanje(new Zavrsena(utakmica));
		
	}

	@Override
	public void nastavak() {
		utakmica.pokreniVreme();
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
	public void azuriranje(Osoba osoba, int tip, int vrednost,int zona) {
		
		
	}

	@Override
	public void azuriranje(Klub klub, int tip, int vrednost) {
		
		
	}

	@Override
	public void do_() {
		
		
	}

}
