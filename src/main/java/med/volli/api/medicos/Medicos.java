package med.volli.api.medicos;

import jakarta.persistence.*;
import lombok.*;
import med.volli.api.enderecos.Enderecos;

@Entity(name = "vollmed")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Medicos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidades especialidade;

    @Embedded
    private Enderecos endereco;
}
