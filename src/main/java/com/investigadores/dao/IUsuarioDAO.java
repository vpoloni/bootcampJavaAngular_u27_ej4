package com.investigadores.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.investigadores.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}

