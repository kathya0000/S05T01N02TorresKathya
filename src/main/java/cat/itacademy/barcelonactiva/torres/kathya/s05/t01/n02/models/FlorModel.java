package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "Flor")
public class FlorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_FlorID;
    private String nameFlor;
    private String paisFlor;
    private String TipoFlor;
}
