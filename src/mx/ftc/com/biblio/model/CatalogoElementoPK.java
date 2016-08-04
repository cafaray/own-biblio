package mx.ftc.com.biblio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the catalogo_elemento database table.
 * 
 */
@Embeddable
public class CatalogoElementoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String cdtblcat;

	private String cdelemen;

	public CatalogoElementoPK() {
	}
	public String getCdtblcat() {
		return this.cdtblcat;
	}
	public void setCdtblcat(String cdtblcat) {
		this.cdtblcat = cdtblcat;
	}
	public String getCdelemen() {
		return this.cdelemen;
	}
	public void setCdelemen(String cdelemen) {
		this.cdelemen = cdelemen;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CatalogoElementoPK)) {
			return false;
		}
		CatalogoElementoPK castOther = (CatalogoElementoPK)other;
		return 
			this.cdtblcat.equals(castOther.cdtblcat)
			&& this.cdelemen.equals(castOther.cdelemen);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cdtblcat.hashCode();
		hash = hash * prime + this.cdelemen.hashCode();
		
		return hash;
	}
}