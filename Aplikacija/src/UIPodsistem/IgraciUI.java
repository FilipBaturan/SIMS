package UIPodsistem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Aplikacija;
import Model.Igrac;

public class IgraciUI {
	private static class Igraci{
		private ArrayList<Igrac> igraci;
		
		public Igraci(){
		}

		@SuppressWarnings("unused")
		public ArrayList<Igrac> getIgraci() {
			return igraci;
		}

		@JsonProperty("igraci")
		public void setIgraci(ArrayList<Igrac> igraci) {
			this.igraci = igraci;
		}
		
		
	}
	private Igraci igr;

	
	public Igraci getIgr() {
		return igr;
	}
	
	@JsonProperty("igr")
	public void setIgr(Igraci igr) {
		this.igr = igr;
	}

	public IgraciUI(){
		this.igr = new Igraci();
		this.igr.igraci = Aplikacija.listaIgraca;
	}

	public void upisiIgraca() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Igraci.json"), this.igr);
	}
	
	public void iscitajIgrace() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		this.igr = mapper.readValue(new File("Igraci.json"), Igraci.class);
		Aplikacija.listaIgraca = this.igr.igraci;
	}
}
