package cs2031.utec.edu.pe.controller;

import cs2031.utec.edu.pe.model.GrupoTipo;
import cs2031.utec.edu.pe.services.GrupoTipoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupotipos")
@CrossOrigin(origins = "*")
public class GrupoTipoController {

    @Autowired
    private GrupoTipoService service;

    @PostMapping
    public void create(@RequestBody GrupoTipo grupo) {
        service.create(grupo);
    }

    @GetMapping
    public List<GrupoTipo> read() {
        return service.read();
    }

    @GetMapping("/{id}")
    public GrupoTipo read(@PathVariable Long id) {
        return service.read(id);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody GrupoTipo grupo, @PathVariable Long id) {
        service.update(id, grupo);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
