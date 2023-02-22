package emirhankiyak.cmvProje.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emirhankiyak.cmvProje.business.abstracts.DuyuruService;
import emirhankiyak.cmvProje.core.utilities.results.DataResult;
import emirhankiyak.cmvProje.core.utilities.results.Result;
import emirhankiyak.cmvProje.entities.concretes.Duyuru;

@RestController()
@RequestMapping("/duyurular")
@CrossOrigin
public class DuyuruController {
	private DuyuruService duyuruService;

	@Autowired
	public DuyuruController(DuyuruService duyuruService) {
		super();
		this.duyuruService = duyuruService;
	}
	
	@GetMapping("/tumunuGetir")
	public DataResult<List<Duyuru>> getAll(){
		return this.duyuruService.getAll();
	}
	
	@PostMapping("/ekle")
	public Result add(@RequestBody Duyuru duyuru) {
		return this.duyuruService.add(duyuru);
	}
	
	@DeleteMapping("/sil/{id}")
	public Result delete(@PathVariable int id) {
		return this.duyuruService.delete(id);
	}
	
}
