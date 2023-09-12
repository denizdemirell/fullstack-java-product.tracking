package demirel.kag.t.demo.entity;


import javax.persistence.*;


@Entity
@Table(name= "urun")
public class UrunEntity {
	@Id
	@SequenceGenerator(name="key", sequenceName="URUN_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy  = GenerationType.SEQUENCE, generator="key")
	@Column(name  ="id")
	private long id;
	
	@Column(name="urun_adi", length =255)
	private String urun_adi;
	
	@Column(name="urun_kodu", length =50)
	private String urunkod;
	
	@Column(name="fiyat")
	private double fiyat;
	
	@Column(name="hammadde", length =100)
	private String hammadde;
	
	@Column(name="kusurlu_mu")
	private boolean kusurlu_mu;
	
	@ManyToOne
    @JoinColumn(name = "fabrika_id")
    private FabrikaEntity fabrika;


	public void urunEkle() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUrun_adi() {
		return urun_adi;
	}


	public void setUrun_adi(String urun_adi) {
		this.urun_adi = urun_adi;
	}


	public String getUrunkod() {
		return urunkod;
	}


	public void setUrunkod(String urunkod) {
		this.urunkod = urunkod;
	}


	public double getFiyat() {
		return fiyat;
	}


	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}


	public String getHammadde() {
		return hammadde;
	}


	public void setHammadde(String hammadde) {
		this.hammadde = hammadde;
	}


	public boolean isKusurlu_mu() {
		return kusurlu_mu;
	}


	public void setKusurlu_mu(boolean kusurlu_mu) {
		this.kusurlu_mu = kusurlu_mu;
	}

	
	public FabrikaEntity getFabrika() {
		return fabrika;
	}


	public void setFabrika(FabrikaEntity fabrika) {
		this.fabrika = fabrika;
	}



}

