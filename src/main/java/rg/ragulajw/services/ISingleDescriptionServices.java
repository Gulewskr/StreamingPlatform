package rg.ragulajw.services;

import rg.ragulajw.data.domain.SingleDescription;

import java.util.List;

public interface ISingleDescriptionServices {
    SingleDescription add(SingleDescription description);
    SingleDescription getById(long id);
    List<SingleDescription> getAll();
    SingleDescription update(SingleDescription description, long id);
    void deleteById(long id);
}
