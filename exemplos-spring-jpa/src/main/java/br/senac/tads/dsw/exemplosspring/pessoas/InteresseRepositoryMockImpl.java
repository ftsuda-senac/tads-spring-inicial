package br.senac.tads.dsw.exemplosspring.pessoas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InteresseRepositoryMockImpl implements InteresseRepository {

    private Map<Integer, Interesse> mapItens;

    private int sequenciaId = 0;

    public InteresseRepositoryMockImpl() {
        mapItens = new ConcurrentHashMap<>();
        mapItens.put(++sequenciaId, new Interesse(sequenciaId, "Java"));
        mapItens.put(++sequenciaId, new Interesse(sequenciaId, "Python"));
        mapItens.put(++sequenciaId, new Interesse(sequenciaId, "Javascript"));
        mapItens.put(++sequenciaId, new Interesse(sequenciaId, "User experience"));
        mapItens.put(++sequenciaId, new Interesse(sequenciaId, "Banco de dados"));
        mapItens.put(++sequenciaId, new Interesse(sequenciaId, "Testes"));
    }

    @Override
    public List<Interesse> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Interesse> findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Interesse save(Interesse interesse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
