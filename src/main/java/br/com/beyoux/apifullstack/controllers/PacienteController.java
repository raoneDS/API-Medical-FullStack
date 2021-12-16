package br.com.beyoux.apifullstack.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.beyoux.apifullstack.entities.Paciente;
import br.com.beyoux.apifullstack.services.ServicePaciente;

@RestController
@RequestMapping({"/pacientes"})
@CrossOrigin(origins ="*" )
public class PacienteController {

    @Autowired
    private ServicePaciente service;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){
        List<Paciente> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        Paciente paciente = service.findById(id);
        return ResponseEntity.ok().body(paciente);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Paciente paciente){
        if(paciente == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Paciente já cadastrado");
        paciente = service.create(paciente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente, @PathVariable Long id){
       paciente = service.update(paciente, id);
       return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
