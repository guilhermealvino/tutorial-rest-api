package com.guitech.tutorialrestapi.controller;

import com.guitech.tutorialrestapi.model.UsuarioModel;
import com.guitech.tutorialrestapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {


    /*
    Criar repositorio usando o Autowired
     */
    @Autowired
    private UsuarioRepository repository;

    /*metodo de consulta e o GetMapping serve para acessar o banco de dados
    PathVariable - serve para acessar codigo do GetMapping - GetMapping(path = "/api/usuario/{CODIGO}")
     */
    @GetMapping(path = "/api/usuario/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo){
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
        /*No findbyId é um metodo que ja vem no repositorio padrao - chamando metodo map
        e se por acaso retorna algo, trazer o meu OK + corpo da minha requisição + registro

        caso contrario - notFound.build()

         */

        }

    //MEtodo Salvar
    @PostMapping("/api/usuario/salvar")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario){
        return repository.save(usuario);

    }
}
