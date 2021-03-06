package com.potitech.potifood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.potitech.potifood.domain.exception.EntidadeNaoEncontradaException;
import com.potitech.potifood.domain.model.entities.Estado;
import com.potitech.potifood.domain.service.CrudEstadoService;

//import javassist.bytecode.stackmap.BasicBlock.Catch;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private CrudEstadoService crudEstadoService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Estado> listar(){
		return crudEstadoService.listar();
	}
	
	@GetMapping("/{estadoId}")
	public ResponseEntity<?> buscar(@PathVariable("estadoId") Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(crudEstadoService.buscar(id));
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Estado adicionar(@RequestBody Estado estado) {
		return crudEstadoService.salvar(estado);
	}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<?> atualizar(@PathVariable("estadoId") Long id, @RequestBody Estado estado) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(crudEstadoService.atualizar(id, estado));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{estadoId}")
	public ResponseEntity<?> remover(@PathVariable("estadoId") Long id){
		try {
			crudEstadoService.remover(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (EntidadeNaoEncontradaException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
