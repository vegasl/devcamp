package mission03.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Doggo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)  private Integer id;
    private String name;
    private String type;
    private Boolean isFavourite;
}
