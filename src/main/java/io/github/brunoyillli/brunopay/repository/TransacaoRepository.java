package io.github.brunoyillli.brunopay.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunoyillli.brunopay.modelo.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	Page<Transacao> findByOrigem_LoginOrDestino_Login(String login, String login2, Pageable paginacao);

}
