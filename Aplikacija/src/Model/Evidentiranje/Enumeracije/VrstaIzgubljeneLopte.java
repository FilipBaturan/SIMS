package Model.Evidentiranje.Enumeracije;

public enum VrstaIzgubljeneLopte {
	koraci(0),
	dupla(1),
	loseDodavanje(2),
	loseHvatanje(3),
	triSekunde(4),
	faulUNapaduSaLoptom(5),
	faulUNapaduBezLopte(6),
	tehnickaGreska(7),
	tucaNaTerenu(8),
	loseVodjenjeLopte(9),
	izgubljenaLoptaZbogTrenera(10),
	prekoPola(11),
	istekaoNapad(12),
	izAuta(13);
	
	VrstaIzgubljeneLopte() {
	}
	VrstaIzgubljeneLopte(int vrednost){
		
	}
}