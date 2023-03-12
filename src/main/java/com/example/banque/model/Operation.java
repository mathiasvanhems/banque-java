package com.example.banque.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="operation")
public class Operation {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) // utilise deśsequence inerne
    @SequenceGenerator(name="operation_id_seq",sequenceName="operation_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="operation_id_seq")
    private int id;
    
    @Column(precision =10 ,scale = 2 )
    private BigDecimal montant;

    @Column(length= 255, nullable= true)
    private String detail;

    private Date dateOperation;

    @ManyToOne()
    @JoinColumn(name="type_id",nullable= false)
    private TypeOperation type;

	public Operation() {
	}

	public Operation(int id, BigDecimal montant, String detail, Date dateOperation, TypeOperation type) {
		this.id = id;
		this.montant = montant;
		this.detail = detail;
		this.dateOperation = dateOperation;
		this.type = type;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public TypeOperation getType() {
		return type;
	}

	public void setType(TypeOperation type) {
		this.type = type;
	}

    

	
   
}
