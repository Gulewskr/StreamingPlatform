package rg.ragulajw.data.domain;

import javax.persistence.*;

@Entity
@Table(name="SingleDescription")
public class MiniDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Image
    @ManyToOne
    private Image image;
    @Column
    private float imageWidth;
    @Column
    private float imageHeight;
    @Column
    private String imageRef;

    //Text
    @Column
    private String formatedText;
}
