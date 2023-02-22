package emirhankiyak.cmvProje.entities.concretes;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "etkinlikler")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Etkinlik{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String konu;
	private String icerik;
	private String gecerlilikTarihi;

}
