package cs2031.utec.edu.pe.services;

import cs2031.utec.edu.pe.model.Grupo;
import cs2031.utec.edu.pe.model.GrupoTipo;
import cs2031.utec.edu.pe.repositories.GrupoRepository;
import cs2031.utec.edu.pe.repositories.GrupoTipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GrupoService {
    @Autowired
    private GrupoRepository repository;

    @Autowired
    private GrupoTipoRepository grupoTipoRepository;

    public void create(Grupo grupo){
        Long grupoTipoId = grupo.getGrupoTipo().getId();
        Optional<GrupoTipo> grupoTipo = grupoTipoRepository.findById(grupoTipoId);
        grupo.setGrupoTipo(grupoTipo.get());

        repository.save(grupo);
    }

    public Grupo read(Long id) {
        return repository.findById(id).get();
    }

    public List<Grupo> read(){
        return repository.findAll();
    }

    public Grupo update(Long id, Grupo p){
        return repository.save(p);
    }

    public void delete(Long id){
        Grupo person;
        person = repository.findById(id).get();
    }
}
