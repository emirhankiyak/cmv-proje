package emirhankiyak.cmvProje.entities.concretes;

import jakarta.persistence.Entity;

@Entity
public class Haber extends Etkinlik{
	private String haberLinki;
	
	public Haber(int id, String konu, String icerik, String gecerlilikTarihi, String haberLinki) {
		super(id, konu, icerik, gecerlilikTarihi);
		this.haberLinki = haberLinki;
	}
	public Haber() {}

	public String getHaberLinki() {
		return haberLinki;
	}

	public void setHaberLinki(String haberLinki) {
		this.haberLinki = haberLinki;
	}
	
}
