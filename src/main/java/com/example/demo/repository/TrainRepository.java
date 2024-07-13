package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Train;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

	List<Train> findTrainBySourceAndDestination(String source, String destination);
	
	Train findTrainByTrainNumber(int trainNum);
	
	Train findTrainById(int id);
	
	
	
}
