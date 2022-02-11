package rg.ragulajw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rg.ragulajw.data.domain.SingleDescription;
import rg.ragulajw.repositories.SingleDescriptionRepository;

import java.util.List;

@Service
public class SingleDescriptionServices implements ISingleDescriptionServices{

    @Autowired
    SingleDescriptionRepository repository;

    @Override
    public SingleDescription add(SingleDescription description) {
        if(description.getImage() != null && description.getImage().getId() <= 0)
            description.setImage(null);
        return repository.save(description);
    }

    @Override
    public SingleDescription getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SingleDescription> getAll() {
        return repository.findAll();
    }

    @Override
    public SingleDescription update(SingleDescription description, long id) {
        return repository.findById(id)
                .map(old -> {
                    old.setImage(description.getImage());
                    old.setImageRef(description.getImageRef());
                    old.setText(description.getText());
                    old.setColumn(description.getColumn());
                    old.setPlaceInColumn(description.getPlaceInColumn());
                    return repository.save(old);
                })
                .orElseGet(() -> {
                    description.setId(id);
                    return repository.save(description);
                });
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
