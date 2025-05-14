package beans.jpa.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Item {

    @Id
    private Integer id;

    private String name;

}
