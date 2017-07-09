package Model.StanjeUtakmice;

import java.util.Timer;
import java.util.TimerTask;

import GUI.PodaciIgracaDijalog;
import Model.Igrac;
import Model.Klub;
import Model.Osoba;
import Model.Trener;
import Model.Utakmica;
import Model.Evidentiranje.StatistikaKluba;
import Model.Evidentiranje.UcinakIgraca;
import Model.Evidentiranje.UcinakTrenera;
import GUI.PrikazUtakmice;

public class Odigravanje extends Stanje {
	public Osoba selektovanaOsoba;
	public Klub selektovanKlub;
	public Igrac ulazni,izlazni;

	
	public Odigravanje(){
		
	}
	public Odigravanje(Utakmica utakmica){
		this.utakmica = utakmica;
	}
	
	@Override
	public void entry() {
		//System.out.println("Prikaz terena");
		//prikazkuje teren
		
	}

	@Override
	public void do_() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(utakmica.isPokrenut() && utakmica.getVreme() <180){
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
		selektovanaOsoba = osoba;
		Igrac i = ( (Igrac) selektovanaOsoba);
		for (UcinakIgraca ui : i.ucinak) {
			if(ui.utakmica == utakmica)
			{
				
				PodaciIgracaDijalog dijalog =new PodaciIgracaDijalog(ui);
				if(utakmica.domacin.igraci.contains(i))
				dijalog.setKlub(PrikazUtakmice.domaciTim);
				else dijalog.setKlub(PrikazUtakmice.gostojuciTim);
				break;
			}
				
		}
		
		
	}

	@Override
	public void dijalog(Klub klub) {
		selektovanKlub = klub;
		System.out.println(klub.getId() + " " + klub.getNaziv());
		
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
	public void azuriranje(int tip, int vrednost,int zona) {
		if(selektovanaOsoba instanceof Igrac){
			//pronadji utakmicu koja se trenutno azurira
			for(UcinakIgraca ucinak:((Igrac)selektovanaOsoba).ucinak){
				if(ucinak.utakmica == utakmica){
					ucinak.azuriranje(tip, vrednost, zona);
					break;
				}
			}
		}
		else if(selektovanaOsoba instanceof Trener){
			for(UcinakTrenera ucinak:((Trener)selektovanaOsoba).ucinak){
				if(ucinak.utakmica == utakmica){
					ucinak.azuriranje(tip);
					break;
				}
			}
		}
		
	}

	@Override
	public void azuriranje(int tip, int vrednost) {
		for(StatistikaKluba statistika:selektovanKlub.statistikaKluba){
			if(statistika.utakmica == utakmica){
				statistika.azuriranje(tip, vrednost);
				break;
			}
		}
		
	}

	
	
}
