package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.modal.Train;
import com.example.demo.repository.TrainRepository;

import java.util.*;
import java.io.*;
import org.apache.commons.csv.*;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private TrainRepository trainRepository;

//    @Autowired
//    public AdminController(TrainService trainService) {
//        this.trainService = trainService;
//    }
	
	@PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty";
        }

        // Process the file
        String fileName = file.getOriginalFilename();
        long fileSize = file.getSize();
        
       
        // Additional processing logic (e.g., saving the file to disk)
        
        List<Train> trains = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            for (CSVRecord record : csvParser.getRecords()) 
            {
            	Train train = new Train(record.get(0),record.get(1),Integer.parseInt(record.get(2)));
            	trains.add(train);
        
        
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        trainRepository.saveAll(trains);
        
        return "File uploaded successfully: " + fileName + " (" + fileSize + " bytes)" + trains;
    }

}