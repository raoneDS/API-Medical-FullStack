package br.com.beyoux.apifullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.beyoux.apifullstack.entities.Paciente;

public interface RepositorioPaciente extends JpaRepository<Paciente,Long>{

    boolean existsByCPF(String cpf);    
}
