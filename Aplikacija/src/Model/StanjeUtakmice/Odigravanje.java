package Model.StanjeUtakmice;

import Model.Igrac;
import Model.Klub;
import Model.Osoba;

public class Odigravanje extends Stanje {
	public Osoba selektovanaOsoba;
	public Igrac ulazni,izlazni;
	
	public Odigravanje(){}
	
	@Override
	public void entry() {
		utakmica.prikazTerena();
		
	}

	@Override
	public void tuca() {
		
		
	}

	@Override
	public void nastavak() {
		
		
	}

	@Override
	public void prekid() {
		utakmica.promeniStanje(new Prekinuta());
		
	}

	@Override
	public void zavrsetak() {
		
		utakmica.promeniStanje(new Zavrsena());
		
	}

	@Override
	public void dijalog(Osoba osoba) {
		utakmica.prikazDijaloga(osoba);
		
	}

	@Override
	public void dijalog(Klub klub) {
		utakmica.prikazDijaloga(klub);
		
	}

	@Override
	public void selektcija(Igrac igrac) {
		if(izlazni == null){
			izlazni = igrac;
		}
		else{
			ulazni = igrac;
			utakmica.izmena(ulazni, izlazni);
			ulazni = null;izlazni = null;
		}
		
		
	}

	@Override
	public void azuriranje(Osoba osoba, int tip, int vrednost,int zona) {
		utakmica.azuriranje(osoba, tip, vrednost,zona);
		
	}

	@Override
	public void azuriranje(Klub klub, int tip, int vrednost) {
		utakmica.azuriranje(klub, tip, vrednost);
		
	}
	
}
