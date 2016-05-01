package recountAccess;

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

import recountAccess.model.Vote;
import recountAccess.persistence.UserDao;
import recountAccess.persistence.VoteDao;
import recountAccess.persistence.impl.SimplePersistenceFactory;
import recountAccess.repositorios.VoteRepository;

@Controller
public class VoteController {
	
	@Autowired
	private VoteRepository repository;
	
	private List<Object[]> parties;
	private List<Object[]> votosPartido;
	private Vote partido= new Vote();
	private Vote colegio=new Vote();
	
	VoteDao repo= new SimplePersistenceFactory().createVoteDao();
	
	@RequestMapping(value="/stadistic", method=RequestMethod.GET)
	    public String stadistic(Model model) {
		
	//List<Object[]>prueba=repository.findVotespartido("PP");
//	List<Object[]>prueba2=repo.findVotespartido("");///
		
		List <Object[]> nueva=new ArrayList<>();
		List <Object[]> stations=repo.findAllPollingStations();
		
		if(stations.size()!=0){
		nueva.add(repo.findAllPollingStations().get(0));
		}
				
	        model.addAttribute("pollingStations", nueva);
			model.addAttribute("votesPartyPStation", repo.findVotersByPollingStationAndParty());
			
			model.addAttribute("votosPartido",repo.findVotesByPollingStationAndParty(12));
			
			model.addAttribute("colegios",repo.findAllPollingStations());
			@SuppressWarnings("unused")
			List <String> nueva1=repo.findPartidos();
			model.addAttribute("partidos",repo.findPartidos());
			
			model.addAttribute("colegio", new Vote());
			model.addAttribute("partido", new Vote());
	        return "stadistic";
	    }
	
	@RequestMapping(value="/stadistic_json", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> stadisticData() {
		
		List<Object[]> parties = repo.countAllVotes();
		
	
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
		
		List<Object[]> parties = repo.findAllPollingStations();
		
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
		nueva.add(repo.findAllPollingStations().get(0));
				
	        model.addAttribute("pollingStations", nueva);
			model.addAttribute("votesPartyPStation", repo.findVotersByPollingStationAndParty());
			
			model.addAttribute("votosPartido",repo.findVotesByPollingStationAndParty(12));
			
			model.addAttribute("colegios",repo.findAllPollingStations());
			
			 parties = repo.findVotesByPollingStationAndParty(greeting.getPollingStationCode());
			//consulta para rellenar el grafico
			model.addAttribute("colegio", greeting);
			colegio=greeting;
			model.addAttribute("partidos",repo.findPartidos());
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
		nueva.add(repo.findAllPollingStations().get(0));
				
	        model.addAttribute("pollingStations", nueva);
			model.addAttribute("votesPartyPStation", repo.findVotersByPollingStationAndParty());
			
			model.addAttribute("votosPartido",repo.findVotesByPollingStationAndParty(12));
			
			model.addAttribute("colegios",repo.findAllPollingStations());
			model.addAttribute("partidos",repo.findPartidos());
			
			 votosPartido = repo.findVotespartido(greeting.getParty());
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
