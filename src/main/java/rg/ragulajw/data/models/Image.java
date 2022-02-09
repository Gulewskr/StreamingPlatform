package rg.ragulajw.data.models;

public class Image {
    private final int id;
    private final String name;
    private final String imageUrl;
    private final String description;

    public Image(int id, String name, String imageUrl, String description) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

}
