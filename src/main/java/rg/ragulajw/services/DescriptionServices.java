package rg.ragulajw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rg.ragulajw.data.domain.Description;
import rg.ragulajw.data.domain.SingleDescription;
import rg.ragulajw.repositories.DescriptionRepository;

import java.util.List;

@Service
public class DescriptionServices implements IDescriptionServices {

    @Autowired
    DescriptionRepository repository;
    @Autowired
    SingleDescriptionServices descriptionServices;

    @Override
    public Description add(Description description) {
        return repository.save(description);
    }

    @Override
    public Description getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Description> getAll() {
        return repository.findAll();
    }

    @Override
    public Description update(Description description, long id) {

        for (SingleDescription d : description.getDescriptions())
        {
            if(d.getId() > 0)
            {
                descriptionServices.update(d, d.getId());
            }else{
                descriptionServices.add(d);
            }
        }

        return repository.findById(id)
                .map(old -> {
                    old.setText(description.getText());
                    old.setUser(description.getUser());
                    old.setDescriptions(description.getDescriptions());
                    old.setProfileImage(description.getProfileImage());
                    return repository.save(old);
                })
                .orElseGet(() -> repository.save(description));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Description getByUserId(long userId) {
        return repository.findByUser_Id(userId);
    }
}
