package mx.ftc.com.biblio.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cdautor")
	private String identificador;

	@Column(name="dsapeaut")
	private String apellidos;

	@Column(name="dsnomaut")
	private String nombre;

	@Column(name="dsorigen")
	private String origen;

	@Column(name="dsrefere")
	private String referencia;

	@Column(name="esfavaut")
	private String favorito;

	@XmlTransient
	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//bi-directional many-to-one association to LibroAutor
	@OneToMany(mappedBy="autor")
	private List<LibroAutor> libroAutors;

	public Autor() {
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getFavorito() {
		return favorito;
	}

	public void setFavorito(String favorito) {
		this.favorito = favorito;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public List<LibroAutor> getLibroAutors() {
		return this.libroAutors;
	}

	public void setLibroAutors(List<LibroAutor> libroAutors) {
		this.libroAutors = libroAutors;
	}

	public LibroAutor addLibroAutor(LibroAutor libroAutor) {
		getLibroAutors().add(libroAutor);
		libroAutor.setAutor(this);

		return libroAutor;
	}

	public LibroAutor removeLibroAutor(LibroAutor libroAutor) {
		getLibroAutors().remove(libroAutor);
		libroAutor.setAutor(null);

		return libroAutor;
	}

}