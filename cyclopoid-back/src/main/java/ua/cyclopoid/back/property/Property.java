package ua.cyclopoid.back.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import ua.cyclopoid.back.form.Form;

import javax.persistence.*;

@Data
@Entity()
@Table(name = "property")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Property {

    @Id
    @Column(name = "propertyId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @JoinColumn(name = "formId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Form form;

}
