package com.example.banque.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "historique")
public class Historique {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) // utilise des sequences
	// interne
	@SequenceGenerator(name = "historique_id_seq", sequenceName = "historique_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historique_id_seq")
	private int id;

	@Column(precision = 10, scale = 2, nullable = true)
	private BigDecimal montant;

	private Date periode;

	public Historique() {
		// TODO Auto-generated constructor stub
	}

	public Historique(BigDecimal montant, Date periode) {
		this.montant = montant;
		this.periode = periode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Date getPeriode() {
		return periode;
	}

	public void setPeriode(Date periode) {
		this.periode = periode;
	}

}
