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
    private Long id;

    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidades especialidade;

    @Embedded
    private Enderecos endereco;

    public Medicos(DadosCadastroMedicos dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Enderecos(dados.endereco());
    }
}
