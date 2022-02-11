package rg.ragulajw.data.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="description", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_user", columnNames = "user_id"),
        @UniqueConstraint(name = "UNQ_profileImage", columnNames = "profile_image_id")
})
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition="TEXT")
    private String text;

    @OneToOne
    private User user;

    @OneToOne
    private Image profileImage;

    @OneToMany
    private List<SingleDescription> descriptions;

    public long getId() { return id; }
    public String getText() { return text; }
    public User getUser() { return user; }
    public Image getProfileImage() { return profileImage; }
    public List<SingleDescription> getDescriptions() { return descriptions; }


    public void setId(long id) { this.id = id; }
    public void setText(String text) { this.text = text; }
    public void setUser(User user) { this.user = user; }
    public void setProfileImage(Image image) { this.profileImage = image; }
    public void setDescriptions(List<SingleDescription> descriptions) { this.descriptions = descriptions; }
}
