package com.example.projetocarros.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.projetocarros.entity.CompraCarro;
import com.example.projetocarros.repository.CompraCarroRepository;

@RestController
@RequestMapping("/compra-carro")
public class CompraCarroController {
		
	@Autowired
	private CompraCarroRepository repository;
	
	@PostMapping
	public CompraCarro cadastrar(@ModelAttribute CompraCarro compraCarro) {
		
		// pega a data de hoje e formata
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
		
		LocalDate dataAtual;
//		dataAtual = (formatarDate.format(data));
//		System.out.print(dataAtual);
		
		compraCarro.getData().toString();
		
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
		return null;
	
	}
	
	@PutMapping("/{id}")
	public CompraCarro atualizar(@ModelAttribute CompraCarro compraCarro, @PathVariable Long id) {
		
		CompraCarro compraCarroSaved = repository.findById(id).get();

		BeanUtils.copyProperties(compraCarro, compraCarroSaved, "id");

		return repository.save(compraCarroSaved);
		
	}


}
