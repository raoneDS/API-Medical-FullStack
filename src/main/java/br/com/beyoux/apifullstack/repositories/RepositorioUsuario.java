package br.com.beyoux.apifullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.beyoux.apifullstack.entities.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    
}
