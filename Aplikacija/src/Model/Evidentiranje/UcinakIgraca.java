package Model.Evidentiranje;

import java.util.ArrayList;

import Model.Utakmica;
import Model.Evidentiranje.Enumeracije.VrstaIzgubljeneLopte;
import Model.Evidentiranje.Enumeracije.VrstaLicneGreske;

public class UcinakIgraca {
	private int skokoviUNapadu;
	private int skokoviUOdbrani;
	private int asistencije;
	private int osvojeneLopte;
	private int blokade;
	private int poeni;
	private int indeks;
	private int vreme;
	public ArrayList<VrstaLicneGreske> licneGreske;
	public ArrayList<Pokusaj> pokusaji;
	public ArrayList<VrstaIzgubljeneLopte> izgubljeneLopteIgraca;
	public Utakmica utakmica;

	public UcinakIgraca() {
		licneGreske = new ArrayList<VrstaLicneGreske>();
		pokusaji = new ArrayList<Pokusaj>();
		izgubljeneLopteIgraca = new ArrayList<VrstaIzgubljeneLopte>();
	}
	
	public UcinakIgraca(Utakmica utakmica){
		this.utakmica = utakmica;
		licneGreske = new ArrayList<VrstaLicneGreske>();
		pokusaji = new ArrayList<Pokusaj>();
		izgubljeneLopteIgraca = new ArrayList<VrstaIzgubljeneLopte>();
	}

	public int getSkokoviUNapadu() {
		return skokoviUNapadu;
	}

	public void setSkokoviUNapadu(int skokoviUNapadu) {
		this.skokoviUNapadu = skokoviUNapadu;
	}

	public int getSkokoviUOdbrani() {
		return skokoviUOdbrani;
	}

	public void setSkokoviUOdbrani(int skokoviUOdbrani) {
		this.skokoviUOdbrani = skokoviUOdbrani;
	}

	public int getAsistencije() {
		return asistencije;
	}

	public void setAsistencije(int asistencije) {
		this.asistencije = asistencije;
	}

	public int getOsvojeneLopte() {
		return osvojeneLopte;
	}

	public void setOsvojeneLopte(int osvojeneLopte) {
		this.osvojeneLopte = osvojeneLopte;
	}

	public int getBlokade() {
		return blokade;
	}

	public void setBlokade(int blokade) {
		this.blokade = blokade;
	}

	public int getPoeni() {
		return poeni;
	}

	public void setPoeni(int poeni) {
		this.poeni = poeni;
	}

	public int getIndeks() {
		return indeks;
	}

	public void setIndeks(int indeks) {
		this.indeks = indeks;
	}

	public int getVreme() {
		return vreme;
	}

	public void setVreme(int vreme) {
		this.vreme = vreme;
	}
	
	
	
	public void azuriranje(int tip,int vrednost,int zona){
		switch (tip) {
		case 0:
			setSkokoviUNapadu(getSkokoviUNapadu()+1);
			setIndeks(getIndeks());
			break;
		case 1:
			setSkokoviUOdbrani(getSkokoviUOdbrani()+1);
			setIndeks(getIndeks());
			break;
		case 2:
			setAsistencije(getAsistencije()+1);
			setIndeks(getIndeks());
			break;
		case 3:
			setOsvojeneLopte(getOsvojeneLopte()+1);
			setIndeks(getIndeks());
			break;
		case 4:
			setBlokade(getBlokade()+1);
			setIndeks(getIndeks());
			break;
		case 5:
			licneGreske.add(VrstaLicneGreske.values()[vrednost]);
			setIndeks(getIndeks());
			break;
		case 6:
			izgubljeneLopteIgraca.add(VrstaIzgubljeneLopte.values()[vrednost]);
			setIndeks(getIndeks());
			break;
		case 7:
			pokusaji.add(new Pokusaj(true,vrednost,zona,utakmica.izracunaCetvrtinu()));
			break;
		case 8:
			pokusaji.add(new Pokusaj(false,vrednost,zona,utakmica.izracunaCetvrtinu()));
			break;
		default:
			break;
		}
	}
}
