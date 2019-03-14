package ua.cyclopoid.back.form.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.cyclopoid.back.form.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
}
