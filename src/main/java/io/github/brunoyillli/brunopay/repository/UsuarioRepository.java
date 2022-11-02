package io.github.brunoyillli.brunopay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunoyillli.brunopay.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);

}
