package rg.ragulajw.services;

import rg.ragulajw.data.domain.Image;

import java.util.List;

public interface IImageServices {
    Image add(Image image);
    Image getById(long id);
    List<Image> getAll();
    Image update(Image image, long id);
    void deleteById(long id);
}
