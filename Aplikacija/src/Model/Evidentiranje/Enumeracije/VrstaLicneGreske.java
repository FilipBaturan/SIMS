package Model.Evidentiranje.Enumeracije;

public enum VrstaLicneGreske {
	licnaZa1Poen(0),
	licnaZa2Poena(1),
	licnaZa3Poena(2),
	nesportskaSa1Bacanjem(3),
	nesportskaSa2Bacanja(4),
	nesportskaSa3Bacanja(5),
	tuca(6),
	diskvalifikacija(7),
	tehnickaGreska(8);
	
	VrstaLicneGreske(){}
	VrstaLicneGreske(int vrednost){
	}
}
