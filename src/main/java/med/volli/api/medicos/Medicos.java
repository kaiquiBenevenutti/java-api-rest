package med.volli.api.medicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidades especialidade;

    @Embedded
    private Enderecos endereco;

    public Medicos(DadosCadastroMedicos dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Enderecos(dados.endereco());
    }

    public void AtualizaDados(@Valid DadosAtualizaMedicos dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.AtualizaDados(dados.endereco());
        }
    }
}
