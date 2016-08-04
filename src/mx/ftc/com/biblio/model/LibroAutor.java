package mx.ftc.com.biblio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the libro_autor database table.
 * 
 */
@Entity
@Table(name="libro_autor")
@NamedQuery(name="LibroAutor.findAll", query="SELECT l FROM LibroAutor l")
public class LibroAutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cdlibaut;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//bi-directional many-to-one association to Libro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cdlibro")
	private Libro libro;

	//bi-directional many-to-one association to Autor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cdautor")
	private Autor autor;

	public LibroAutor() {
	}

	public String getCdlibaut() {
		return this.cdlibaut;
	}

	public void setCdlibaut(String cdlibaut) {
		this.cdlibaut = cdlibaut;
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

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}