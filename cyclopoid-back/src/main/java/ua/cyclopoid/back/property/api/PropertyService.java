package ua.cyclopoid.back.property.api;

import org.springframework.stereotype.Component;
import ua.cyclopoid.back.property.Property;

import java.util.List;

@Component()
public interface PropertyService {

    Property save(Property property);

    List<Property> findAll();

    Property getPropertyById(Long formId);

}
