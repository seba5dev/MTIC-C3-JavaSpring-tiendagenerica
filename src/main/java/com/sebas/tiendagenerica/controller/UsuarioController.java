package com.sebas.tiendagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.sebas.tiendagenerica.model.UsuarioModel;
import com.sebas.tiendagenerica.services.UsuarioService;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //Crear usuario
    @PostMapping
    public ResponseEntity<?> create(@RequestBody UsuarioModel usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    //Buscar usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long usuarioid){
        Optional<UsuarioModel> oUsuario = usuarioService.findById(usuarioid);
        if (!oUsuario.isPresent()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(oUsuario);
        }
    }

    //Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UsuarioModel usuarioDetails, @PathVariable(value = "id") Long usuarioid) {
        Optional<UsuarioModel> uUsuario = usuarioService.findById(usuarioid);

        if (!uUsuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        uUsuario.get().setCedula(usuarioDetails.getCedula());
        uUsuario.get().setCorreo(usuarioDetails.getCorreo());
        uUsuario.get().setEnabled(usuarioDetails.getEnabled());
        uUsuario.get().setNombre(usuarioDetails.getNombre());
        uUsuario.get().setNombreCompleto(usuarioDetails.getNombreCompleto());
        uUsuario.get().setPassword(usuarioDetails.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(uUsuario.get()));
    }

    //Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long usuarioid) {
        if (!usuarioService.findById(usuarioid).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.delete(usuarioid);
        return ResponseEntity.ok().build();
    }

    //Obtener todos los usuarios
    @GetMapping
    public List<UsuarioModel> readAll() {
        List<UsuarioModel> usuarios = StreamSupport.stream(usuarioService.findAll().spliterator(), false).collect(Collectors.toList());
        return usuarios;
    }
}
