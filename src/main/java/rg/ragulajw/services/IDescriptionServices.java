package rg.ragulajw.services;

import rg.ragulajw.data.domain.Description;
import rg.ragulajw.data.domain.Image;

import java.util.List;

public interface IDescriptionServices {
    Description add(Description description);
    Description getById(long id);
    List<Description> getAll();
    Description update(Description description, long id);
    void deleteById(long id);

    Description getByUserId(long userId);
}
