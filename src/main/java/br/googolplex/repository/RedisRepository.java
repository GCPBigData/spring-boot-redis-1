package br.googolplex.repository;

import br.googolplex.domain.Paciente;

import java.util.Map;

public interface RedisRepository {
    Map<String, Paciente> findAll();
    Paciente findById(String id);
    void save(Paciente paciente);
    void delete(String id);
}
