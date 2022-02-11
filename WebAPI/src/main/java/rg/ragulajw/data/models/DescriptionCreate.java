package rg.ragulajw.data.models;

import rg.ragulajw.data.domain.SingleDescription;

import java.util.List;

public class DescriptionCreate {
    private String text;
    private long imageId;
    private List<SingleDescription> descriptions;

    public String getText() { return text; }
    public long getImageId() { return imageId; }
    public List<SingleDescription> getDescriptions() { return descriptions; }


    public void setText(String text) { this.text = text; }
    public void setImageId(long image) { this.imageId = image; }
    public void setDescriptions(List<SingleDescription> descriptions) { this.descriptions = descriptions; }

}
