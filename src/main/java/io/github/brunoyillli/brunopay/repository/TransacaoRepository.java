package io.github.brunoyillli.brunopay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunoyillli.brunopay.modelo.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}
