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
import Model.Mesto;

public class MestaUI {
	private static class Mesta {
		private ArrayList<Mesto> mesta;

		public Mesta() {

		}

		@SuppressWarnings("unused")
		public ArrayList<Mesto> getMesta() {
			return mesta;
		}

		@JsonProperty("mesta")
		public void setMesta(ArrayList<Mesto> mesta) {
			this.mesta = mesta;
		}

	}

	private Mesta mes;

	public MestaUI() {
		this.mes = new Mesta();
		this.mes.mesta = Aplikacija.listaMesta;
	}

	public Mesta getMes() {
		return mes;
	}

	@JsonProperty("mes")
	public void setMes(Mesta mes) {
		this.mes = mes;
	}

	public void upisiMesta() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Mesta.json"), this.mes);
	}
	
	public void iscitajMesta() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		this.mes = mapper.readValue(new File("Mesta.json"), this.mes.getClass());
		Aplikacija.listaMesta = this.mes.mesta;
	}

}
