package com.example.prakt2.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doljnost
{ @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
        @Column
        public String name;

        @OneToMany
        private List<Worker> Workers;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


}

