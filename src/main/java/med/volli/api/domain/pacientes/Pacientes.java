package med.volli.api.domain.pacientes;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import med.volli.api.domain.enderecos.Enderecos;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cpf;

    @Embedded
    private Enderecos endereco;

    private boolean ativo;

    public Pacientes(DadosCadastroPacientes dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Enderecos(dados.endereco());
    }

    public void AtualizaDados(@Valid DadosAtualizaPaciente dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null) {
            this.endereco.AtualizaDadosPaciente(dados.endereco());
        }
    }

    public void ExcluirPaciente() {
        this.ativo = false;
    }
}
