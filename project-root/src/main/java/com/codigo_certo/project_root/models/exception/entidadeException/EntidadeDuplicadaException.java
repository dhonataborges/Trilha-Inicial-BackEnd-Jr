package com.codigo_certo.project_root.models.exception.entidadeException;

import com.codigo_certo.project_root.models.exception.NegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntidadeDuplicadaException extends NegocioException {
    private static final long serialVersionUID = 1L;

    public EntidadeDuplicadaException(String mensagem){
        super(mensagem);
    }

}
