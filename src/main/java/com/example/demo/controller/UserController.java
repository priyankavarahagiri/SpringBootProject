package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Train;
import com.example.demo.repository.TrainRepository;


@RestController
@RequestMapping("/usr")
public class UserController 
{
	@Autowired
	 private TrainRepository trainRepository;

	
	@GetMapping("/search")
	public String findTrainBySourceAndDestination(@RequestParam(required=true) String source, @RequestParam(required=true) String destination){
		List<Train> trains = trainRepository.findTrainBySourceAndDestination(source.trim(), destination.trim());
		return trains.toString();
		
	}
	
	@GetMapping("/searchTnum")
	public String findTrainByTrainNumber(@RequestParam(required=true) int trainnumber) {
		Train train = trainRepository.findTrainByTrainNumber(trainnumber);
		return train.toString();
		
	}
	
	@GetMapping("/searchById")
	public String findTrainById(@RequestParam(required=true) int id) {
		Train train = trainRepository.findTrainById(id);
	
		return train.toString();
		
	}
	

}
