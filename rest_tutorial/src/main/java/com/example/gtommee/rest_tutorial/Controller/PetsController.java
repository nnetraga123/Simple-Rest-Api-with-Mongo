package com.example.gtommee.rest_tutorial.Controller;
import com.example.gtommee.rest_tutorial.Model.*;
import com.example.gtommee.rest_tutorial.Repository.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {
	@Autowired
	private PetsRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Pets> getAllPets(){
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pets getByID(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPetbyId(@PathVariable("id") ObjectId id, @RequestBody Pets pets) {
		pets.setId(id);
		repository.save(pets);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Pets createPet(@Validated @RequestBody Pets pets) {
	  pets.setId(ObjectId.get());
	  repository.save(pets);
	  return pets;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePet(@PathVariable ObjectId id) {
	  repository.delete(repository.findBy_id(id));
	}
	
}