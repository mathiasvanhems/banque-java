package com.example.banque.model;


import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="type_operation")
public class TypeOperation {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) // utilise deśsequence inerne
    @SequenceGenerator(name="type_operation_id_seq",sequenceName="type_operation_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="type_operation_id_seq")
    private int id;


    @Column(length= 255)
    private String libelle = null;

    @Column(length= 255)
    private String recurrence = null;

    @Column
    private boolean sortie;

    public TypeOperation() {
    }

	public TypeOperation(String libelle, String recurrence, Collection<Operation> operations, boolean sortie) {
		this.libelle = libelle;
		this.recurrence = recurrence;
		this.sortie = sortie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}

	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

	
}
