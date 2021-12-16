package br.com.beyoux.apifullstack.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beyoux.apifullstack.entities.Paciente;
import br.com.beyoux.apifullstack.repositories.RepositorioPaciente;

@Service
public class ServicePaciente {

    @Autowired
    private RepositorioPaciente repository;

    public List<Paciente> findAll(){
        return repository.findAll();
    }

    public Paciente findById(Long id){
        Optional<Paciente> obj = repository.findById(id);
        return obj.get();
    }

    public Paciente create(Paciente paciente){
        if (repository.existsByCPF(paciente.getCpf()))
            paciente = null;
        return repository.save(paciente);
    }

    public Paciente update(Paciente paciente, Long id){
        paciente.setId(id);
        return repository.save(paciente);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
