package com.guitech.tutorialrestapi.repository;

import com.guitech.tutorialrestapi.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
/*
CrudRepository<> -> aqui vai o modelo de dados que estou usando e tipo do meu ID
da classe UsuarioModel

Serve para consultas basicas ao banco de dados
 */
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
}
