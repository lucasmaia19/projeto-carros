package com.example.projetocarros.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetocarros.entity.Carros;
import com.example.projetocarros.entity.CompraCarro;
import com.example.projetocarros.repository.CompraCarroRepository;

@RestController
@RequestMapping("/compra-carro")
public class CompraCarroController {
		
	@Autowired
	private CompraCarroRepository repository;
	
	@PostMapping
//	public CompraCarro cadastrar(@ModelAttribute CompraCarro compraCarro, @RequestPart(required = false) String carros) {
//	public CompraCarro cadastrar(@RequestBody CompraCarro compraCarro) {
	public CompraCarro cadastrar(@ModelAttribute CompraCarro compraCarro) {
		
//		List<Carros> carrosList = new ArrayList<>();

		return repository.save(compraCarro);

	}
	
	@GetMapping
	public List<CompraCarro> listatodos() {
		return repository.findAll();

	}
	
	@GetMapping ("/{id}") 
	public Optional<CompraCarro> listarUm(@PathVariable Long id) {
	return repository.findById(id);

	}
	
	@DeleteMapping ("/{id}") 
	public String deletar (@PathVariable Long id) {
		repository.deleteById(id);
		return "A compra do Id: " + id + " Foi deletado com sucesso";
	
	}
	
	@PutMapping("/{id}")
	public CompraCarro atualizar(@RequestBody CompraCarro compraCarro, @PathVariable Long id) {
		
		CompraCarro compraCarroSaved = repository.findById(id).get();

		BeanUtils.copyProperties(compraCarro, compraCarroSaved, "id");

		return repository.save(compraCarroSaved);
		
	}


}
