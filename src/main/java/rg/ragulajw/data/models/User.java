package rg.ragulajw.data.models;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) { this.name = name; }

    @Id
    public Long getId() {
        return id;
    }
    public String getName() { return name; }
}
