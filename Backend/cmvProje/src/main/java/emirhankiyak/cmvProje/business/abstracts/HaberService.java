package emirhankiyak.cmvProje.business.abstracts;

import java.util.List;

import emirhankiyak.cmvProje.core.utilities.results.DataResult;
import emirhankiyak.cmvProje.core.utilities.results.Result;
import emirhankiyak.cmvProje.entities.concretes.Haber;

public interface HaberService {
	DataResult<List<Haber>> getAll();  // tüm datayı listele
	DataResult<List<Haber>> getAll(int pageNo, int pageSize);  // tüm datayı sayfalayarak getir
	Result add(Haber haber);  // Haber ekle
	Result delete(int id);
	Result update(Haber haber);
	DataResult<Haber> getById(int id);  // id'ye göre haber getir
	DataResult<List<Haber>> getByKonuStartsWith(String konu);  // Konusu "Şu" harflerle başlayan haberleri getir
	DataResult<List<Haber>> getByKonuContains(String konu);  // Konusu "Şu" harfleri içeren haberleri getir
}
