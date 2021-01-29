package com.example.gtommee.rest_tutorial.Model;

import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;
public class Pets {

	@Id
	public ObjectId id;
	
	public String name;
	public String species;
	public String breed;
	
	public Pets() {
	}
	
	public Pets(ObjectId _id, String n, String s, String b) {
		this.id = _id;
		this.name = n;
		this.species = s;
		this.breed = b;
	}

	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	
}
