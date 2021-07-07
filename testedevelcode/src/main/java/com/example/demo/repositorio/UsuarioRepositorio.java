package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long> {
	
	List<Usuario> findByNome(String nome);
	List<Usuario> findByNomeContaining(String nome);
}
