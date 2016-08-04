package mx.ftc.com.biblio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the editorial database table.
 * 
 */
@Entity
@NamedQuery(name="Editorial.findAll", query="SELECT e FROM Editorial e")
public class Editorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cdeditor;

	private String dseditor;

	private String dsorigen;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	public Editorial() {
	}

	public String getCdeditor() {
		return this.cdeditor;
	}

	public void setCdeditor(String cdeditor) {
		this.cdeditor = cdeditor;
	}

	public String getDseditor() {
		return this.dseditor;
	}

	public void setDseditor(String dseditor) {
		this.dseditor = dseditor;
	}

	public String getDsorigen() {
		return this.dsorigen;
	}

	public void setDsorigen(String dsorigen) {
		this.dsorigen = dsorigen;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

}