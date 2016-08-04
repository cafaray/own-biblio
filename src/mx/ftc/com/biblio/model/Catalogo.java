package mx.ftc.com.biblio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the catalogo database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cdtblcat;

	private String dstblcat;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//bi-directional many-to-one association to CatalogoElemento
	@OneToMany(mappedBy="catalogo")
	private List<CatalogoElemento> catalogoElementos;

	public Catalogo() {
	}

	public String getCdtblcat() {
		return this.cdtblcat;
	}

	public void setCdtblcat(String cdtblcat) {
		this.cdtblcat = cdtblcat;
	}

	public String getDstblcat() {
		return this.dstblcat;
	}

	public void setDstblcat(String dstblcat) {
		this.dstblcat = dstblcat;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public List<CatalogoElemento> getCatalogoElementos() {
		return this.catalogoElementos;
	}

	public void setCatalogoElementos(List<CatalogoElemento> catalogoElementos) {
		this.catalogoElementos = catalogoElementos;
	}

	public CatalogoElemento addCatalogoElemento(CatalogoElemento catalogoElemento) {
		getCatalogoElementos().add(catalogoElemento);
		catalogoElemento.setCatalogo(this);

		return catalogoElemento;
	}

	public CatalogoElemento removeCatalogoElemento(CatalogoElemento catalogoElemento) {
		getCatalogoElementos().remove(catalogoElemento);
		catalogoElemento.setCatalogo(null);

		return catalogoElemento;
	}

}