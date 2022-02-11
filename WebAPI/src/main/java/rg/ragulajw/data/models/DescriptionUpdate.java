package rg.ragulajw.data.models;

import rg.ragulajw.data.domain.SingleDescription;

import java.util.List;

public class DescriptionUpdate {
    private String text;
    private long userId;
    private long imageId;

    public String getText() { return text; }
    public long getUserId() { return userId; }
    public long getImageId() { return imageId; }


    public void setText(String text) { this.text = text; }
    public void setUserId(long user) { this.userId = user; }
    public void setImageId(long image) { this.imageId = image; }
}
