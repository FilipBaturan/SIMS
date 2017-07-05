package Model.StanjeUtakmice;

import java.util.Timer;
import java.util.TimerTask;

import Model.Igrac;
import Model.Klub;
import Model.Osoba;
import Model.Utakmica;
import Model.Evidentiranje.UcinakIgraca;

public class Odigravanje extends Stanje {
	public Osoba selektovanaOsoba;
	public Igrac ulazni,izlazni;

	
	public Odigravanje(){
		
	}
	public Odigravanje(Utakmica utakmica){
		this.utakmica = utakmica;
	}
	
	@Override
	public void entry() {
		utakmica.prikazTerena();
		
	}

	@Override
	public void do_() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(utakmica.isPokrenut() && utakmica.getVreme() <40){
					utakmica.setVreme(utakmica.getVreme()+1);;
					//uvecaj vreme svim aktinvim igracima
					for(Igrac igrac:utakmica.aktivni){
						for(UcinakIgraca ucinak: igrac.ucinak){
							if(ucinak.utakmica == utakmica){
								ucinak.setVreme(ucinak.getVreme()+1);
								break;
							}
						}
					}
				}
				else if( utakmica.isPokrenut() && utakmica.getVreme() >=40){
					System.out.println("Usao u if");
					timer.cancel();
					timer.purge();
					zavrsetak();
					return;
				}
				else {
					timer.cancel();
					timer.purge();
					return;
				}
				System.out.println(utakmica.getVreme());
				
			}
		}, 0, 1000);
		
	}
	
	
	@Override
	public void tuca() {
		
		
	}

	@Override
	public void nastavak() {
		
		
	}

	@Override
	public void prekid() {
		utakmica.promeniStanje(new Prekinuta(utakmica));
		
	}

	@Override
	public void zavrsetak() {
		
		utakmica.promeniStanje(new Zavrsena(utakmica));
		
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
