package DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.entidades;

import DIO_APIREST_WITH_SPRINGBOOT.lab1_java_bootcamp.enuns.FoneTipo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoneTipo tipo;

    @Column(nullable = false)
    private String numero;
}