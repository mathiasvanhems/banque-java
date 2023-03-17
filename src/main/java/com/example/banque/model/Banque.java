package com.example.banque.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="banque")
public class Banque {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) // utilise des sequences interne
    @SequenceGenerator(name="banque_id_seq",sequenceName="banque_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="banque_id_seq")
    private int id;
    
    @Column(precision =10 ,scale = 2 )
    private BigDecimal compteCourant;

    @Column(name = "livret_a",precision =10 ,scale = 2, nullable = true )
    private BigDecimal livretA;

    @Column(precision =10 ,scale = 2, nullable = true )
    private BigDecimal epargne;

    @Column(precision =10 ,scale = 2, nullable = true )
    private BigDecimal ticketRestaurant;

    public Banque() {
    }

	public Banque(BigDecimal compteCourant, BigDecimal livretA, BigDecimal epargne, BigDecimal ticketRestaurant) {
		this.compteCourant = compteCourant;
		this.livretA = livretA;
		this.epargne = epargne;
		this.ticketRestaurant = ticketRestaurant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(BigDecimal compteCourant) {
		this.compteCourant = compteCourant;
	}

	public BigDecimal getLivretA() {
		return livretA;
	}

	public void setLivretA(BigDecimal livretA) {
		this.livretA = livretA;
	}

	public BigDecimal getEpargne() {
		return epargne;
	}

	public void setEpargne(BigDecimal epargne) {
		this.epargne = epargne;
	}

	public BigDecimal getTicketRestaurant() {
		return ticketRestaurant;
	}

	public void setTicketRestaurant(BigDecimal ticketRestaurant) {
		this.ticketRestaurant = ticketRestaurant;
	}

   
}
