package com.example.prakt2.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne (fetch = FetchType.EAGER)
    flexik flexik;

    public com.example.prakt2.models.flexik getFlexik() {
        return flexik;
    }

    public void setFlexik(com.example.prakt2.models.flexik flexik) {
        this.flexik = flexik;
    }

    public void setFilials(List<Filial> filials) {
        this.filials = filials;
    }

    public Doljnost getDoljnost() {
        return doljnost;
    }

    public void setDoljnost(Doljnost doljnost) {
        this.doljnost = doljnost;
    }

    @ManyToMany
    @JoinTable (name="worker_filial",
            joinColumns=@JoinColumn (name="worker_id"),
            inverseJoinColumns=@JoinColumn(name="filial_id"))
    private List<Filial> filials;

    @ManyToOne
    Doljnost doljnost;

    public Worker() {

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

    public List<Filial> getFilials() {
        return filials;
    }


    public Worker(flexik flex, String name, List<Filial> filials)
    {
        this.name = name;
        this.flexik = flex;
        this.filials = filials;
    }

}
