package br.googolplex.controller;

import br.googolplex.domain.Paciente;
import br.googolplex.repository.PacienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PacienteController {
    private PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/paciente")
    public Map<String, Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @GetMapping("/paciente/{id}")
    public Paciente findById(@PathVariable String id) {
        return pacienteRepository.findById(id);
    }

    @PostMapping("/paciente")
    public void createStudent(@RequestBody Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable String id) {
        pacienteRepository.delete(id);
    }
}
