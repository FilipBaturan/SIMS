package Model;

public class IzgubljenaLoptaIgraca {
	private VrstaIzgubljeneLopteIgraca tipIzgubljeneLopteIgraca;

	public IzgubljenaLoptaIgraca() {
	}

	public IzgubljenaLoptaIgraca(VrstaIzgubljeneLopteIgraca tipIzgubljeneLopteIgraca) {
		this.tipIzgubljeneLopteIgraca = tipIzgubljeneLopteIgraca;
	}

	public VrstaIzgubljeneLopteIgraca getTipIzgubljeneLopteIgraca() {
		return tipIzgubljeneLopteIgraca;
	}

	public void setTipIzgubljeneLopteIgraca(VrstaIzgubljeneLopteIgraca tipIzgubljeneLopteIgraca) {
		this.tipIzgubljeneLopteIgraca = tipIzgubljeneLopteIgraca;
	}

}