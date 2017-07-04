package Model;

public class Odigravanje extends Stanje {
	public Osoba selektovanaOsoba;
	public Igrac ulazni,izlazni;
	
	public Odigravanje(){}
	
	@Override
	protected void entry() {
		utakmica.prikazTerena();
		
	}

	@Override
	protected void tuca() {
		
		
	}

	@Override
	protected void nastavak() {
		
		
	}

	@Override
	protected void prekid() {
		utakmica.promeniStanje(new Prekinuta());
		
	}

	@Override
	protected void zavrsetak() {
		utakmica.promeniStanje(new Zavrsena());
		
	}

	@Override
	protected void dijalog(Osoba osoba) {
		utakmica.prikazDijaloga(osoba);
		
	}

	@Override
	protected void dijalog(Klub klub) {
		utakmica.prikazDijaloga(klub);
		
	}

	@Override
	protected void selektcija(Igrac igrac) {
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
	protected void azuriranje(Osoba osoba, int tip, int vrednost) {
		utakmica.azuriranje(osoba, tip, vrednost);
		
	}

	@Override
	protected void azuriranje(Klub klub, int tip, int vrednost) {
		utakmica.azuriranje(klub, tip, vrednost);
		
	}
	
}
