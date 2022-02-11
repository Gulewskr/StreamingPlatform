package rg.ragulajw.data.domain;

import javax.persistence.*;

@Entity
@Table(name="single_description")
public class SingleDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Image
    @OneToOne
    private Image image;
    @Column
    private String imageRef;

    //Text
    @Column
    private String text;

    //Placement
    @Column
    private int _column;
    // 0-left 1-center 2-right
    @Column
    private int placeInColumn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColumn() {
        return _column;
    }

    public void setColumn(int _column) {
        this._column = _column;
    }

    public int getPlaceInColumn() {
        return placeInColumn;
    }

    public void setPlaceInColumn(int placeInColumn) {
        this.placeInColumn = placeInColumn;
    }
}
