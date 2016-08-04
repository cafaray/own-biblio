package mx.ftc.com.biblio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the libro_clasificacion database table.
 * 
 */
@Entity
@Table(name="libro_clasificacion")
@NamedQuery(name="LibroClasificacion.findAll", query="SELECT l FROM LibroClasificacion l")
public class LibroClasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cdclalib;

	private String cdclasif;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//bi-directional many-to-one association to Libro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cdlibro")
	private Libro libro;

	public LibroClasificacion() {
	}

	public String getCdclalib() {
		return this.cdclalib;
	}

	public void setCdclalib(String cdclalib) {
		this.cdclalib = cdclalib;
	}

	public String getCdclasif() {
		return this.cdclasif;
	}

	public void setCdclasif(String cdclasif) {
		this.cdclasif = cdclasif;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

}