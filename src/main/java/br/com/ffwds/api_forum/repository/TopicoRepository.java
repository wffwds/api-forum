package br.com.ffwds.api_forum.repository;

import br.com.ffwds.api_forum.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
