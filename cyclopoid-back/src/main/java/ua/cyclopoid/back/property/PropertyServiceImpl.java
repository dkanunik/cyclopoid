package ua.cyclopoid.back.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ua.cyclopoid.back.property.api.PropertyRepository;
import ua.cyclopoid.back.property.api.PropertyService;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Lazy
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property save(Property property) {
        return this.propertyRepository.save(property);
    }

    @Override
    public List<Property> findAll() {
        return this.propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(Long formId) {
        return this.propertyRepository.getOne(formId);
    }
}
