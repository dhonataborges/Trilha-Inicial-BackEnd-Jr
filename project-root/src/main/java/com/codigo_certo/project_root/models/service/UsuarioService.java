package com.codigo_certo.project_root.models.service;

import com.codigo_certo.project_root.models.exception.NegocioException;
import com.codigo_certo.project_root.models.exception.UsuarioNaoEncontradoException;
import com.codigo_certo.project_root.models.exception.entidadeException.EntidadeEmUsoException;
import com.codigo_certo.project_root.models.model.Usuario;
import com.codigo_certo.project_root.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private static final String MSG_USUARIO_EM_USO = "Usuario de código %d não pode ser removido, pois está em uso";


    public Usuario salvar(Usuario usuario){

        Optional<Usuario> cpfExistente = usuarioRepository.verificaCPF(usuario.getCpf());

        if(cpfExistente.isPresent()) {
            throw new NegocioException("CPF já cadastrado na base de dados!");
        }

        return usuarioRepository.save(usuario);
    }

    public void delete(Long usuarioId) {
        try {
            usuarioRepository.deleteById(usuarioId);
        }catch (EmptyResultDataAccessException e) {
            throw new UsuarioNaoEncontradoException(usuarioId);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MSG_USUARIO_EM_USO));
        }
    }

    public Usuario buscarOuFalhar(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
    }
}
