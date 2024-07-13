package com.example.demo.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	String source;
	String destination;
	int flightNumber;
	@Override
	public String toString() {
		return "Flight [id=" + id + ", source=" + source + ", destination=" + destination + ", flightNumber="
				+ flightNumber + "]";
	}
	public Flight(Long id, String source, String destination, int flightNumber) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.flightNumber = flightNumber;
	}
	
	public Flight()
	{
		
	}

}
