package ua.cyclopoid.back.property.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cyclopoid.back.property.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}

