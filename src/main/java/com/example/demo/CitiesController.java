package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Madhura Bhave
 */
@RestController
public class CitiesController {

	private CityRepository repository;

	public CitiesController(CityRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/cities/{id}")
	public Mono<City> findById(@PathVariable String id) {
		return this.repository.findById(id);
	}

	@GetMapping("/cities")
	public Flux<City> all() {
		return this.repository.findAll();
	}
}
