package st.evora.engenharia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "georreferencia")
public class Georreferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idgeorreferencia;
	
	
	private String latitude;
	private String longitude;
	
	/*
	@Column(nullable = true, length = 64)
	private String photos;
	*/
	private String descricao;
	
	public Georreferencia() {
		super();
	}

	public Georreferencia save(Georreferencia georreferencia) {
		// TODO Auto-generated method stub
		return null;
	}

	public Georreferencia(long idgeorreferencia, String latitude, String longitude, String descricao) {
		super();
		this.idgeorreferencia = idgeorreferencia;
		this.latitude = latitude;
		this.longitude = longitude;
		//this.photos = photos;
		this.descricao = descricao;
	}

	public long getIdgeorreferencia() {
		return idgeorreferencia;
	}

	public void setIdgeorreferencia(long idgeorreferencia) {
		this.idgeorreferencia = idgeorreferencia;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/*
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	*/
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
