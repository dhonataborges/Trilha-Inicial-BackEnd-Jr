package com.codigo_certo.project_root.api.controllers;

import com.codigo_certo.project_root.models.model.Usuario;
import com.codigo_certo.project_root.models.repository.UsuarioRepository;
import com.codigo_certo.project_root.models.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControllers {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> lista() {
        return usuarioRepository.findAll();
    }

    @GetMapping(value = "/{usuarioId}")
    public Usuario buscar(@PathVariable Long usuarioId){
       return usuarioService.buscarOuFalhar(usuarioId);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Usuario adicionar(@RequestBody @Valid Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @PutMapping(value = "/{usuarioId}")
    public Usuario atualizar(@PathVariable Long usuarioId, @RequestBody @Valid Usuario usuario) {

        Usuario usuarioAtual = usuarioService.buscarOuFalhar(usuarioId);

        BeanUtils.copyProperties(usuario, usuarioAtual, "id");

        return usuarioService.salvar(usuarioAtual);

    }

    @DeleteMapping(value = "/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long usuarioId) {
        usuarioService.delete(usuarioId);
    }

}
