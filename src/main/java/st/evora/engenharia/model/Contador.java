package st.evora.engenharia.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "contador")
public class Contador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcontador;
	
	//Mapeamento de Relação entre ás Tabelas Cliente - Contador (1-N)
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idcliente")
	
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idgeorreferencia")
	
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Georreferencia georreferencia;
	
	private String conta_numero;
	private String numero_contador;
	private Integer leitura_anterior;
	private Integer nova_leitura;
	private String amperagem;
	private String ramal;
	private String distrito;
	private String descricao;
	//private String latitude;
	//private String longitude;
	//private String localizacao;
	//private String cidade;
	//estes nomes tªem q estar igual no front, maiuscolo, minisculo tudo igual
	
	public Contador() {
	}

	public Contador(Long idcontador, 
			String conta_numero, 
			String numero_contador, 
			Integer leitura_anterior, 
			Integer nova_leitura, 
			String ramal, 
			String amperagem,
			String distrito, 
			String descricao) {
		super();
		this.idcontador = idcontador;
		this.conta_numero = conta_numero;
		this.numero_contador = numero_contador;
		this.leitura_anterior = leitura_anterior;
		this.nova_leitura = nova_leitura;
		this.amperagem =  amperagem;
		//this.latitude =  latitude;
		//this.longitude = longitude;
		this.ramal = ramal;
		//this.localizacao = localizacao;
		//this.cidade = cidade;
		this.distrito = distrito;
		this.descricao = descricao;
	}
	public Long getIdcontador() {
		return idcontador;
	}
	public void setIdcontador(Long idcontador) {
		this.idcontador = idcontador;
	}
	public String getConta_numero() {
		return conta_numero;
	}
	public void setConta_numero(String conta_numero) {
		this.conta_numero = conta_numero;
	}
	public String getNumero_contador() {
		return numero_contador;
	}
	public void setNumero_contador(String numero_contador) {
		this.numero_contador = numero_contador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getLeitura_anterior() {
		return leitura_anterior;
	}
	public void setLeitura_anterior(Integer leitura_anterior) {
		this.leitura_anterior = leitura_anterior;
	}
	public Integer getNova_leitura() {
		return nova_leitura;
	}
	public void setNova_leitura(Integer nova_leitura) {
		this.nova_leitura = nova_leitura;
	}
	
	public String getAmperagem() {
		return amperagem;
	}

	public void setAmperagem(String amperagem) {
		this.amperagem = amperagem;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Contador(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Contador> getClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Georreferencia getGeorreferencia() {
		return georreferencia;
	}

	public void setGeorreferencia(Georreferencia georreferencia) {
		this.georreferencia = georreferencia;
	}
	
}