package emirhankiyak.cmvProje.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import emirhankiyak.cmvProje.entities.concretes.Haber;

public interface HaberDao extends JpaRepository<Haber, Integer>{
	Haber getById(int id);
	List<Haber> getByKonuContains(String konu);
	List<Haber> getByKonuStartsWith(String konu);

}
