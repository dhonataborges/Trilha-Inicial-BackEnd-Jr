package com.codigo_certo.project_root.models.exception;

import com.codigo_certo.project_root.models.exception.entidadeException.EntidadeNaoEncontradaException;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public UsuarioNaoEncontradoException(Long usuarioId) {
        this(String.format("Não existe usuario com o código %d", usuarioId));
    }
}
