package rg.ragulajw.data.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Description")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition="TEXT")
    private String text;

    @OneToOne
    private Image profileImage;

    @OneToMany
    private List<MiniDescription> rightColumn;
    @OneToMany
    private List<MiniDescription> leftColumn;
    @OneToMany
    private List<MiniDescription> centralColumn;
}
