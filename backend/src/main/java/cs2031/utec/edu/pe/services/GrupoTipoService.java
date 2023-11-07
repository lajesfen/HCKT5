package cs2031.utec.edu.pe.services;

import cs2031.utec.edu.pe.model.GrupoTipo;
import cs2031.utec.edu.pe.repositories.GrupoTipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GrupoTipoService {
    @Autowired
    private GrupoTipoRepository repository;

    public void create(GrupoTipo grupotipo){
        repository.save(grupotipo);
    }

    public GrupoTipo read(Long id) {
        return repository.findById(id).get();
    }

    public List<GrupoTipo> read(){
        return repository.findAll();
    }

    public GrupoTipo update(Long id, GrupoTipo p){
        return repository.save(p);
    }

    public void delete(Long id){
        GrupoTipo grupotipo;
        grupotipo = repository.findById(id).get();
    }
}
