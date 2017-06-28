package Model;

public class Pokusaj {
	private boolean pogodjen;
	private int brojPoena;
	private int zona;
	private int cetvrtina;

	public Pokusaj() {
	}

	public Pokusaj(boolean pogodjen, int brojPoena, int zona, int cetvrtina) {
		this.pogodjen = pogodjen;
		this.brojPoena = brojPoena;
		this.zona = zona;
		this.cetvrtina = cetvrtina;
	}

	public boolean isPogodjen() {
		return pogodjen;
	}

	public void setPogodjen(boolean pogodjen) {
		this.pogodjen = pogodjen;
	}

	public int getBrojPoena() {
		return brojPoena;
	}

	public void setBrojPoena(int brojPoena) {
		this.brojPoena = brojPoena;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public int getCetvrtina() {
		return cetvrtina;
	}

	public void setCetvrtina(int cetvrtina) {
		this.cetvrtina = cetvrtina;
	}

}
