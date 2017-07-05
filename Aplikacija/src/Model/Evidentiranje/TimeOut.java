package Model.Evidentiranje;

import Model.Evidentiranje.Enumeracije.TipTimeOut;

public class TimeOut {
	TipTimeOut tip;
	int vreme;
	int cetvrtina;
	
	public TimeOut(){
		
	}

	public TimeOut(TipTimeOut tip, int vreme, int cetvrtina) {
		super();
		this.tip = tip;
		this.vreme = vreme;
		this.cetvrtina = cetvrtina;
	}

	public TipTimeOut getTip() {
		return tip;
	}

	public void setTip(TipTimeOut tip) {
		this.tip = tip;
	}

	public int getVreme() {
		return vreme;
	}

	public void setVreme(int vreme) {
		this.vreme = vreme;
	}

	public int getCetvrtina() {
		return cetvrtina;
	}

	public void setCetvrtina(int cetvrtina) {
		this.cetvrtina = cetvrtina;
	}
	
	
}
