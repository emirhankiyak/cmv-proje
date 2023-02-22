package emirhankiyak.cmvProje.business.concretes;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import emirhankiyak.cmvProje.business.abstracts.DuyuruService;
import emirhankiyak.cmvProje.core.utilities.results.DataResult;
import emirhankiyak.cmvProje.core.utilities.results.Result;
import emirhankiyak.cmvProje.core.utilities.results.SuccessDataResult;
import emirhankiyak.cmvProje.core.utilities.results.SuccessResult;
import emirhankiyak.cmvProje.dataAccess.abstracts.DuyuruDao;
import emirhankiyak.cmvProje.entities.concretes.Duyuru;

@Service
public class DuyuruManager implements DuyuruService{
	private DuyuruDao duyuruDao;
	
	public DuyuruManager(DuyuruDao duyuruDao) {
		super();
		this.duyuruDao = duyuruDao;
	}

	@Override
	public DataResult<List<Duyuru>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Duyuru>>(this.duyuruDao.findAll(), "Data Listelendi");
	}
	
	@Override
	public DataResult<List<Duyuru>> getAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Duyuru>>(this.duyuruDao.findAll(pageable).getContent(),"Duyurular getirildi");
	}


	@Override
	public Result add(Duyuru duyuru) {
		// TODO Auto-generated method stub
		this.duyuruDao.save(duyuru);
		return new SuccessResult("Duyuru eklendi");
	}
	
	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		this.duyuruDao.deleteById(id);
		return new SuccessResult("Veri silindi");
	}
	
	@Override
	public Result update(Duyuru duyuru) {
		// TODO Auto-generated method stub
		Duyuru newDuyuru = this.duyuruDao.findById(duyuru.getId()).orElse(null);
		newDuyuru.setKonu(duyuru.getKonu());
		newDuyuru.setIcerik(duyuru.getIcerik());
		newDuyuru.setGecerlilikTarihi(duyuru.getGecerlilikTarihi());
		newDuyuru.setResim(duyuru.getResim());
		this.duyuruDao.save(newDuyuru);
		return new SuccessResult("Duyuru eklendi");
	}


	@Override
	public DataResult<Duyuru> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Duyuru>(this.duyuruDao.getById(id), "Duyuru Listelendi");
	}

	@Override
	public DataResult<List<Duyuru>> getByKonuStartsWith(String konu) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Duyuru>>(this.duyuruDao.getByKonuStartsWith(konu), "Duyuru Listelendi");
	}

	@Override
	public DataResult<List<Duyuru>> getByKonuContains(String konu) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Duyuru>>(this.duyuruDao.getByKonuContains(konu), "Duyuru Listelendi");
	}

	
	
}
