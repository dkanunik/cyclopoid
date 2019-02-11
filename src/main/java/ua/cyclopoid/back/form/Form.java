package ua.cyclopoid.back.form;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity()
public class Form {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    public Form() {
    }

    public Form(String name) {
        this.name = name;
    }

}
