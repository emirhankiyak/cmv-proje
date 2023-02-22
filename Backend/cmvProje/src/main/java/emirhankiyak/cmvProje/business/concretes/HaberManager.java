package emirhankiyak.cmvProje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import emirhankiyak.cmvProje.business.abstracts.HaberService;
import emirhankiyak.cmvProje.core.utilities.results.DataResult;
import emirhankiyak.cmvProje.core.utilities.results.Result;
import emirhankiyak.cmvProje.core.utilities.results.SuccessResult;
import emirhankiyak.cmvProje.core.utilities.results.SuccessDataResult;
import emirhankiyak.cmvProje.dataAccess.abstracts.HaberDao;
import emirhankiyak.cmvProje.entities.concretes.Haber;

@Service
public class HaberManager implements HaberService{
	private HaberDao haberdao;
	
	@Autowired
	public HaberManager(HaberDao haberdao) {
		super();
		this.haberdao = haberdao;
	}

	@Override
	public DataResult<List<Haber>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Haber>>(this.haberdao.findAll(), "Haber Listelendi");
	}
	
	@Override
	public DataResult<List<Haber>> getAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Haber>>(this.haberdao.findAll(pageable).getContent(),"Haber listelendi");
	}

	@Override
	public Result add(Haber haber) {
		// TODO Auto-generated method stub
		this.haberdao.save(haber);
		return new SuccessResult("Haber eklendi");
		
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		this.haberdao.deleteById(id);
		return new SuccessResult("Haber silindi");
	}

	@Override
	public Result update(Haber haber) {
		// TODO Auto-generated method stub
		Haber newHaber = this.haberdao.findById(haber.getId()).orElse(null);
		newHaber.setKonu(haber.getKonu());
		newHaber.setIcerik(haber.getIcerik());
		newHaber.setGecerlilikTarihi(haber.getGecerlilikTarihi());
		newHaber.setHaberLinki(haber.getHaberLinki());
		this.haberdao.save(newHaber);
		return null;
	}

	@Override
	public DataResult<Haber> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Haber>(this.haberdao.getById(id),"Haber listelendi");
	}

	@Override
	public DataResult<List<Haber>> getByKonuStartsWith(String konu) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Haber>>(this.haberdao.getByKonuStartsWith(konu),"Haber listelendi");
	}

	@Override
	public DataResult<List<Haber>> getByKonuContains(String konu) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Haber>>(this.haberdao.getByKonuContains(konu),"Haber listelendi");
	}


	

}
