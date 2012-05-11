package ie.cit.cloudapp.web;

import ie.cit.cloudapp.Player;
import ie.cit.cloudapp.JdbcPlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("players")
@Controller
public class PlayerController {
	
	@Autowired
	private JdbcPlayerRepository team;
	
	@RequestMapping(method = RequestMethod.GET)
		public void listPlayers(Model model) {
	 model.addAttribute("players", team.getAll());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	 public void createPlayer(Model model, @RequestParam String name, @RequestParam String gk, @RequestParam String rb, @RequestParam String cb1, @RequestParam String cb2, @RequestParam String lb, @RequestParam String rw, @RequestParam String cm1, @RequestParam String cm2, @RequestParam String lw, @RequestParam String st1, @RequestParam String st2) {
	 Player player = new Player();
	 player.setName(name);
	 player.setGk(gk);
	 player.setRb(rb);
	 player.setCb1(cb1);
	 player.setCb2(cb2);
	 player.setLb(lb);
	 player.setRw(rw);
	 player.setCm1(cm1);
	 player.setCm2(cm2);
	 player.setLw(lw);
	 player.setSt1(st1);
	 player.setSt2(st2);
	 team.save(player);
	 model.addAttribute("players", team.getAll());
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deletePlayer(Model model, @RequestParam int playerId){
		team.delete(playerId);
		model.addAttribute("players", team.getAll());
	}
	
}
