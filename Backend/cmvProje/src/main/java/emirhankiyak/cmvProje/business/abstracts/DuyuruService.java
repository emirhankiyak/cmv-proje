package emirhankiyak.cmvProje.business.abstracts;

import java.util.List;

import emirhankiyak.cmvProje.core.utilities.results.DataResult;
import emirhankiyak.cmvProje.core.utilities.results.Result;
import emirhankiyak.cmvProje.entities.concretes.Duyuru;

public interface DuyuruService {
	DataResult<List<Duyuru>> getAll(); // tüm datayı listele
	DataResult<List<Duyuru>> getAll(int pageNo, int pageSize);  // tüm datayı sayfalayarak getir
	Result add(Duyuru duyuru);  // Duyuru ekle
	Result delete(int id);
	Result update(Duyuru duyuru);
	DataResult<Duyuru> getById(int id);  // id'ye göre duyuru getir
	DataResult<List<Duyuru>> getByKonuStartsWith(String konu);  // Konusu "Şu" harflerle başlayan duyuruları getir
	DataResult<List<Duyuru>> getByKonuContains(String konu);  // Konusu "Şu" harfleri içeren duyuruları getir
}
