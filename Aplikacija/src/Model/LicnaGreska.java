package Model;

public class LicnaGreska {
	private VrstaLicneGreske tipLicneGreske;

	public LicnaGreska() { }

	public LicnaGreska(VrstaLicneGreske tipLicneGreske) {
		this.tipLicneGreske = tipLicneGreske;
	}

	public VrstaLicneGreske getTipLicneGreske() {
		return tipLicneGreske;
	}

	public void setTipLicneGreske(VrstaLicneGreske tipLicneGreske) {
		this.tipLicneGreske = tipLicneGreske;
	}

}
