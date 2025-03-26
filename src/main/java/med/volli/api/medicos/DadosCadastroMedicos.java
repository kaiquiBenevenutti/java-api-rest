package med.volli.api.medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.volli.api.enderecos.DadosCadastroEnderecos;

public record DadosCadastroMedicos(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidades especialidade,

        @NotNull
        @Valid
        DadosCadastroEnderecos endereco) {
}
