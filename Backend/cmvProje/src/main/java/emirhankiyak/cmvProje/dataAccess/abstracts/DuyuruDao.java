package emirhankiyak.cmvProje.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import emirhankiyak.cmvProje.entities.concretes.Duyuru;

public interface DuyuruDao extends JpaRepository<Duyuru, Integer>{
	Duyuru getById(int id);
	List<Duyuru> getByKonuContains(String konu);
	List<Duyuru> getByKonuStartsWith(String konu);
}
