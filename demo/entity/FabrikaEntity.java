package demirel.kag.t.demo.entity;

import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "fabrika")
public class FabrikaEntity {
	@Id
	@SequenceGenerator(name="key", sequenceName="FABRIKA_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy  = GenerationType.SEQUENCE, generator="key")
	@Column(name  ="id")
	private long id;
	
	@Column(name="fabrika_adi", length =255)
	private String fabrika_adi;
	
	@Column(name="ulke", length =255)
	private String ulke;
	
	@JsonIgnore
	@OneToMany(mappedBy = "fabrika", cascade = CascadeType.ALL)
    private List<UrunEntity> urun;
	

	public FabrikaEntity() {
        // Parametresiz yapılandırıcı metot
    }
	
	public FabrikaEntity(String fabrika_adi, String ulke) {
		this.fabrika_adi = fabrika_adi;
		this.ulke = ulke;
	}



	public long getFabrikaId() {
		return id;
	}

	public void setFabrikaId(long id) {
		this.id = id;
	}

	public String getFabrikaAdi() {
		return fabrika_adi;
	}

	public void setFabrikaAdi(String name) {
		this.fabrika_adi = name;
	}

	public String getUlke() {
		return ulke;
	}

	public void setUlke(String ulke) {
		this.ulke = ulke;
	}

	public List<UrunEntity> getUrun() {
	    return urun;
	}

	

}
