package Model.StanjeUtakmice;

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
		utakmica.prikazStatistike();
		
		
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
	public void azuriranje(Osoba osoba, int tip, int vrednost,int zona) {
		
		
	}

	@Override
	public void azuriranje(Klub klub, int tip, int vrednost) {
		
		
	}

	@Override
	public void do_() {
		// TODO Auto-generated method stub
		
	}

}