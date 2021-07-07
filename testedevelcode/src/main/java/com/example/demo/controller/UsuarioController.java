package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio usuarioRepository;
	
	

	@GetMapping
	public List <Usuario> listar() {
	
	return usuarioRepository.findAll();
	
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId ) {
		return usuarioRepository.findById(usuarioId)
		.map(usuario -> ResponseEntity.ok(usuario))
		.orElse(ResponseEntity.notFound().build());
		

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@Validated @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	 
		
	}
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> atualizar(@Validated @PathVariable Long usuarioId,
			@RequestBody Usuario usuario){
		if(!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		
		usuario.setId(usuarioId);
	
		usuario = usuarioRepository.save(usuario);
		
		return ResponseEntity.ok(usuario);
		
	}
	
	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<Void> remover(@PathVariable Long usuarioId){
		if(!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		
		usuarioRepository.deleteById(usuarioId);
		
		
		return ResponseEntity.noContent().build();
	}

}
