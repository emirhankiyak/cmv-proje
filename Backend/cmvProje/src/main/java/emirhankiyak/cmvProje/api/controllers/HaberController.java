package emirhankiyak.cmvProje.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emirhankiyak.cmvProje.business.abstracts.HaberService;
import emirhankiyak.cmvProje.core.utilities.results.DataResult;
import emirhankiyak.cmvProje.core.utilities.results.Result;
import emirhankiyak.cmvProje.entities.concretes.Haber;

@RestController
@RequestMapping("/haberler")
@CrossOrigin
public class HaberController {
	private HaberService haberService;

	@Autowired
	public HaberController(HaberService haberService) {
		super();
		this.haberService = haberService;
	}
	
	@GetMapping("/tumunuGetir")
	public DataResult<List<Haber>> getAll(){
		return this.haberService.getAll();
	}
	
	@PostMapping("/ekle")
	public Result add(@RequestBody Haber haber) {
		return this.haberService.add(haber);
	}
	
	
}
