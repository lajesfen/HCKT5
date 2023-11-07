package cs2031.utec.edu.pe.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="groups")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name="person_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> persons = new HashSet<>();

    @ManyToOne
    private GrupoTipo grupoTipo;

    public Grupo() {
    }

    public Grupo(Long id, String name, Set<Person> persons) {
        this.id = id;
        this.name = name;
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GrupoTipo getGrupoTipo() {
        return grupoTipo;
    }

    public void setGrupoTipo(GrupoTipo grupoTipo) {
        this.grupoTipo = grupoTipo;
    }

    public int getPersonsCount() {
        return this.persons.size();
    }
}
