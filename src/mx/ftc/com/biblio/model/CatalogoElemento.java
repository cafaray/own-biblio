package mx.ftc.com.biblio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the catalogo_elemento database table.
 * 
 */
@Entity
@Table(name="catalogo_elemento")
@NamedQuery(name="CatalogoElemento.findAll", query="SELECT c FROM CatalogoElemento c")
public class CatalogoElemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CatalogoElementoPK id;

	private String dselemen;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//bi-directional many-to-one association to Catalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cdtblcat")
	private Catalogo catalogo;

	public CatalogoElemento() {
	}

	public CatalogoElementoPK getId() {
		return this.id;
	}

	public void setId(CatalogoElementoPK id) {
		this.id = id;
	}

	public String getDselemen() {
		return this.dselemen;
	}

	public void setDselemen(String dselemen) {
		this.dselemen = dselemen;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

}