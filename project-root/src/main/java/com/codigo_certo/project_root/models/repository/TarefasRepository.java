package com.codigo_certo.project_root.models.repository;

import com.codigo_certo.project_root.models.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long>{
}
