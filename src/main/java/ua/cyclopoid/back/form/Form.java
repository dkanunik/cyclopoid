package ua.cyclopoid.back.form;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ua.cyclopoid.back.property.Property;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity()
@NoArgsConstructor
@Table(name = "form")
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Form {

    @Id
    @Column(name = "formId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "form", cascade = CascadeType.ALL)
    private Set<Property> properties = new HashSet<>();

    public void addProperty(Property property) {
        this.properties.add(property);
        property.setForm(this);
    }
}
