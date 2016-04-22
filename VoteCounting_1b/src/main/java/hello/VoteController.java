package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.UserInfo;
import hello.model.Vote;
import hello.repositorios.VoteRepository;

@Controller
public class VoteController {
	
	@Autowired
	private VoteRepository repository;
	
	private List<Object[]> parties;
	private List<Object[]> votosPartido;
	private Vote partido= new Vote();
	private Vote colegio=new Vote();
	
	@RequestMapping(value="/stadistic", method=RequestMethod.GET)
	    public String stadistic(Model model) {
		
		List <Object[]> nueva=new ArrayList<>();
		nueva.add(repository.findAllPollingStations().get(0));
				
	        model.addAttribute("pollingStations", nueva);
			model.addAttribute("votesPartyPStation", repository.findVotersByPollingStationAndParty());
			
			model.addAttribute("votosPartido",repository.findVotesByPollingStationAndParty(2500));
			
			model.addAttribute("colegios",repository.findAllPollingStations());
			List <Object[]> nueva1=repository.findPartidos();
			model.addAttribute("partidos",repository.findPartidos());
			
			model.addAttribute("colegio", new Vote());
			model.addAttribute("partido", new Vote());
	        return "stadistic";
	    }
	
	@RequestMapping(value="/stadistic_json", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> stadisticData() {
		
		List<Object[]> parties = repository.countAllVotes();
		
	
		Map<String, Object> data = new HashMap<>();
		
		List<Map<String, String>> cols = new ArrayList<>();
		
		Map<String, String> col = new HashMap<>();
		col.put("name", "Partido");
		col.put("type", "string");
		cols.add(col);

		col = new HashMap<>();
		col.put("name", "Votos");
		col.put("type", "number");
		cols.add(col);
		
		data.put("cols", cols);
		
		List<Map<String, List<Map<String, Object>>>> rows = new ArrayList<>();

		for (Object[] party: parties) {
			Map<String, Object> partido = new HashMap<>();
			partido.put("v", party[0]);
	
			Map<String, Object> votos = new HashMap<>();
			votos.put("v", party[1]);
	
			List<Map<String, Object>> celdas = new ArrayList<>();
			celdas.add(partido);
			celdas.add(votos);
			
			Map<String, List<Map<String, Object>>> row = new HashMap<>();
			row.put("c", celdas);
			
			rows.add(row);
		}
		
		data.put("rows", rows);
		
		return data;
	}
	
	

	@RequestMapping(value="/stadistic_pollingstation_json/{pollingStationCode}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> stadisticDataPollingStation(@PathVariable("pollingStationCode") String pollingStationCode) {
		
		List<Object[]> parties = repository.findAllPollingStations();
		
		Map<String, Object> data = new HashMap<>();
		
		List<Map<String, String>> cols = new ArrayList<>();
		
		Map<String, String> col = new HashMap<>();
		col.put("name", "Partido");
		col.put("type", "string");
		cols.add(col);

		col = new HashMap<>();
		col.put("name", "Votos");
		col.put("type", "number");
		cols.add(col);
		
		data.put("cols", cols);
		
		List<Map<String, List<Map<String, Object>>>> rows = new ArrayList<>();

		for (Object[] party: parties) {
			Map<String, Object> partido = new HashMap<>();
			partido.put("v", party[0]);
	
			Map<String, Object> votos = new HashMap<>();
			votos.put("v", party[1]);
	
			List<Map<String, Object>> celdas = new ArrayList<>();
			celdas.add(partido);
			celdas.add(votos);
			
			Map<String, List<Map<String, Object>>> row = new HashMap<>();
			row.put("c", celdas);
			
			rows.add(row);
		}
		
		data.put("rows", rows);
		
		return data;
	}
	
	@RequestMapping(value="/stadistic", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Vote greeting, Model model, HttpSession sesion) {
		List <Object[]> nueva=new ArrayList<>();
		nueva.add(repository.findAllPollingStations().get(0));
				
	        model.addAttribute("pollingStations", nueva);
			model.addAttribute("votesPartyPStation", repository.findVotersByPollingStationAndParty());
			
			model.addAttribute("votosPartido",repository.findVotesByPollingStationAndParty(2500));
			
			model.addAttribute("colegios",repository.findAllPollingStations());
			
			 parties = repository.findVotesByPollingStationAndParty(greeting.getPollingStationCode());
			//consulta para rellenar el grafico
			model.addAttribute("colegio", greeting);
			colegio=greeting;
			model.addAttribute("partidos",repository.findPartidos());
			model.addAttribute("partido",partido);
			
			return "stadistic";
	}

	@RequestMapping(value="/stadistic_col", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> stadisticCol(Model model) {

		 

		Map<String, Object> data = new HashMap<>();
		
		
			
			List<Map<String, String>> cols = new ArrayList<>();
			
			Map<String, String> col = new HashMap<>();
			col.put("name", "Partido");
			col.put("type", "string");
			cols.add(col);

			col = new HashMap<>();
			col.put("name", "Votos");
			col.put("type", "number");
			cols.add(col);
			
			data.put("cols", cols);
			
			if(parties!=null){
			List<Map<String, List<Map<String, Object>>>> rows = new ArrayList<>();

			for (Object[] party: parties) {
				Map<String, Object> partido = new HashMap<>();
				partido.put("v", party[0]);
		
				Map<String, Object> votos = new HashMap<>();
				votos.put("v", party[1]);
		
				List<Map<String, Object>> celdas = new ArrayList<>();
				celdas.add(partido);
				celdas.add(votos);
				
				Map<String, List<Map<String, Object>>> row = new HashMap<>();
				row.put("c", celdas);
				
				rows.add(row);
			}
			
			data.put("rows", rows);
		}
	
	return data;
	}
	
	@RequestMapping(value="/stadistic_party", method=RequestMethod.POST)
    public String greetingParty(@ModelAttribute Vote greeting, Model model, HttpSession sesion) {
		List <Object[]> nueva=new ArrayList<>();
		nueva.add(repository.findAllPollingStations().get(0));
				
	        model.addAttribute("pollingStations", nueva);
			model.addAttribute("votesPartyPStation", repository.findVotersByPollingStationAndParty());
			
			model.addAttribute("votosPartido",repository.findVotesByPollingStationAndParty(2500));
			
			model.addAttribute("colegios",repository.findAllPollingStations());
			model.addAttribute("partidos",repository.findPartidos());
			
			 votosPartido = repository.findVotespartido(greeting.getParty());
			//consulta para rellenar el grafico
			model.addAttribute("partido", greeting);
			model.addAttribute("colegio",colegio);
			return "stadistic";
	}
	
	@RequestMapping(value="/stadistic_tab", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> stadisticTAb(Model model) {
		Map<String, Object> data = new HashMap<>();
		
		List<Map<String, String>> cols = new ArrayList<>();
		
		Map<String, String> col = new HashMap<>();
		col.put("name", "Colegio");
		col.put("type", "number");
		cols.add(col);

		col = new HashMap<>();
		col.put("name", "Votos");
		col.put("type", "number");
		cols.add(col);
		
		data.put("cols", cols);
		
		if(votosPartido!=null){
			List<Map<String, List<Map<String, Object>>>> rows = new ArrayList<>();

			for (Object[] party: votosPartido) {
				Map<String, Object> partido = new HashMap<>();
				partido.put("v", party[0]);
		
				Map<String, Object> votos = new HashMap<>();
				votos.put("v", party[1]);
		
				List<Map<String, Object>> celdas = new ArrayList<>();
				celdas.add(partido);
				celdas.add(votos);
				
				Map<String, List<Map<String, Object>>> row = new HashMap<>();
				row.put("c", celdas);
				
				rows.add(row);
			}
			data.put("rows", rows);
		}
		
		return data;
	}

}
