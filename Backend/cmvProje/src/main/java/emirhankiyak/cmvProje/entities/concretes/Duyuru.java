package emirhankiyak.cmvProje.entities.concretes;

import jakarta.persistence.Entity;

@Entity
public class Duyuru extends Etkinlik{
	private String resim;
	public Duyuru() {}
	public Duyuru(int id, String konu, String icerik, String gecerlilikTarihi, String resim) {
		super(id, konu, icerik, gecerlilikTarihi);
		this.resim = resim;
	}

	public String getResim() {
		return resim;
	}

	public void setResim(String resim) {
		this.resim = resim;
	}
	
}
