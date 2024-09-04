package com.codigo_certo.project_root.models.repository;

import com.codigo_certo.project_root.models.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    @Query("from Usuario u where u.cpf =:cpf")
    Optional<Usuario>verificaCPF(String cpf);
}
