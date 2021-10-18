package com.aritro.washerapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import com.aritro.washerapplication.model.WasherModel;
import com.aritro.washerapplication.repository.WasherRepository;



@RestController
@RequestMapping("/washer")
//@RequiredArgsConstructor
public class WasherController {
	
	@Autowired
	private  WasherRepository washerRepository;
    
	@PostMapping("/addWasher")
	public String saveBook(@RequestBody WasherModel washer ) {
		washerRepository.save(washer);
		return "Added washer with id:" + washer.getWasherId();
	}
	
	@GetMapping("/findAllWasher")
	public List<WasherModel> getBooks(){
		return washerRepository.findAll();
	}
	
	@GetMapping("/findAllWasher/{id}")
	public Optional<WasherModel> getBook(@PathVariable String id){
		return washerRepository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable String id) {
		washerRepository.deleteById(id);
		return "Washer deleted with id:" +id;
	}
	
	@PutMapping("/update/{id}")
	public WasherModel updateBook(@PathVariable String id, @RequestBody WasherModel washer) {
	washer.setWasherId(id);
	washerRepository.save(washer);
		return washer;
	}
}
