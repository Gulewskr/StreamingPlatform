package rg.ragulajw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rg.ragulajw.data.domain.Image;
import rg.ragulajw.repositories.ImageRepository;

import java.util.List;

@Service
public class ImageServices implements IImageServices{

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image add(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image getById(long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image update(Image image, long id) {
        return imageRepository.findById(id)
                .map(oldImage -> {
                    oldImage.setName(image.getName());
                    oldImage.setDescription(image.getDescription());
                    oldImage.setImageUrl(image.getImageUrl());
                    return imageRepository.save(oldImage);
                })
                .orElseGet(() -> {
                    image.setId(id);
                    return imageRepository.save(image);
                });
    }

    @Override
    public void deleteById(long id) {
        imageRepository.deleteById(id);
    }
}
