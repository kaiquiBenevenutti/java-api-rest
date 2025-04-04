package med.volli.api.domain.pacientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.volli.api.domain.enderecos.DadosCadastroEnderecos;

public record DadosCadastroPacientes(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        String cpf,

        @NotNull
        @Valid
        DadosCadastroEnderecos endereco) {
}
