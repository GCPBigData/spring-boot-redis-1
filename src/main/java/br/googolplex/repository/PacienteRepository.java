package br.googolplex.repository;

import br.googolplex.domain.Paciente;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class PacienteRepository implements RedisRepository {
    private static final String KEY = "Student";

    private RedisTemplate<String, Paciente> redisTemplate;
    private HashOperations hashOperations;

    public PacienteRepository(RedisTemplate<String, Paciente> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Paciente> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Paciente findById(String id) {
        return (Paciente) hashOperations.get(KEY, id);
    }

    @Override
    public void save(Paciente paciente) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), paciente);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
}
