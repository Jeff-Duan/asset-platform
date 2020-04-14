package com.demo.asset.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "first_type")
public class Level1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "level1", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Level2> level2s;

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

    public List<Level2> getLevel2s() {
        return level2s;
    }

    public void setLevel2s(List<Level2> level2s) {
        this.level2s = level2s;
    }
}
