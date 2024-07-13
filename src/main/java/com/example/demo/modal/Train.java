package com.example.demo.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train")  
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	String source;
	String destination;
	int trainNumber;
	
	@Override
	public String toString() {
		return "Train [source=" + source + ", destination=" + destination + ", trainNumber=" + trainNumber + "]";
	}

	public Train(String source, String destination, int trainNumber) {
		super();
		this.source = source;
		this.destination = destination;
		this.trainNumber = trainNumber;
	}
	
	public Train() 
	{
		
	}


}
